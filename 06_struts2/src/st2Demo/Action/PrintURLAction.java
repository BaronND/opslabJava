package st2Demo.Action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.RequestUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

public class PrintURLAction implements ServletRequestAware {
	private HttpServletRequest request;
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request =request;
	}

	public String printAction(){
		 String url1 =request.getRequestURI();
		 String url2 = RequestUtils.getServletPath(request);
		 System.out.println(url1);
		 System.out.println(url2);
		return "success";
	}
}
