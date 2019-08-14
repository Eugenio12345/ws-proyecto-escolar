/*
* Copyright (C) 2016 by Citigroup. All rights reserved.
* Citigroup claims copyright in this computer program as an unpublished work,
* one or more versions of which were first used to provide services to
* customers on the dates indicated in the foregoing notice. Claim of
* copyright does not imply waiver of other rights.
*
* NOTICE OF PROPRIETARY RIGHTS
*
* This program is a confidential trade secret and the property of Citigroup.
* Use, examination, reproduction, disassembly, decompiling, transfer and/or
* disclosure to others of all or any part of this software program are
* strictly prohibited except by express written agreement with Citigroup.
*/

package com.mobil.ws.infraestructure.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author EM19282
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  /**
   * News api.
   *
   * @return docket
   */
  @Bean
  public Docket newsApi() {

    return new Docket(DocumentationType.SWAGGER_2).groupName("mobi-tech").apiInfo(apiInfo())
        .useDefaultResponseMessages(false).select().paths(regex("/api/*.*")).build();
  }

  /**
   * Api info.
   *
   * @return api info
   */
  private ApiInfo apiInfo() {

    return new ApiInfoBuilder().title("CSMT-MOBIL-TECH-SERVICE")
        .description("This web service is responsible from get the mobil information")
        .termsOfServiceUrl("").contact("").license("").licenseUrl("").version("1.0").build();
  }

}
