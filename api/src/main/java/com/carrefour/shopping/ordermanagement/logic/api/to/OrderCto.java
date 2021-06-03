package com.carrefour.shopping.ordermanagement.logic.api.to;

import com.carrefour.shopping.cardmanagement.logic.api.to.CardEto;
import com.devonfw.module.basic.common.api.to.AbstractCto;

/**
 * Composite transport object of Order
 */
public class OrderCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private OrderEto order;

  private CardEto card;

  /**
   * @return order
   */
  public OrderEto getOrder() {

    return this.order;
  }

  /**
   * @param order new value of {@link #getorder}.
   */
  public void setOrder(OrderEto order) {

    this.order = order;
  }

  /**
   * @return card
   */
  public CardEto getCard() {

    return this.card;
  }

  /**
   * @param card new value of {@link #getcard}.
   */
  public void setCard(CardEto card) {

    this.card = card;
  }

}
