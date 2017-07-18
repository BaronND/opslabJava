package Filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class PrintRequest
 */
public class PrintRequest implements Filter {

    /**
     * Default constructor. 
     */
    public PrintRequest() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		
		String att="";
		String value="";
		
		//取得application对象
		ServletContext servletContext = request.getServletContext();
		
		//取得session
		HttpSession session = ((HttpServletRequest)request).getSession();
		
		
		System.out.println("-----------------------------------------------------------------------");
		Enumeration<String> attributeNames = servletContext.getAttributeNames();
		while(attributeNames.hasMoreElements()){
			att = attributeNames.nextElement();
			value=servletContext.getAttribute(att).toString();
			System.out.println("application:"+att+"==>"+value.replaceAll("[\\t\\n\\r]", ""));
		}

		Enumeration<String> attributeNames2 = session.getAttributeNames();

		while(attributeNames2.hasMoreElements()){
			att = attributeNames2.nextElement();
			value = session.getAttribute(att).toString();
			System.out.println("sessions:"+att+"==>"+value.replaceAll("[\\t\\n\\r]", ""));
		}
		
		
		//遍历request
		Enumeration<String> attributeNames3 = request.getAttributeNames();
		while(attributeNames3.hasMoreElements()){
			att = attributeNames3.nextElement();
			value =request.getAttribute(att).toString();
			System.out.println("request:"+att+"==>"+value.replaceAll("[\\t\\n\\r]", ""));
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
