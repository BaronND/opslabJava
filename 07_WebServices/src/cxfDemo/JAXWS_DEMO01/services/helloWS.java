package cxfDemo.JAXWS_DEMO01.services;

/**
 * 
 * @使用注解实现JAX-WS
 */
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


//使用@WebService注解声明该类是一个SEI(web services服务器接口)
@WebService
public interface helloWS {

	//使用@WebMethod声明一个webservices端的方法
	@WebMethod
	public String sayHello(
			//使用@WebParam指定WSDL文档中改方法的第一个参数为name，若不指定则显示arg0
			@WebParam(name="name")
			String name);
}
