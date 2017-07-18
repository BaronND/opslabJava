package cxfDemo.JAXWS_DEMO01.client2;

import cxfDemo.JAXWS_DEMO01.client2.demo.HelloWS;
import cxfDemo.JAXWS_DEMO01.client2.demo.HelloWSImplService;

/**
 * 
 * @summary:
 * 		使用JDK中wsimport命令生成客户端代码，然后编写调用类
 * @注意：
 * 		此包下的demo包下的所有类都是统一以下命令生成
 * 	src>wsimport -keep -p cxfDemo.JAXWS_DEMO01.client2.demo http://localhost:8888/services/helloWS?Wsdl
 */
public class wsimportClient {
	public static void main(String[] args) {
		HelloWSImplService factory = new HelloWSImplService();
		HelloWS helloWSImplPort = factory.getHelloWSImplPort();
		System.out.println(helloWSImplPort.sayHello("JDK-WSimport Client call"));
	}
}
