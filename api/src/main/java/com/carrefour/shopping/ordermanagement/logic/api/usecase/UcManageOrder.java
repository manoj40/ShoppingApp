package com.carrefour.shopping.ordermanagement.logic.api.usecase;

import com.carrefour.shopping.ordermanagement.logic.api.to.OrderCto;
import com.carrefour.shopping.ordermanagement.logic.api.to.OrderEto;

/**
 * Interface of UcManageOrder to centralize documentation and signatures of methods.
 */
public interface UcManageOrder {

  /**
   * Saves a order and store it in the database.
   *
   * @param order the {@link OrderEto} to create.
   * @return the new {@link OrderEto} that has been saved with ID and version.
   */
  OrderEto saveOrder(OrderCto order);

}
