package com.carrefour.shopping.cartmanagement.logic.api.to;

import com.carrefour.shopping.general.common.api.to.AbstractSearchCriteriaTo;
import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;

/**
 * {@link SearchCriteriaTo} to find instances of {@link com.carrefour.shopping.cartmanagement.common.api.Cart}s.
 */
public class CartSearchCriteriaTo extends AbstractSearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String userName;

  private Long productId;

  private Long quantity;

  private StringSearchConfigTo userNameOption;

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
   * @return productIdId
   */
  public Long getProductId() {

    return productId;
  }

  /**
   * @param productId setter for productId attribute
   */
  public void setProductId(Long productId) {

    this.productId = productId;
  }

  /**
   * @return quantityId
   */
  public Long getQuantity() {

    return quantity;
  }

  /**
   * @param quantity setter for quantity attribute
   */
  public void setQuantity(Long quantity) {

    this.quantity = quantity;
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
