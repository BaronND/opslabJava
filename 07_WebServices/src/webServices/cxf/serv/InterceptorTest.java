package webServices.cxf.serv;
import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
/**
 * @SUMMARY:
 * 		cxf中的自定义拦截器
 */
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class InterceptorTest extends AbstractPhaseInterceptor<SoapMessage> {

	public InterceptorTest() {
		//设置该拦截器在准备调用服务端方法前条用
		super(Phase.PRE_INVOKE);
	}

	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		String username="";
		String password="";
		QName qName = new QName("user");
		if(message.hasHeader(qName)){
			Header header = message.getHeader(qName);
			Element user = (Element) header.getObject();
			Node ele_username = user.getFirstChild();
			Node ele_password = user.getLastChild();
			if(null != ele_username){
				username = ele_username.getTextContent();
			}
			if(null != ele_password){
				password = ele_password.getTextContent();
			}
			//System.out.println(username+"\t"+password);
		}
		if("admin".equals(username) && "admin".equals(password)){
			System.out.println("service valid user is success!");
		}else{
			System.out.println("service valid user is faild!");
			throw new RuntimeException("valid user-pass!");
		}
	}

}
