package com.roulandu.rule.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** Created By QQ497 on 2019/9/25 */
@Configuration
@Slf4j
public class GlobalCache implements InitializingBean {
  public static Map<String, Object> globalCache = new ConcurrentHashMap<>();

  @Override
  public void afterPropertiesSet() throws Exception {
    log.info("初始化全局缓存，关了就没了的那种");
  }
}
