package com.carrefour.shopping.paymentmanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.carrefour.shopping.general.logic.base.AbstractComponentFacade;
import com.carrefour.shopping.paymentmanagement.logic.api.Paymentmanagement;
import com.carrefour.shopping.paymentmanagement.logic.api.to.PaymentEto;
import com.carrefour.shopping.paymentmanagement.logic.api.usecase.UcFindPayment;
import com.carrefour.shopping.paymentmanagement.logic.api.usecase.UcManagePayment;

/**
 * Implementation of component interface of paymentmanagement
 */
@Named
public class PaymentmanagementImpl extends AbstractComponentFacade implements Paymentmanagement {

  @Inject
  private UcFindPayment ucFindPayment;

  @Inject
  private UcManagePayment ucManagePayment;

  @Override
  public PaymentEto findPayment(long id) {

    return this.ucFindPayment.findPayment(id);
  }

  @Override
  public PaymentEto savePayment(PaymentEto payment) {

    return this.ucManagePayment.savePayment(payment);
  }

}
