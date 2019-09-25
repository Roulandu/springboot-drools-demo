package com.roulandu.rule.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/** Created By QQ497 on 2019/9/24 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
  @Bean
  public Docket docket() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(getApiInfo())
        .select()
        // 设置basePackage会将包下的所有被@Api标记类的所有方法作为api
        .apis(RequestHandlerSelectors.basePackage("com.roulandu.rule.controller"))
        // 只有标记了@ApiOperation的方法才会暴露出给swagger
        .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
        .paths(PathSelectors.any())
        .build();
  }

  private ApiInfo getApiInfo() {
    return new ApiInfoBuilder()
        .title("API接口文档")
        .description("swagger2 rule api")
        .termsOfServiceUrl("http://localhost:8080/swagger-ui.html")
        .version("1.0")
        .contact(new Contact("Roulandu", "", "roulandu@126.com"))
        .build();
  }
}
