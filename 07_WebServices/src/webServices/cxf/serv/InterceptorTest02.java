package webServices.cxf.serv;

import java.util.List;

import javax.xml.ws.Endpoint;

import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.jaxws22.EndpointImpl;
import org.apache.cxf.message.Message;

import webServices.cxf.serv.impl.DataTypeWSImple;

/**
 * 
 * @summary:
 * 		测试自定义拦截器
 */
public class InterceptorTest02 {
	public static void main(String[] args) {
		String address = "http://localhost:8080/J2EE/services/datatype";
		
		Endpoint endpoint = Endpoint.publish(address, new DataTypeWSImple());
		
		EndpointImpl endpointImpl = (EndpointImpl) endpoint;
		List<Interceptor<? extends Message>> inInterceptors = endpointImpl.getInInterceptors();
		//添加自定义拦截器
		inInterceptors.add(new InterceptorTest());
		
		System.out.println("Service 发布成功");
	}
}
