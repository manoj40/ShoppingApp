package com.carrefour.shopping.productmanagement.service.impl.rest;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.carrefour.shopping.productmanagement.logic.api.Productmanagement;
import com.carrefour.shopping.productmanagement.logic.api.to.ProductEto;
import com.carrefour.shopping.productmanagement.logic.api.to.ProductSearchCriteriaTo;
import com.carrefour.shopping.productmanagement.logic.api.to.StockEto;
import com.carrefour.shopping.productmanagement.service.api.rest.ProductmanagementRestService;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Productmanagement}.
 */
@Named("ProductmanagementRestService")
public class ProductmanagementRestServiceImpl implements ProductmanagementRestService {

  @Inject
  private Productmanagement productmanagement;

  @Override
  public Page<ProductEto> findProducts(ProductSearchCriteriaTo searchCriteriaTo) {

    return this.productmanagement.findProducts(searchCriteriaTo);
  }

  @Override
  @RolesAllowed(value = "user")
  public List<ProductEto> fetchAllProducts(String type) {

    return this.productmanagement.fetchAllProducts(type);
  }

  @Override
  @RolesAllowed(value = "admin")
  public List<StockEto> fetchAllStock() {

    return this.productmanagement.fetchAllStock();
  }

}
