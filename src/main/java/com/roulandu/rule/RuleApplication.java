package com.roulandu.rule;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/** Created By QQ497 on 2019/9/24 */
@SpringBootApplication
@EnableSwagger2
@MapperScan("com.roulandu.rule.dao")
public class RuleApplication {
  public static void main(String[] args) {
    SpringApplication.run(RuleApplication.class, args);
  }
}
