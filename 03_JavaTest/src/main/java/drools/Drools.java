package drools;

import entity.Message;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Created by monsoon on 21/08/2017.
 */
public class Drools {

    /**
     * 使用kmodule的方式调用drools
     * /resources/META-INF/kmodule.xml
     * @param args
     */
    public static void main(String[] args) {

        KieServices ks = KieServices.Factory.get();

        KieContainer kContainer = ks.getKieClasspathContainer();

        //根据规则kmodule.xml中的配置名称ksession-rules的规则文件
        KieSession kSession = kContainer.newKieSession("ksession-rules");


        //执行规则

//        for (Message msg : listMsg) {
//
//            kSession.insert(msg);
//
//            kSession.fireAllRules();
//
//
//        }
    }
}
