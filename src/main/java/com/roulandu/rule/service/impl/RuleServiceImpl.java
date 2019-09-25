package com.roulandu.rule.service.impl;

import com.roulandu.rule.cache.GlobalCache;
import com.roulandu.rule.dao.RuleMapper;
import com.roulandu.rule.drools.AbstractDroolsUnit;
import com.roulandu.rule.drools.factory.DroolsUnitFactory;
import com.roulandu.rule.pojo.Rule;
import com.roulandu.rule.pojo.drools.VerifyResult;
import com.roulandu.rule.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/** Created By QQ497 on 2019/9/24 */
@Service
public class RuleServiceImpl implements RuleService {

  @Autowired private RuleMapper ruleMapper;

  @Override
  public boolean verify(Object verifyData, String ruleType) {
    Map<String, String> ruleTypeMap =
        (Map<String, String>) GlobalCache.globalCache.get("ruleTypeMap");
    if (ruleTypeMap.containsKey(ruleType)) {
      String droolsUnitName = ruleTypeMap.get(ruleType);
      List<Rule> list = ruleMapper.getRuleListByType(ruleType);
      VerifyResult result = DroolsUnitFactory.create(droolsUnitName).verify(list, verifyData);
      return result.isResult();
    }
    return false;
  }

  @Override
  public Rule getRule(int id) {
    return ruleMapper.selectByPrimaryKey(id);
  }

  @Override
  public boolean addRule(String name, String content) {
    if (AbstractDroolsUnit.verifyRule(content)) {
      Rule rule = new Rule();
      rule.setRuleName(name);
      rule.setRuleContent(content);
      ruleMapper.insert(rule);
      return true;
    }
    return false;
  }

  @Override
  public boolean update(Rule rule) {
    ruleMapper.updateByPrimaryKey(rule);
    return true;
  }

  @Override
  public boolean delete(int id) {
    ruleMapper.deleteByPrimaryKey(id);
    return true;
  }
}
