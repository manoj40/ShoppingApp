package com.carrefour.shopping.productmanagement.logic.api.to;

import com.carrefour.shopping.productmanagement.common.api.Product;
import com.devonfw.module.basic.common.api.to.AbstractEto;

/**
 * Entity transport object of Product
 */
public class ProductEto extends AbstractEto implements Product {

  private static final long serialVersionUID = 1L;

  private String name;

  private String type;

  private Long quantity;

  private Double price;

  @Override
  public String getName() {

    return name;
  }

  @Override
  public void setName(String name) {

    this.name = name;
  }

  @Override
  public String getType() {

    return type;
  }

  @Override
  public void setType(String type) {

    this.type = type;
  }

  @Override
  public Long getQuantity() {

    return quantity;
  }

  @Override
  public void setQuantity(Long quantity) {

    this.quantity = quantity;
  }

  @Override
  public Double getPrice() {

    return price;
  }

  @Override
  public void setPrice(Double price) {

    this.price = price;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
    result = prime * result + ((this.type == null) ? 0 : this.type.hashCode());
    result = prime * result + ((this.quantity == null) ? 0 : this.quantity.hashCode());
    result = prime * result + ((this.price == null) ? 0 : this.price.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    // class check will be done by super type EntityTo!
    if (!super.equals(obj)) {
      return false;
    }
    ProductEto other = (ProductEto) obj;
    if (this.name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!this.name.equals(other.name)) {
      return false;
    }
    if (this.type == null) {
      if (other.type != null) {
        return false;
      }
    } else if (!this.type.equals(other.type)) {
      return false;
    }
    if (this.quantity == null) {
      if (other.quantity != null) {
        return false;
      }
    } else if (!this.quantity.equals(other.quantity)) {
      return false;
    }
    if (this.price == null) {
      if (other.price != null) {
        return false;
      }
    } else if (!this.price.equals(other.price)) {
      return false;
    }
    return true;
  }
}
