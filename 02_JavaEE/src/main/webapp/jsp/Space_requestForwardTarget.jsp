<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP request属性范围测试</title>
</head>
<body>
	<center>
		<h1>JSP request属性范围测试</h1>
		这时Jsp request的服务端跳转的页面
		<%
			String username= (String)request.getAttribute("username");
			String info =(String) request.getAttribute("info");
		%>
		<p>username:<%=username %></p>
		<p>username:<%=info %></p>
	</center>
</body>
</html>