package com.carrefour.shopping.general.service.impl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * TODO lakshman This type ...
 *
 */
@Configuration
public class BaseWebMvcConfigurer {

  @Bean
  public WebMvcConfigurer corsConfigurer() {

    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**").allowedOrigins("*").allowedHeaders("*").allowedMethods("*");
      }
    };
  }
}