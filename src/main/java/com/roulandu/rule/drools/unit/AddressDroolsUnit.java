package com.roulandu.rule.drools.unit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.roulandu.rule.drools.AbstractDroolsUnit;
import com.roulandu.rule.pojo.check.Address;
import com.roulandu.rule.pojo.Rule;
import com.roulandu.rule.pojo.drools.VerifyResult;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;

import java.util.ArrayList;
import java.util.List;

/** Created By QQ497 on 2019/9/25 */
public class AddressDroolsUnit extends AbstractDroolsUnit {
  @Override
  public VerifyResult verify(List<Rule> ruleList, Object object) {
    String str = init(ruleList);
    builder.add(ResourceFactory.newByteArrayResource(str.getBytes()), ResourceType.DRL);
    if (builder.hasErrors()) {
      throw new RuntimeException(builder.getErrors().toString());
    }
    knowledgeBase.addPackages(builder.getKnowledgePackages());

    ObjectMapper objectMapper = new ObjectMapper();
    Address address = objectMapper.convertValue(object, Address.class);

    KieSession ksession = knowledgeBase.newKieSession();
    List<String> list = new ArrayList<>(ruleList.size());

    ksession.setGlobal("triggerRuleNameList", list);
    ksession.insert(address);

    int rulesFired = ksession.fireAllRules();
    System.out.println("触发了" + rulesFired + "条规则");

    list.forEach(s -> System.out.println("触发的规则名称是: " + s));

    ksession.dispose();

    return 0 != rulesFired
        ? VerifyResult.builder().result(true).data(null).build()
        : VerifyResult.builder().result(false).data(list).build();
  }

  private String init(List<Rule> ruleList) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("import com.roulandu.rule.pojo.check.Address; ");
    stringBuilder.append("global java.util.List triggerRuleNameList;");
    ruleList.stream().forEach(rule -> stringBuilder.append(" ").append(rule.getRuleContent()));
    return stringBuilder.toString();
  }
}
