package com.carrefour.shopping.ordermanagement.logic.api.to;

import java.time.LocalDateTime;
import java.util.List;

import com.carrefour.shopping.general.common.api.to.AbstractSearchCriteriaTo;
import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;

/**
 * {@link SearchCriteriaTo} to find instances of {@link com.carrefour.shopping.ordermanagement.common.api.Order}s.
 */
public class OrderSearchCriteriaTo extends AbstractSearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String userName;

  private List<ProductQuantityEto> products;

  private Double amount;

  private Boolean status;

  private LocalDateTime orderTime;

  private String fromOrderTime;

  private String toOrderTime;

  private StringSearchConfigTo userNameOption;

  /**
   * @return userNameId
   */

  public String getUserName() {

    return this.userName;
  }

  /**
   * @param userName setter for userName attribute
   */

  public void setUserName(String userName) {

    this.userName = userName;
  }

  /**
   * @return productsId
   */

  public List<ProductQuantityEto> getProducts() {

    return this.products;
  }

  /**
   * @param products setter for products attribute
   */

  public void setProducts(List<ProductQuantityEto> products) {

    this.products = products;
  }

  /**
   * @return amountId
   */

  public Double getAmount() {

    return this.amount;
  }

  /**
   * @param amount setter for amount attribute
   */

  public void setAmount(Double amount) {

    this.amount = amount;
  }

  /**
   * @return statusId
   */

  public Boolean getStatus() {

    return this.status;
  }

  /**
   * @param status setter for status attribute
   */

  public void setStatus(Boolean status) {

    this.status = status;
  }

  /**
   * @return orderTimeId
   */

  public LocalDateTime getOrderTime() {

    return this.orderTime;
  }

  /**
   * @param orderTime setter for orderTime attribute
   */

  public void setOrderTime(LocalDateTime orderTime) {

    this.orderTime = orderTime;
  }

  /**
   * @return fromOrderTime
   */
  public String getFromOrderTime() {

    return this.fromOrderTime;
  }

  /**
   * @param fromOrderTime new value of {@link #getfromOrderTime}.
   */
  public void setFromOrderTime(String fromOrderTime) {

    this.fromOrderTime = fromOrderTime;
  }

  /**
   * @return toOrderTime
   */
  public String getToOrderTime() {

    return this.toOrderTime;
  }

  /**
   * @param toOrderTime new value of {@link #gettoOrderTime}.
   */
  public void setToOrderTime(String toOrderTime) {

    this.toOrderTime = toOrderTime;
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
