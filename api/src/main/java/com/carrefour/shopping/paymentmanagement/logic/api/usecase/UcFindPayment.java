package com.carrefour.shopping.paymentmanagement.logic.api.usecase;

import com.carrefour.shopping.paymentmanagement.logic.api.to.PaymentEto;

public interface UcFindPayment {

  /**
   * Returns a Payment by its id 'id'.
   *
   * @param id The id 'id' of the Payment.
   * @return The {@link PaymentEto} with id 'id'
   */
  PaymentEto findPayment(long id);

}
