package com.roulandu.rule.util;

import java.net.URL;

/** Created By QQ497 on 2019/9/25 */
public class StringUtil {
  public static String getRootPath(URL url) {
    String fileUrl = url.getFile();
    int pos = fileUrl.indexOf('!');
    if (-1 == pos) {
      return fileUrl;
    }
    return fileUrl.substring(5, pos);
  }

  public static String dotToSplash(String name) {
    return name.replaceAll("\\.", "/");
  }

  public static String trimExtension(String name) {
    int pos = name.indexOf('.');
    if (-1 != pos) {
      return name.substring(0, pos);
    }
    return name;
  }
}
