<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP application范围属性测试</title>
</head>
<body>
	<center>
		<h1>JSP application范围属性测试</h1>
		<p>
			application表示应用程序范围的。对所有session，request，page都是可见的
			
			该页面的内容八百年不变...!你信吗？ 反正我不信！
			<%
				application.setAttribute("start-date",new Date());
			%>
			START TIME:<%=application.getAttribute("start-date") %>
		</p>
	</center>
</body>
</html>