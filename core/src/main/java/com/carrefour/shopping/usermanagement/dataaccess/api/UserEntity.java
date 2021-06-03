package com.carrefour.shopping.usermanagement.dataaccess.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.carrefour.shopping.general.dataaccess.api.ApplicationPersistenceEntity;
import com.carrefour.shopping.usermanagement.common.api.User;

/**
 * TODO lakshman This type ...
 */
@Entity
@Table(name = "User")
public class UserEntity extends ApplicationPersistenceEntity implements User {

  @Column(unique = true, nullable = false)
  private String name;

  private String password;

  private String roles;

  private static final long serialVersionUID = 1L;

  /**
   * @return roles
   */
  public String getRoles() {

    return this.roles;
  }

  /**
   * @param roles new value of {@link #getroles}.
   */
  public void setRoles(String roles) {

    this.roles = roles;
  }

  /**
   * @return name
   */
  @Override
  public String getName() {

    return this.name;
  }

  /**
   * @param name new value of {@link #getname}.
   */
  @Override
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return password
   */
  @Override
  public String getPassword() {

    return this.password;
  }

  /**
   * @param password new value of {@link #getpassword}.
   */
  @Override
  public void setPassword(String password) {

    this.password = password;
  }

}
