package com.roulandu.rule.drools.factory;

import com.roulandu.rule.drools.AbstractDroolsUnit;
import org.springframework.util.StringUtils;

/** Created By QQ497 on 2019/9/25 */
public class DroolsUnitFactory {
  public static AbstractDroolsUnit create(String className) {
    try {
      if (!StringUtils.isEmpty(className)) {
        return (AbstractDroolsUnit) Class.forName(className).newInstance();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
