package com.carrefour.shopping.paymentmanagement.logic.api.to;

import com.carrefour.shopping.general.common.api.to.AbstractSearchCriteriaTo;
import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;

/**
 * {@link SearchCriteriaTo} to find instances of {@link com.carrefour.shopping.paymentmanagement.common.api.Payment}s.
 */
public class PaymentSearchCriteriaTo extends AbstractSearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String creditCardNumber;

  private Double amount;

  private Boolean paymentStatus;

  private StringSearchConfigTo creditCardNumberOption;

  private Long cardId;

  private String userName;

  private StringSearchConfigTo userNameOption;

  /**
   * @return creditCardNumberId
   */
  public String getCreditCardNumber() {

    return creditCardNumber;
  }

  /**
   * @param creditCardNumber setter for creditCardNumber attribute
   */
  public void setCreditCardNumber(String creditCardNumber) {

    this.creditCardNumber = creditCardNumber;
  }

  /**
   * @return amountId
   */
  public Double getAmount() {

    return amount;
  }

  /**
   * @param amount setter for amount attribute
   */
  public void setAmount(Double amount) {

    this.amount = amount;
  }

  /**
   * @return paymentStatusId
   */
  public Boolean getPaymentStatus() {

    return paymentStatus;
  }

  /**
   * @param paymentStatus setter for paymentStatus attribute
   */
  public void setPaymentStatus(Boolean paymentStatus) {

    this.paymentStatus = paymentStatus;
  }

  /**
   * @return the {@link StringSearchConfigTo} used to search for {@link #getCreditCardNumber() creditCardNumber}.
   */
  public StringSearchConfigTo getCreditCardNumberOption() {

    return this.creditCardNumberOption;
  }

  /**
   * @param creditCardNumberOption new value of {@link #getCreditCardNumberOption()}.
   */
  public void setCreditCardNumberOption(StringSearchConfigTo creditCardNumberOption) {

    this.creditCardNumberOption = creditCardNumberOption;
  }

  /**
   * @return cardIdId
   */
  public Long getCardId() {

    return cardId;
  }

  /**
   * @param cardId setter for cardId attribute
   */
  public void setCardId(Long cardId) {

    this.cardId = cardId;
  }

  /**
   * @return userNameId
   */
  public String getUserName() {

    return userName;
  }

  /**
   * @param userName setter for userName attribute
   */
  public void setUserName(String userName) {

    this.userName = userName;
  }

  /**
   * @return the {@link StringSearchConfigTo} used to search for {@link #getUserName() userName}.
   */
  public StringSearchConfigTo getUserNameOption() {

    return this.userNameOption;
  }

  /**
   * @param userNameOption new value of {@link #getUserNameOption()}.
   */
  public void setUserNameOption(StringSearchConfigTo userNameOption) {

    this.userNameOption = userNameOption;
  }

}
