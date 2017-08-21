package drools;

import entity.Message;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.List;

/**
 * 简单的测试drools的开发环境
 */
public class droolsDemo {
    public static void main(String[] args) {
        try {


            KieServices ks = KieServices.Factory.get();

            KieContainer kContainer = ks.getKieClasspathContainer();

            KieSession kSession = kContainer.newKieSession("ksession-rules");


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


        } catch ( Throwable t){

            t.printStackTrace();

        }
    }
}
