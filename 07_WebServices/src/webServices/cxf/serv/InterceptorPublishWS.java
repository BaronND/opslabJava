package webServices.cxf.serv;
/**
 * @summary
 * 		测试cxf的拦截器
 */
import java.util.List;

import javax.xml.ws.Endpoint;

import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.message.Message;

import webServices.cxf.serv.impl.DataTypeWSImple;



public class InterceptorPublishWS {
	public static void main(String[] args) {
		String address = "http://localhost:8080/J2EE/services/datatype";
		
		Endpoint endpoint = Endpoint.publish(address, new DataTypeWSImple());
		EndpointImpl endpointImpl = (EndpointImpl) endpoint;
		
		//
		//添加日志拦截器
		//
		
		/**
		 * 日志入拦截器
		 */
		List<Interceptor<? extends Message>> inInterceptors = endpointImpl.getInInterceptors();
		inInterceptors.add(new LoggingInInterceptor());
		
		
		/**
		 * 日志出拦截器
		 */		
		List<Interceptor<? extends Message>> outInterceptors = endpointImpl.getOutInterceptors();
		outInterceptors.add(new LoggingOutInterceptor());
		
		System.out.println("Service 发布成功");
	}
}
