package com.carrefour.shopping.cardmanagement.dataaccess.api.repo;

import java.util.Optional;

import com.carrefour.shopping.cardmanagement.dataaccess.api.CardEntity;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;

/**
 * {@link DefaultRepository} for {@link CardEntity}
 */
public interface CardRepository extends DefaultRepository<CardEntity> {

  Optional<CardEntity> findByCreditCardNumber(String creditCardNumber);

}
