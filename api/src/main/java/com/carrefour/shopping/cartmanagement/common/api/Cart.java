package com.carrefour.shopping.cartmanagement.common.api;

import java.util.List;

import com.carrefour.shopping.general.common.api.ApplicationEntity;
import com.carrefour.shopping.ordermanagement.logic.api.to.ProductQuantityEto;

public interface Cart extends ApplicationEntity {

  /**
   * @return userNameId
   */
  public String getUserName();

  /**
   * @param userName setter for userName attribute
   */
  public void setUserName(String userName);

  /**
   * @return productIdId
   */
  public List<ProductQuantityEto> getProducts();

  /**
   * @param products new value of {@link #getproducts}.
   */
  public void setProducts(List<ProductQuantityEto> products);

}
