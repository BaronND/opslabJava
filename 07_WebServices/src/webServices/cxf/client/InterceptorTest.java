package webServices.cxf.client;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
/**
 * @summary:
 * 		在发送web services前假如用户验证信息 
 * 
 * @envelope
 * 		<envelope>
 * 			<head>
 * 				<user>
 * 					<username>admin</username>
 * 					<password>admin</password>
 * 				</user>
 * 			</head>
 * 			<body></body>
 * 		</envelope>
 *
 */
public class InterceptorTest extends AbstractPhaseInterceptor<SoapMessage> {
	private  String username;
	
	private  String password;
	public InterceptorTest(String  username,String password) {
		//协议化前触发该拦截器
		super(Phase.PRE_PROTOCOL);
		this.username=username;
		this.password=password;
	}

	
	/**
	 * @summary:
	 * 		在客户端通过拦截器为soap请求添加如下的头：
	 * 		 <head>
	 * 				<user>
	 * 					<username>admin</username>
	 * 					<password>admin</password>
	 * 				</user>
	 * 		</head>
	 */
	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		DocumentBuilder builder = null;
        try {
           builder = DocumentBuilderFactory.newInstance().
           newDocumentBuilder();
        } catch (ParserConfigurationException e) {
           e.printStackTrace();
        }
        Document doc = builder.newDocument();
        Element elementCredentials = 
        doc.createElement("user");
        Element elementUser = doc.createElement("username");
        elementUser.setTextContent(this.username);
        Element elementPassword = doc.createElement("password");
        elementPassword.setTextContent(this.password);
        elementCredentials.appendChild(elementUser);
        elementCredentials.appendChild(elementPassword);
        // Create Header object
        QName qnameCredentials =  new QName("user");
		Header header = new Header(qnameCredentials, 
		elementCredentials);
		message.getHeaders().add(header);
		
	}

}
