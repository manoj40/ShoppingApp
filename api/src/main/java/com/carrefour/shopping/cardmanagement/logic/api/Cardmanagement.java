package com.carrefour.shopping.cardmanagement.logic.api;

import com.carrefour.shopping.cardmanagement.logic.api.to.CardEto;
import com.carrefour.shopping.cardmanagement.logic.api.usecase.UcFindCard;

/**
 * Interface for Cardmanagement component.
 */
public interface Cardmanagement extends UcFindCard {

  boolean isValidCreditCard(CardEto card);

}
