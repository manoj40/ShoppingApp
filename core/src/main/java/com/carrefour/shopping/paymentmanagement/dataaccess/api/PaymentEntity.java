package com.carrefour.shopping.paymentmanagement.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.carrefour.shopping.general.dataaccess.api.ApplicationPersistenceEntity;
import com.carrefour.shopping.paymentmanagement.common.api.Payment;

/**
 * TODO lakshman This type ...
 */
@Entity
@Table(name = "Payment")
public class PaymentEntity extends ApplicationPersistenceEntity implements Payment {

  private Long cardId;

  private String userName;

  private Double amount;

  private boolean paymentStatus;

  private static final long serialVersionUID = 1L;

  /**
   * @return cardId
   */
  @Override
  public Long getCardId() {

    return this.cardId;
  }

  /**
   * @param cardId new value of {@link #getcardId}.
   */
  @Override
  public void setCardId(Long cardId) {

    this.cardId = cardId;
  }

  /**
   * @return userName
   */
  @Override
  public String getUserName() {

    return this.userName;
  }

  /**
   * @param userName new value of {@link #getuserName}.
   */
  @Override
  public void setUserName(String userName) {

    this.userName = userName;
  }

  /**
   * @return amount
   */
  @Override
  public Double getAmount() {

    return this.amount;
  }

  /**
   * @param amount new value of {@link #getamount}.
   */
  @Override
  public void setAmount(Double amount) {

    this.amount = amount;
  }

  /**
   * @return paymentStatus
   */
  @Override
  public boolean isPaymentStatus() {

    return this.paymentStatus;
  }

  /**
   * @param paymentStatus new value of {@link #getpaymentStatus}.
   */
  @Override
  public void setPaymentStatus(boolean paymentStatus) {

    this.paymentStatus = paymentStatus;
  }


}
