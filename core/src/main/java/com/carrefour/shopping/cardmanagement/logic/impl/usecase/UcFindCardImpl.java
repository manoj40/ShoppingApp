package com.carrefour.shopping.cardmanagement.logic.impl.usecase;

import java.util.Optional;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.carrefour.shopping.cardmanagement.dataaccess.api.CardEntity;
import com.carrefour.shopping.cardmanagement.logic.api.to.CardEto;
import com.carrefour.shopping.cardmanagement.logic.api.usecase.UcFindCard;
import com.carrefour.shopping.cardmanagement.logic.base.usecase.AbstractCardUc;

/**
 * Use case implementation for searching, filtering and getting Cards
 */
@Named
@Validated
@Transactional
public class UcFindCardImpl extends AbstractCardUc implements UcFindCard {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindCardImpl.class);

  @Override
  public CardEto findCard(long id) {

    LOG.debug("Get Card with id {} from database.", id);
    Optional<CardEntity> foundEntity = getCardRepository().findById(id);
    if (foundEntity.isPresent())
      return getBeanMapper().map(foundEntity.get(), CardEto.class);
    else
      return null;
  }

  @Override
  public CardEto findCard(String creditCardNumber) {

    LOG.debug("Get Card with creditCardNumber {} from database.", creditCardNumber);
    Optional<CardEntity> foundEntity = getCardRepository().findByCreditCardNumber(creditCardNumber);
    if (foundEntity.isPresent())
      return getBeanMapper().map(foundEntity.get(), CardEto.class);
    else
      return null;

  }

}
