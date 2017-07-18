package cxfDemo.JAXWS_DEMO01.client1;
/**
 * 这种调用方式有些问题，暂时而为测试成功
 */
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import cxfDemo.JAXWS_DEMO01.services.helloWS;

public class jaxwsClient {
	private static final QName SERVICE_NAME = new QName("http://services.JAXWS_DEMO01.cxfDemo/","helloWSImplService");
	
	private static final QName PROT_NAME = new QName("http://services.JAXWS_DEMO01.cxfDemo/","helloWSImplPort");
	
	public static void main(String[] args) {
		//使用服务名创建一个服务
		Service service = Service.create(SERVICE_NAME);
		
		String  address ="http://localhost:8888/services/helloWS";
		
		//为服务添加端口
		service.addPort(PROT_NAME, SOAPBinding.SOAP11HTTP_BINDING, address);
		
		//获取服务类的对象并处理
		helloWS port = service.getPort(helloWS.class);
		
		//调用相应的方法
		port.sayHello("JAX-WS client");
		
	}
}
