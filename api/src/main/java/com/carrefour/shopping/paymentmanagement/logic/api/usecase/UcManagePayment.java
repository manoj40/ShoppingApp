package com.carrefour.shopping.paymentmanagement.logic.api.usecase;

import com.carrefour.shopping.paymentmanagement.logic.api.to.PaymentEto;

/**
 * Interface of UcManagePayment to centralize documentation and signatures of methods.
 */
public interface UcManagePayment {

  /**
   * Saves a payment and store it in the database.
   *
   * @param payment the {@link PaymentEto} to create.
   * @return the new {@link PaymentEto} that has been saved with ID and version.
   */
  PaymentEto savePayment(PaymentEto payment);

}
