package com.roulandu.rule.scanner;

import com.roulandu.rule.cache.GlobalCache;
import com.roulandu.rule.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

import java.net.URL;
import java.util.*;

/** Created By QQ497 on 2019/9/25 */
@Component
@Slf4j
public class RuleBeanScanner implements PackageScanner {
  private static String basePackagePath = "com.roulandu.rule.pojo.check";
  private static final String DROOLS_PACKAGE_PATH = "com.roulandu.rule.drools.unit.";
  private static final String DROOLS_UNIT_EXTENSION = "DroolsUnit";
  private ClassLoader cl = getClass().getClassLoader();

  @PostConstruct
  @Override
  public void getClassNameList() throws IOException {
    log.info("开始扫描包{}下的所有类", basePackagePath);
    GlobalCache.globalCache.put("ruleTypeMap", doScan(basePackagePath, new ArrayList<>()));
  }

  private Map<String, String> doScan(String basePackage, List<String> nameList) throws IOException {
    String splashPath = StringUtil.dotToSplash(basePackage);
    URL url = cl.getResource(splashPath);
    String filePath = StringUtil.getRootPath(url);
    List<String> names = readFromDirectory(filePath);
    for (String name : names) {
      nameList.add(StringUtil.trimExtension(name));
    }
    Map<String, String> map = new HashMap<>(nameList.size());
    nameList.stream().forEach(s -> map.put(s, DROOLS_PACKAGE_PATH + s + DROOLS_UNIT_EXTENSION));
    return map;
  }

  private List<String> readFromDirectory(String path) {
    File file = new File(path);
    String[] names = file.list();
    if (null == names) {
      return null;
    }
    return Arrays.asList(names);
  }
}
