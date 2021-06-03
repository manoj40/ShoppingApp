package com.carrefour.shopping.usermanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.data.domain.Page;

import com.carrefour.shopping.usermanagement.logic.api.Usermanagement;
import com.carrefour.shopping.usermanagement.logic.api.to.UserEto;
import com.carrefour.shopping.usermanagement.logic.api.to.UserSearchCriteriaTo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Usermanagement}.
 */
@EnableSwagger2
@Api(value = "User", description = "REST API for User Management", tags = { "User" })
@Path("/usermanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface UsermanagementRestService {

  /**
   * Delegates to {@link Usermanagement#findUser}.
   *
   * @param id the ID of the {@link UserEto}
   * @return the {@link UserEto}
   */
  @ApiOperation(value = "API to get User by Id", tags = { "User" })
  @ApiResponses(value = { @ApiResponse(code = 200, message = "User Data", response = UserEto.class),
  @ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 401, message = "Unauthorized"),
  @ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 404, message = "Not Found") })
  @GET
  @Path("/user/{id}/")
  public UserEto getUser(@PathParam("id") long id);

  /**
   * Delegates to {@link Usermanagement#saveUser}.
   *
   * @param user the {@link UserEto} to be saved
   * @return the recently created {@link UserEto}
   */
  @POST
  @Path("/user/")
  public UserEto saveUser(UserEto user);

  /**
   * Delegates to {@link Usermanagement#deleteUser}.
   *
   * @param id ID of the {@link UserEto} to be deleted
   */
  @DELETE
  @Path("/user/{id}/")
  public void deleteUser(@PathParam("id") long id);

  /**
   * Delegates to {@link Usermanagement#findUserEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding users.
   * @return the {@link Page list} of matching {@link UserEto}s.
   */
  @Path("/user/search")
  @POST
  public Page<UserEto> findUsers(UserSearchCriteriaTo searchCriteriaTo);

}