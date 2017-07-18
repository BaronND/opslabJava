package cxfDemo.myInterceptor.client.interceptor;


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

public class addUserInfoInterceptor extends AbstractPhaseInterceptor<SoapMessage> {
	private String username;
	private String password;
	public addUserInfoInterceptor(String username,String password) {
		super(Phase.PRE_PROTOCOL);
		this.username = username;
		this.password = password;
	}

	
	/**
	 * 在发送Web Services请求前添加SOAP头信息以完成用户验证
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
		DocumentBuilder builder = null;
        try {
           builder = DocumentBuilderFactory.newInstance().
           newDocumentBuilder();
        } catch (ParserConfigurationException e) {
           e.printStackTrace();
        }
        Document doc = builder.newDocument();
        Element user =  doc.createElement("user");
        Element ele_username = doc.createElement("username");
        ele_username.setTextContent(username);
        Element ele_password = doc.createElement("password");
        ele_password.setTextContent(password);  
        user.appendChild(ele_username);
        user.appendChild(ele_password);
        
        //将SOAP头信息添加到SOAP信封中
        Header header = new Header(new QName("user"),user);
        message.getHeaders().add(header);
	}


}
