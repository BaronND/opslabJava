<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP request属性范围</title>
</head>
<body>
	<center>
		<h1>JSP request属性范围测试</h1>
		<%
			request.setAttribute("username","username");
			request.setAttribute("info","welcome");
		%>
		在本页面设置了俩个属性
		<%
			String username= (String)request.getAttribute("username");
			String info =(String) request.getAttribute("info");
		%>
		<p>username:<%=username %></p>
		<p>username:<%=info %></p>
		<jsp:forward page="Space_requestForwardTarget.jsp"></jsp:forward>
	</center>
</body>
</html>