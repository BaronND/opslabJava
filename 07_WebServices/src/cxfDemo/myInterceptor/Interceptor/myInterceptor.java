package cxfDemo.myInterceptor.Interceptor;
/**
 * @summary:
 * 		利用该拦截器，在接受Web Services请求调用时校验客户端的用户需信息
 *
 */
import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;

public class myInterceptor extends AbstractPhaseInterceptor<SoapMessage> {
	private	String username;
	private String password;
	
	
	public myInterceptor(String username,String password) {
		//指定在调用服务端的方法时调用该拦截器
		super(Phase.INVOKE);
		this.username = username;
		this.password = password;
	}
	/**
	 * 拦截器校验客户端发送到客户端发送的SOAP中是否有如下的信息
	 * 
	 * 		<envelope>
	 * 			<head>
	 * 				<user>
	 * 					<username>xxx</username>
	 * 					<password>xxx</password>
	 * 				</user>
	 * 			</head>
	 * 			<body></body>
	 * 		</envelope>
	 */
	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		String user="";
		String pass="";
		QName qName = new QName("user");
		//判断客户端的SOAP消息头是否有user元素
		if(message.hasHeader(qName)){
			Header header = message.getHeader(qName);
			Element element = (Element) header.getObject();
			if(element.getFirstChild() != null){
				user =  element.getFirstChild().getTextContent();	
			}
			if(element.getLastChild() != null){
				pass= element.getLastChild().getTextContent();
			}
			System.out.println("myInterceptor:=>"+user+"<>"+pass);
			if(user.equals(username) && pass.equals(password)){
				System.out.println("用户信息校验成功:=>"+user+"<>"+pass);
			}else{
				System.out.println("用户信息校验失败:=>"+user+"<>"+pass);
				//此处抛出一个异常给客户端调用程序，然后终止程序的执行
				throw new RuntimeException("用户信息校验失败");
			}
		}else{
			System.out.println("未授权用户不允许调用");
			//此处抛出一个异常给客户端调用程序，然后终止程序的执行
			throw new RuntimeException("未授权用户不允许调用");			
		}
	}

}
