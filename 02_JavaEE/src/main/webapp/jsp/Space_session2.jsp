<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP session属性范围测试</title>
</head>
<body>
	<center>
		<h1>JSP session属性范围测试</h1>
		<%
			String sessioninfo = (String)session.getAttribute("sessioninfo");
			String ip = (String)session.getAttribute("ip");
		%>
		<p>sessioninfo:<%=sessioninfo %></p>
		<p>ip:<%=ip %></p>
		<a href="Space_session2.jsp">客户端发起另外一个请求</a>
	</center>
</body>
</html>