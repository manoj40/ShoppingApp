package com.carrefour.shopping.productmanagement.logic.api.to;

/**
 * TODO lakshman This type ...
 *
 */
public class StockEto {

  private String name;

  private Long quantity;

  /**
   * @return name
   */
  public String getName() {

    return this.name;
  }

  /**
   * @param name new value of {@link #getname}.
   */
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return quantity
   */
  public Long getQuantity() {

    return this.quantity;
  }

  /**
   * @param quantity new value of {@link #getquantity}.
   */
  public void setQuantity(Long quantity) {

    this.quantity = quantity;
  }

}
