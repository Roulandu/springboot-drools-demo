package com.roulandu.rule.pojo;

public class Rule {
  private Integer id;

  private String ruleName;

  private String ruleContent;

  private String ruleType;

  public Rule(Integer id, String ruleName, String ruleContent, String ruleType) {
    this.id = id;
    this.ruleName = ruleName;
    this.ruleContent = ruleContent;
    this.ruleType = ruleType;
  }

  public Rule() {
    super();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getRuleName() {
    return ruleName;
  }

  public void setRuleName(String ruleName) {
    this.ruleName = ruleName == null ? null : ruleName.trim();
  }

  public String getRuleContent() {
    return ruleContent;
  }

  public void setRuleContent(String ruleContent) {
    this.ruleContent = ruleContent == null ? null : ruleContent.trim();
  }

  public String getRuleType() {
    return ruleType;
  }

  public void setRuleType(String ruleType) {
    this.ruleType = ruleType == null ? null : ruleType.trim();
  }
}
