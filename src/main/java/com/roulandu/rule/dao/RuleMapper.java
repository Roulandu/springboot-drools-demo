package com.roulandu.rule.dao;

import com.roulandu.rule.pojo.Rule;

import java.util.List;

public interface RuleMapper {
  int deleteByPrimaryKey(Integer id);

  int insert(Rule record);

  int insertSelective(Rule record);

  Rule selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(Rule record);

  int updateByPrimaryKey(Rule record);

  List<Rule> getRuleListByType(String ruleType);
}
