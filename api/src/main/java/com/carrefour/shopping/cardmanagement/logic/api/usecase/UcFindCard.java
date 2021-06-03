package com.carrefour.shopping.cardmanagement.logic.api.usecase;

import com.carrefour.shopping.cardmanagement.logic.api.to.CardEto;

public interface UcFindCard {

  /**
   * Returns a Card by its id 'id'.
   *
   * @param id The id 'id' of the Card.
   * @return The {@link CardEto} with id 'id'
   */
  CardEto findCard(long id);

  CardEto findCard(String creditCardNumber);

}
