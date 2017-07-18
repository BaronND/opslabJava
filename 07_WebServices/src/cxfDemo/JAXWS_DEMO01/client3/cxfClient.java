package cxfDemo.JAXWS_DEMO01.client3;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class cxfClient {
	public static void main(String[] args) throws Exception {
		//注意：address最后记得添加?wsdl不然会报错
		String address ="http://localhost:8888/services/helloWS?wsdl";
		
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		
		Client client = dcf.createClient(address);

		Object[] res = client.invoke("sayHello", "cxf Client call");
		
		System.out.println(res[0].toString());
	}
}
