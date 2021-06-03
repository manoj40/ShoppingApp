package com.carrefour.shopping.productmanagement.service.api.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.data.domain.Page;

import com.carrefour.shopping.productmanagement.logic.api.Productmanagement;
import com.carrefour.shopping.productmanagement.logic.api.to.ProductEto;
import com.carrefour.shopping.productmanagement.logic.api.to.ProductSearchCriteriaTo;
import com.carrefour.shopping.productmanagement.logic.api.to.StockEto;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Productmanagement}.
 */
@Path("/productmanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface ProductmanagementRestService {

  /**
   * Delegates to {@link Productmanagement#findProductEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding products.
   * @return the {@link Page list} of matching {@link ProductEto}s.
   */
  @Path("/product/search")
  @POST
  public Page<ProductEto> findProducts(ProductSearchCriteriaTo searchCriteriaTo);

  /**
   * @param type
   * @return
   */
  @Path("/product")
  @GET
  public List<ProductEto> fetchAllProducts(@QueryParam(value = "type") String type);

  /**
   * @return
   */
  @Path("/product/stock")
  @GET
  public List<StockEto> fetchAllStock();

}
