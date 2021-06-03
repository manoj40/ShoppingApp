package com.carrefour.shopping.ordermanagement.logic.impl.usecase;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.carrefour.shopping.cardmanagement.logic.api.Cardmanagement;
import com.carrefour.shopping.ordermanagement.dataaccess.api.OrderEntity;
import com.carrefour.shopping.ordermanagement.logic.api.to.OrderCto;
import com.carrefour.shopping.ordermanagement.logic.api.to.OrderEto;
import com.carrefour.shopping.ordermanagement.logic.api.usecase.UcManageOrder;
import com.carrefour.shopping.ordermanagement.logic.base.usecase.AbstractOrderUc;
import com.carrefour.shopping.paymentmanagement.logic.api.Paymentmanagement;
import com.carrefour.shopping.paymentmanagement.logic.api.to.PaymentEto;
import com.carrefour.shopping.productmanagement.logic.api.Productmanagement;

/**
 * Use case implementation for modifying and deleting Orders
 */
@Named
@Validated
@Transactional
public class UcManageOrderImpl extends AbstractOrderUc implements UcManageOrder {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcManageOrderImpl.class);

  @Inject
  private Paymentmanagement paymentManagement;

  @Inject
  private Cardmanagement cardManagement;

  @Inject
  private Productmanagement productManagement;

  @Override
  public OrderEto saveOrder(OrderCto order) {

    Objects.requireNonNull(order, "order");

    // validate card details
    if (this.cardManagement.isValidCreditCard(order.getCard())) {

      PaymentEto payment = new PaymentEto();
      payment.setAmount(order.getOrder().getAmount());
      payment.setPaymentStatus(true);
      payment.setUserName(order.getCard().getUserName());
      payment.setCardId(this.cardManagement.findCard(order.getCard().getCreditCardNumber()).getId());

      // make payment
      payment = this.paymentManagement.savePayment(payment);

      OrderEntity orderEntity = getBeanMapper().map(order.getOrder(), OrderEntity.class);
      orderEntity.setPaymentId(payment.getId());
      orderEntity.setOrderTime(LocalDateTime.now());
      orderEntity.setStatus(true);

      // initialize, validate orderEntity here if necessary
      OrderEntity resultEntity = getOrderRepository().save(orderEntity);

      // adjust products quantity
      this.productManagement.updateProductQuantities(order.getOrder().getProducts());

      LOG.debug("Order with id '{}' has been created.", resultEntity.getId());
      return getBeanMapper().map(resultEntity, OrderEto.class);

    } else {
      throw new RuntimeException("Invalid credit card detials. Payment failed. Please try again!!");
    }

  }

}
