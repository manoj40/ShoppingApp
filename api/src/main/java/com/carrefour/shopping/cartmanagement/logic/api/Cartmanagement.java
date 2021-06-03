package com.carrefour.shopping.cartmanagement.logic.api;

import com.carrefour.shopping.cartmanagement.logic.api.to.CartEto;
import com.carrefour.shopping.cartmanagement.logic.api.usecase.UcFindCart;
import com.carrefour.shopping.cartmanagement.logic.api.usecase.UcManageCart;

/**
 * Interface for Cartmanagement component.
 */
public interface Cartmanagement extends UcFindCart, UcManageCart {

  /**
   * @param userName
   * @return
   */
  @Override
  CartEto findCartByUserName(String userName);

}
