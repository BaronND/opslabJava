package cxfDemo.Interceptor;

import java.util.List;

import javax.xml.ws.Endpoint;








import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.message.Message;

import cxfDemo.Interceptor.SEIImpl.InterceptorTestImpl;

/**
 * 
 * @summary:
 * 		发布webservice并测试拦截器
 */
public class publishWS {
	public static void main(String[] args) {
		String address = "http://localhost:8888/services/interceptor/interceptorWS";
		
		Endpoint endpoint = Endpoint.publish(address, new InterceptorTestImpl());

		
		//为改服务添加日志出和日志入连接器
		EndpointImpl endpointImpl = (EndpointImpl) endpoint;
		
		List<Interceptor<? extends Message>> inInterceptors = endpointImpl.getInInterceptors();
		inInterceptors.add(new LoggingInInterceptor());
		
		List<Interceptor<? extends Message>> outInterceptors = endpointImpl.getOutInterceptors();
		outInterceptors.add(new LoggingOutInterceptor());
		
		System.out.println("WebService 发布成功!");
	}
}
