package com.carrefour.shopping.paymentmanagement.logic.impl.usecase;

import java.util.Optional;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.carrefour.shopping.paymentmanagement.dataaccess.api.PaymentEntity;
import com.carrefour.shopping.paymentmanagement.logic.api.to.PaymentEto;
import com.carrefour.shopping.paymentmanagement.logic.api.usecase.UcFindPayment;
import com.carrefour.shopping.paymentmanagement.logic.base.usecase.AbstractPaymentUc;

/**
 * Use case implementation for searching, filtering and getting Payments
 */
@Named
@Validated
@Transactional
public class UcFindPaymentImpl extends AbstractPaymentUc implements UcFindPayment {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindPaymentImpl.class);

  @Override
  public PaymentEto findPayment(long id) {

    LOG.debug("Get Payment with id {} from database.", id);
    Optional<PaymentEntity> foundEntity = getPaymentRepository().findById(id);
    if (foundEntity.isPresent())
      return getBeanMapper().map(foundEntity.get(), PaymentEto.class);
    else
      return null;
  }

}
