package com.carrefour.shopping.paymentmanagement.logic.api.to;

import com.carrefour.shopping.paymentmanagement.common.api.Payment;
import com.devonfw.module.basic.common.api.to.AbstractEto;

/**
 * Entity transport object of Payment
 */
public class PaymentEto extends AbstractEto implements Payment {

  private static final long serialVersionUID = 1L;

  private Double amount;

  private boolean paymentStatus;

  private Long cardId;

  private String userName;

  @Override
  public Double getAmount() {

    return this.amount;
  }

  @Override
  public void setAmount(Double amount) {

    this.amount = amount;
  }

  @Override
  public boolean isPaymentStatus() {

    return this.paymentStatus;
  }

  @Override
  public void setPaymentStatus(boolean paymentStatus) {

    this.paymentStatus = paymentStatus;
  }

  @Override
  public Long getCardId() {

    return this.cardId;
  }

  @Override
  public void setCardId(Long cardId) {

    this.cardId = cardId;
  }

  @Override
  public String getUserName() {

    return this.userName;
  }

  @Override
  public void setUserName(String userName) {

    this.userName = userName;
  }

}
