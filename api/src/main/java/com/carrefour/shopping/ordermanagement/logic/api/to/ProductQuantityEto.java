package com.carrefour.shopping.ordermanagement.logic.api.to;

import com.devonfw.module.basic.common.api.to.AbstractEto;

/**
 * TODO komaldhuri This type ...
 *
 */
public class ProductQuantityEto extends AbstractEto {

  private Long productId;

  private Long quantity;

  public ProductQuantityEto() {

  }

  /**
   * The constructor.
   *
   * @param productId
   * @param quantity
   */
  public ProductQuantityEto(Long productId, Long quantity) {

    super();
    this.productId = productId;
    this.quantity = quantity;
  }

  public ProductQuantityEto(String jsonString) {

    System.out.println();
  }

  /**
   * @return productId
   */
  public Long getProductId() {

    return this.productId;
  }

  /**
   * @param productId new value of {@link #getproductId}.
   */
  public void setProductId(Long productId) {

    this.productId = productId;
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
