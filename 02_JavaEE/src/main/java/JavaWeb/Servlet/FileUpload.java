package JavaWeb.Servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileUpload extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Handler(req,resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Handler(req,resp);
	}

	protected void Handler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		out.println(req.getContentType()+"<br/>");
		
		BufferedReader sbuf = new BufferedReader(new InputStreamReader(req.getInputStream()));
		StringBuffer sbuf_res = new StringBuffer("");
		String line;
		while((line =sbuf.readLine()) != null){
			sbuf_res.append(line+"<br/>");
		}
		out.print(sbuf_res.toString());
		sbuf.close();
	}
}
