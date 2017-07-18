package webServices.cxf.client;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;


/**
 * 
 * 使用cxf动态的生成客户端代码
 */
public class clientTest02 {
	public static void main(String[] args) throws Exception {
		String address ="http://localhost:8080/J2EE/services/hellows?wsdl";
		
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		Client client = dcf.createClient(address);
//		HTTPConduit http = (HTTPConduit) client.getConduit();
//		HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
//		httpClientPolicy.setConnectionTimeout(10000);
//		httpClientPolicy.setAllowChunking(false);
//		httpClientPolicy.setReceiveTimeout(60 * 1000 * 5);
//		http.setClient(httpClientPolicy);
		
		Object[] invoke = client.invoke("sayHello", null);
		System.out.println(invoke[0].toString());
	}
}
