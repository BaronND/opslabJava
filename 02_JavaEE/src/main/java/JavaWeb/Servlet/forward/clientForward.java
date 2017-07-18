package JavaWeb.Servlet.forward;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class clientForward
 */
public class clientForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public clientForward() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handler(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handler(request, response);
	}

	public void handler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 使用response对象设置客户端跳转
		 */

		//方法一：设置http-header-refresh属性
		response.setHeader("refresh", "3,URL=hello.html");
		
		//方法二
		response.sendRedirect("hello.html");
	}
}
