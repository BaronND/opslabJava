package cxfDemo.myInterceptor.client;

import java.util.List;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.message.Message;

import cxfDemo.myInterceptor.client.interceptor.addUserInfoInterceptor;
import cxfDemo.myInterceptor.client.wsdemo.MyInterceptorWS;
import cxfDemo.myInterceptor.client.wsdemo.MyInterceptorWSImplService;

/**
 * 
 *	使用wsimport命令生成的客户端调用程序
 */
public class wsClient {
	public static void main(String[] args) {
		MyInterceptorWSImplService factory = new MyInterceptorWSImplService();
		MyInterceptorWS myInterceptorWSImplPort = factory.getMyInterceptorWSImplPort();
		
		//添加客户端连接器
		Client client = ClientProxy.getClient(myInterceptorWSImplPort);
		List<Interceptor<? extends Message>> outInterceptors = client.getOutInterceptors();
		outInterceptors.add(new addUserInfoInterceptor("admin", "admin"));
		
		String helloWS = myInterceptorWSImplPort.helloWS();
		System.out.println(helloWS);
	}
}
