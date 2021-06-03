package com.carrefour.shopping.ordermanagement.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.carrefour.shopping.ordermanagement.dataaccess.api.OrderEntity;
import com.carrefour.shopping.ordermanagement.logic.api.to.OrderSearchCriteriaTo;
import com.carrefour.shopping.ordermanagement.logic.api.to.ProductQuantityEto;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

//TODO KD - check and fix the commented lines below
/**
 * {@link DefaultRepository} for {@link OrderEntity}
 */
public interface OrderRepository extends DefaultRepository<OrderEntity> {

  /**
   * @param criteria the {@link OrderSearchCriteriaTo} with the criteria to search.
   * @return the {@link Page} of the {@link OrderEntity} objects that matched the search. If no pageable is set, it will
   *         return a unique page with all the objects that matched the search.
   */
  default Page<OrderEntity> findByCriteria(OrderSearchCriteriaTo criteria) {

    OrderEntity alias = newDslAlias();
    JPAQuery<OrderEntity> query = newDslQuery(alias);

    String userName = criteria.getUserName();
    if (userName != null && !userName.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getUserName()), userName, criteria.getUserNameOption());
    }
    List<ProductQuantityEto> products = criteria.getProducts();
    if (products != null) {
      for (ProductQuantityEto product : products) {
        query.where($(alias.getProducts()).contains(product));
      }
    }
    Double amount = criteria.getAmount();
    if (amount != null) {
      query.where($(alias.getAmount()).eq(amount));
    }
    Boolean status = criteria.getStatus();
    if (status != null) {
      query.where($(alias.isStatus()).eq(status));
    }
    LocalDateTime orderTime = criteria.getOrderTime();
    if (orderTime != null) {
      query.where($(alias.getOrderTime()).eq(orderTime));
    }
    LocalDateTime fromOrderDate = parseDate(criteria.getFromOrderTime());
    LocalDateTime toOrderDate = parseDate(criteria.getToOrderTime());
    if (fromOrderDate != null && toOrderDate != null) {
      query.where($(alias.getOrderTime()).between(fromOrderDate, toOrderDate));
    }
    if (criteria.getPageable() == null) {
      criteria.setPageable(PageRequest.of(0, Integer.MAX_VALUE));
    } else {
      addOrderBy(query, alias, criteria.getPageable().getSort());
    }

    return QueryUtil.get().findPaginated(criteria.getPageable(), query, true);
  }

  /**
   * Add sorting to the given query on the given alias
   *
   * @param query to add sorting to
   * @param alias to retrieve columns from for sorting
   * @param sort specification of sorting
   */
  public default void addOrderBy(JPAQuery<OrderEntity> query, OrderEntity alias, Sort sort) {

    if (sort != null && sort.isSorted()) {
      Iterator<Order> it = sort.iterator();
      while (it.hasNext()) {
        Order next = it.next();
        switch (next.getProperty()) {
          case "userName":
            if (next.isAscending()) {
              query.orderBy($(alias.getUserName()).asc());
            } else {
              query.orderBy($(alias.getUserName()).desc());
            }
            break;
          case "amount":
            if (next.isAscending()) {
              query.orderBy($(alias.getAmount()).asc());
            } else {
              query.orderBy($(alias.getAmount()).desc());
            }
            break;
          case "status":
            if (next.isAscending()) {
              query.orderBy($(alias.getPaymentId()).asc());
            } else {
              query.orderBy($(alias.getPaymentId()).desc());
            }
            break;
          case "orderTime":
            if (next.isAscending()) {
              query.orderBy($(alias.getOrderTime()).asc());
            } else {
              query.orderBy($(alias.getOrderTime()).desc());
            }
            break;
          case "paymentId":
            if (next.isAscending()) {
              query.orderBy($(alias.getPaymentId()).asc());
            } else {
              query.orderBy($(alias.getPaymentId()).desc());
            }
            break;
          default:
            throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
        }
      }
    }
  }

  public static LocalDateTime parseDate(String dateStr) {

    LocalDateTime parsedDate = null;

    if (dateStr != null && !dateStr.isEmpty()) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
      parsedDate = LocalDateTime.parse(dateStr, formatter);
    }

    return parsedDate;
  }

}
