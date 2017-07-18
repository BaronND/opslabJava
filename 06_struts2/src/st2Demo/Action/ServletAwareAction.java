package st2Demo.Action;
/**
 * @summary:
 * 		通过实现Servlet——XXX-Aware接口是实现对Web资源的访问
 * 
 * 		struts2会通过接口注入相应的对象
 */
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

public class ServletAwareAction implements ServletRequestAware, ServletContextAware {

	private	HttpServletRequest request;
	
	private HttpSession session;
	
	private ServletContext	application;
	
	/**
	 * struts会通过该接口注入相应的对象
	 */
	@Override
	public void setServletContext(ServletContext arg0) {
		this.application = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request =arg0;
		this.session = request.getSession();
	}

	
	public String execute(){
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
