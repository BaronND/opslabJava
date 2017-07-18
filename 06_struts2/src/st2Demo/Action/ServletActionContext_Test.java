package st2Demo.Action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

/**
 * @summary:
 * 		通过ServletActionContext获取与Servlet相关的对象
 * 			-Request
 * 			-session
 * 			-appliation
 */
public class ServletActionContext_Test {

	
	public String execute(){
		/*
		 * 通过ServletActionContext获取与servlet相关的常见对象 
		 */
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		ServletContext application = ServletActionContext.getServletContext();
		
		//从相应的对象中获取属性
		String appName = (String) application.getAttribute("appName");
		String userName = (String) session.getAttribute("userName");
		String reuqestId = (String) request.getAttribute("requestId");
		
		//设置属性
		application.setAttribute("applicationKey", "applicationValue");
		session.setAttribute("sessionKey", "sessionValue");
		request.setAttribute("requestKey", "requestValue");
		
		
		
		//输出属性
		System.out.println(appName); 
		System.out.println(userName);
		System.out.println(reuqestId);
		return "success";
	}
}
