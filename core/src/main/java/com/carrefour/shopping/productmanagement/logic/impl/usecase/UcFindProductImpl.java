package com.carrefour.shopping.productmanagement.logic.impl.usecase;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.carrefour.shopping.productmanagement.dataaccess.api.ProductEntity;
import com.carrefour.shopping.productmanagement.logic.api.to.ProductEto;
import com.carrefour.shopping.productmanagement.logic.api.to.ProductSearchCriteriaTo;
import com.carrefour.shopping.productmanagement.logic.api.to.StockEto;
import com.carrefour.shopping.productmanagement.logic.api.usecase.UcFindProduct;
import com.carrefour.shopping.productmanagement.logic.base.usecase.AbstractProductUc;

/**
 * Use case implementation for searching, filtering and getting Products
 */
@Named
@Validated
@Transactional
public class UcFindProductImpl extends AbstractProductUc implements UcFindProduct {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindProductImpl.class);

  @Override
  public ProductEto findProduct(long id) {

    LOG.debug("Get Product with id {} from database.", id);
    Optional<ProductEntity> foundEntity = getProductRepository().findById(id);
    if (foundEntity.isPresent())
      return getBeanMapper().map(foundEntity.get(), ProductEto.class);
    else
      return null;
  }

  @Override
  public Page<ProductEto> findProducts(ProductSearchCriteriaTo criteria) {

    Page<ProductEntity> products = getProductRepository().findByCriteria(criteria);
    return mapPaginatedEntityList(products, ProductEto.class);
  }

  @Override
  public List<ProductEto> fetchAllProducts(String type) {

    if (type != null && !type.isEmpty()) {
      return productsInStock(getBeanMapper().mapList(getProductRepository().findByType(type), ProductEto.class));
    } else {
      return productsInStock(getBeanMapper().mapList(getProductRepository().findAll(), ProductEto.class));
    }
  }

  private List<ProductEto> productsInStock(List<ProductEto> products) {

    return products.stream().filter(product -> product.getQuantity() > 0).collect(Collectors.toList());
  }

  @Override
  public List<ProductEto> findProducts(Set<Long> ids) {

    LOG.debug("Get Products with ids {} from database.", ids);

    return getBeanMapper().mapList(getProductRepository().findAllById(ids), ProductEto.class);
  }

  @Override
  public List<StockEto> fetchAllStock() {

    LOG.debug("Get Stock from database.");

    return getBeanMapper().mapList(getProductRepository().findByQuantityGreaterThan(0L), StockEto.class);
  }

}
