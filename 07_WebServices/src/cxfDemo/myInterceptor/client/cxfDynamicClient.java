package cxfDemo.myInterceptor.client;

import java.util.List;

import javax.xml.namespace.QName;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.message.Message;
import org.apache.cxf.service.model.BindingInfo;
import org.apache.cxf.service.model.BindingOperationInfo;

import cxfDemo.myInterceptor.client.interceptor.addUserInfoInterceptor;

/**
 * @summary:
 * 	使用cxf的动态客户端调用webservice，并添加拦截器 
 *
 */
public class cxfDynamicClient {
	public static void main(String[] args) throws Exception {
		//此处的?wsdl不能少
				String address ="http://localhost:8888/services/spring/myinterceptor/interceptorWS?wsdl";
				
				JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
				
				Client client = dcf.createClient(address);
				
				//添加拦截器
				List<Interceptor<? extends Message>> outInterceptors = client.getOutInterceptors();
				outInterceptors.add(new addUserInfoInterceptor("admin", "admin"));
				
				//客户端发起调用
				// CXF动态客户端在处理此问题时，会报No operation was found with the name的异常 
				String operation="helloWS";
				Endpoint endpoint = client.getEndpoint();  
				QName opName = new QName(endpoint.getService().getName().getNamespaceURI(), operation);  
				BindingInfo bindingInfo = endpoint.getEndpointInfo().getBinding();  
				if (bindingInfo.getOperation(opName) == null) {  
				    for (BindingOperationInfo operationInfo : bindingInfo.getOperations()) {  
				        if (operation.equals(operationInfo.getName().getLocalPart())) {  
				            opName = operationInfo.getName();  
				            break;  
				        }  
				    }  
				} 
				Object[] objects = client.invoke(opName);
				System.out.println(objects[0]);
	}
}
