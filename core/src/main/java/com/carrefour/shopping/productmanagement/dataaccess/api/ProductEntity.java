package com.carrefour.shopping.productmanagement.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.carrefour.shopping.general.dataaccess.api.ApplicationPersistenceEntity;
import com.carrefour.shopping.productmanagement.common.api.Product;

/**
 * TODO lakshman This type ...
 */
@Entity
@Table(name = "Product")
public class ProductEntity extends ApplicationPersistenceEntity implements Product {

  @NotNull
  private String name;

  @NotNull
  private String type;

  @NotNull
  private Long quantity;

  @NotNull
  private Double price;

  private static final long serialVersionUID = 1L;

  /**
   * @return name
   */
  @Override
  public String getName() {

    return this.name;
  }

  /**
   * @param name new value of {@link #getname}.
   */
  @Override
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return type
   */
  @Override
  public String getType() {

    return this.type;
  }

  /**
   * @param type new value of {@link #gettype}.
   */
  @Override
  public void setType(String type) {

    this.type = type;
  }

  /**
   * @return quantity
   */
  @Override
  public Long getQuantity() {

    return this.quantity;
  }

  /**
   * @param quantity new value of {@link #getquantity}.
   */
  @Override
  public void setQuantity(Long quantity) {

    this.quantity = quantity;
  }

  /**
   * @return price
   */
  @Override
  public Double getPrice() {

    return this.price;
  }

  /**
   * @param price new value of {@link #getprice}.
   */
  @Override
  public void setPrice(Double price) {

    this.price = price;
  }

}
