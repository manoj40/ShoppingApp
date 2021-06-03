package com.carrefour.shopping.usermanagement.common.api;

import com.carrefour.shopping.general.common.api.ApplicationEntity;

public interface User extends ApplicationEntity {

  /**
   * @return nameId
   */
  public String getName();

  /**
   * @param name setter for name attribute
   */
  public void setName(String name);

  /**
   * @return passwordId
   */
  public String getPassword();

  /**
   * @param password setter for password attribute
   */
  public void setPassword(String password);

}
