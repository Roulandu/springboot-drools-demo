package com.roulandu.rule.drools;

import com.roulandu.rule.pojo.Rule;
import com.roulandu.rule.pojo.drools.VerifyResult;
import org.drools.core.impl.InternalKnowledgeBase;
import org.drools.core.impl.KnowledgeBaseFactory;
import org.kie.api.io.ResourceType;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;

import java.util.List;

/** Created By QQ497 on 2019/9/25 */
public abstract class AbstractDroolsUnit {

  public static KnowledgeBuilder builder = KnowledgeBuilderFactory.newKnowledgeBuilder();

  public static InternalKnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();

  public abstract VerifyResult verify(List<Rule> ruleList, Object object);

  public static boolean verifyRule(String rule) {
    builder.add(ResourceFactory.newByteArrayResource(rule.getBytes()), ResourceType.DRL);
    if (builder.hasErrors()) {
      return false;
    }
    return true;
  }
}
