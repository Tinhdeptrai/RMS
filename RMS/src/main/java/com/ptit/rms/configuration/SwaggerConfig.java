package com.ptit.rms.configuration;

import static com.google.common.collect.Lists.newArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors.basePackage("com.ptit.rms.controller.api")).paths(PathSelectors.ant("/api/**"))
        .build().apiInfo(apiInfo()).useDefaultResponseMessages(false)
        .globalResponseMessage(RequestMethod.GET, newArrayList(
            new ResponseMessageBuilder().code(500).message("Internal Server Error").responseModel(new ModelRef("Error"))
                .build(),
            new ResponseMessageBuilder().code(403).message("Forbidden").build(),
            new ResponseMessageBuilder().code(401).message("Unauthorized").build(),
            new ResponseMessageBuilder().code(400).message("Bad Request").build()))
        .globalResponseMessage(RequestMethod.POST, newArrayList(
            new ResponseMessageBuilder().code(500).message("Internal Server Error").responseModel(new ModelRef("Error"))
                .build(),
            new ResponseMessageBuilder().code(403).message("Forbidden").build(),
            new ResponseMessageBuilder().code(401).message("Unauthorized").build(),
            new ResponseMessageBuilder().code(400).message("Not Found").build()));
  }

  @SuppressWarnings("deprecation")
  private ApiInfo apiInfo() {
    ApiInfo apiInfo = new ApiInfo("RMS REST API", "RMS API.", "API TOS", "service",
        "Nguyen Tinh", "License Nguyen Tinh", "nguyentinh0410@gmail.com");
    return apiInfo;
  }
}