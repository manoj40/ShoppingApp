package com.carrefour.shopping.productmanagement.common.api;

import com.carrefour.shopping.general.common.api.ApplicationEntity;

public interface Product extends ApplicationEntity {

  /**
   * @return nameId
   */

  public String getName();

  /**
   * @param name setter for name attribute
   */

  public void setName(String name);

  /**
   * @return typeId
   */

  public String getType();

  /**
   * @param type setter for type attribute
   */

  public void setType(String type);

  /**
   * @return quantityId
   */

  public Long getQuantity();

  /**
   * @param quantity setter for quantity attribute
   */

  public void setQuantity(Long quantity);

  /**
   * @return priceId
   */

  public Double getPrice();

  /**
   * @param price setter for price attribute
   */

  public void setPrice(Double price);

}
