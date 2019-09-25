package com.roulandu.rule;

import com.roulandu.rule.pojo.check.Message;
import org.drools.core.impl.InternalKnowledgeBase;
import org.drools.core.impl.KnowledgeBaseFactory;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;

import java.util.ArrayList;
import java.util.List;

/** Created By QQ497 on 2019/9/24 */
public class DroolsTest {

  private static KnowledgeBuilder builder = KnowledgeBuilderFactory.newKnowledgeBuilder();

  private static InternalKnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();

  private static final DroolsTest droolsTest = new DroolsTest();

  private DroolsTest() {}

  public static DroolsTest getDroolsTest() {
    return droolsTest;
  }

  public void verify(String name) {
    String str =
        "import com.roulandu.rule.pojo.check.Message; \n"
            + "global java.util.List myGlobalList;\n"
            + "rule \"Hello World\" \n"
            + "when \n"
            + "message:Message(name == \"T\") \n"
            + "then \n"
            + "System.out.println(\"Hello Test\");\n"
            + "myGlobalList.add(\"Hello World\");\n"
            + "end \n"
            + "rule \"Hello World2\" \n"
            + "when \n"
            + "message:Message(name == \"T\") \n"
            + "then \n"
            + "System.out.println(\"Hello 123\"); \n"
            + "myGlobalList.add(\"Hello World2\");\n"
            + "end";

    builder.add(ResourceFactory.newByteArrayResource(str.getBytes()), ResourceType.DRL);
    if (builder.hasErrors()) {
      throw new RuntimeException(builder.getErrors().toString());
    }
    knowledgeBase.addPackages(builder.getKnowledgePackages());

    KieSession ksession = knowledgeBase.newKieSession();

    Message message = new Message();
    message.setName(name);
    List<String> list = new ArrayList<>();
    ksession.setGlobal("myGlobalList", list);
    ksession.insert(message);
    int rulesFired = ksession.fireAllRules();
    System.out.println("触发了" + rulesFired + "条规则");
    list.stream().forEach(s -> System.out.println(s));
    ksession.dispose();
  }

  public static void main(String[] args) {
    getDroolsTest().verify("T");
  }
}
