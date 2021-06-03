package com.carrefour.shopping.cardmanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.util.StringUtils;

import com.carrefour.shopping.cardmanagement.logic.api.Cardmanagement;
import com.carrefour.shopping.cardmanagement.logic.api.to.CardEto;
import com.carrefour.shopping.cardmanagement.logic.api.usecase.UcFindCard;
import com.carrefour.shopping.general.logic.base.AbstractComponentFacade;

/**
 * Implementation of component interface of cardmanagement
 */
@Named
public class CardmanagementImpl extends AbstractComponentFacade implements Cardmanagement {

  @Inject
  private UcFindCard ucFindCard;

  @Override
  public CardEto findCard(long id) {

    return this.ucFindCard.findCard(id);
  }

  @Override
  public CardEto findCard(String creditCardNumber) {

    return this.ucFindCard.findCard(creditCardNumber);
  }

  @Override
  public boolean isValidCreditCard(CardEto cardEto) {

    CardEto card = findCard(cardEto.getCreditCardNumber());

    if (card != null && cardEto != null) {
      return !StringUtils.isEmpty(cardEto.getCreditCardNumber()) && !StringUtils.isEmpty(card.getCreditCardNumber())
          && card.getCreditCardNumber().equalsIgnoreCase(card.getCreditCardNumber())
          && !StringUtils.isEmpty(card.getUserName()) && !StringUtils.isEmpty(cardEto.getUserName())
          && card.getUserName().equalsIgnoreCase(cardEto.getUserName());
    }

    return false;
  }

}
