package com.carrefour.shopping.general.common.impl.security;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.carrefour.shopping.usermanagement.dataaccess.api.UserEntity;
import com.carrefour.shopping.usermanagement.dataaccess.api.repo.UserRepository;

/**
 * Custom implementation of {@link UserDetailsService}.<br>
 *
 * @see com.carrefour.shopping.general.service.impl.config.BaseWebSecurityConfig
 */
@Named
public class BaseUserDetailsService implements UserDetailsService {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(BaseUserDetailsService.class);

  @Inject
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    Optional<UserEntity> userEntity = this.userRepository.findByName(username);
    if (userEntity.isPresent()) {
      UserEntity user = userEntity.get();
      List<GrantedAuthority> authorities = Arrays.stream(user.getRoles().split(",")).map(SimpleGrantedAuthority::new)
          .collect(Collectors.toList());
      User userData = new User(user.getName(), user.getPassword(), authorities);
      return userData;
    } else {
      UsernameNotFoundException exception = new UsernameNotFoundException("Authentication failed.");
      LOG.warn("Failed to get user {}.", username, exception);
      throw exception;
    }
  }

}
