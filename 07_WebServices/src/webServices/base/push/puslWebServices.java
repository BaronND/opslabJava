package webServices.base.push;

import javax.xml.ws.Endpoint;

import webServices.base.serviceImpl.HelloWSImpl;
import webServices.base.serviceImpl.SystemInfoImpl;

/**
 * 
 * @author admins
 * @summary 发布webservices
 */
public class puslWebServices {
	public static void main(String[] args){
		//此处使用纯JDK发布和使用cxf分布的效果是不一样，比如wsdl文档 纯JDK会分俩个文件
		//而cxf则整合到一个文档中
		
		//webservices-helloWS
		String address = "http://localhost:8080/J2EE/services/hellows";
		String address1 = "http://localhost:8080/J2EE/services/systeminfo";
		
		//发布
		Endpoint.publish(address, new HelloWSImpl());
		Endpoint.publish(address1, new SystemInfoImpl());
	}
}
