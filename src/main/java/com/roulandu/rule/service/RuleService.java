package com.roulandu.rule.service;

import com.roulandu.rule.pojo.Rule;

/** Created By QQ497 on 2019/9/24 */
public interface RuleService {

  boolean verify(Object verifyData, String ruleType);

  Rule getRule(int id);

  boolean addRule(String name, String content);

  boolean update(Rule rule);

  boolean delete(int id);
}
