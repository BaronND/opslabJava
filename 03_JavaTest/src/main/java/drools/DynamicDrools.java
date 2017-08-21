package drools;

import app.APP;
import entity.Message;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Results;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by monsoon on 21/08/2017.
 */
public class DynamicDrools {
    public static void main(String[] args) {
        KieSession kSession = getKieSession("ksession-rules");


        Message message = new Message();

        message.setMessage("Hello World");

        message.setStatus(Message.HELLO);

        System.out.println(String.format("执行规则前message对象的变化如下：message.message=%s,message.status=%d",
                message.getMessage(), message.getStatus()));

        Message message2 = new Message();

        message2.setMessage("liuyinghui");

        message2.setStatus(Message.HELLO);

        List<Message> listMsg = new ArrayList<Message>();

        listMsg.add(message2);

        listMsg.add(message);

        for (Message msg : listMsg) {

            kSession.insert(msg);

            kSession.fireAllRules();


        }

        System.out.println(String.format("执行规则后message对象的变化如下：message.message=%s,message.status=%d", message.getMessage(), message.getStatus()));
    }

    /**
     * 根据规则信息动态获取KieSession
     * @summary 实际使用中需要主要性能问题，例如发现规则信息没有变化则直接返回已有的KieSession
     * @param rules
     * @return
     */
    public static KieSession getKieSession(String rules) {
        String ruleFile = APP.path_temp+"/rules.drl";
        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kfs = kieServices.newKieFileSystem();
        kfs.write(ruleFile, rules.getBytes());
        KieBuilder kieBuilder = kieServices.newKieBuilder(kfs).buildAll();
        Results results = kieBuilder.getResults();
        if (results.hasMessages(org.kie.api.builder.Message.Level.ERROR)) {
            System.out.println(results.getMessages());
            throw new RuntimeException(results.getMessages().toString());
        }
        KieContainer kieContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());
        KieBase kieBase = kieContainer.getKieBase();

        return kieBase.newKieSession();
    }
}
