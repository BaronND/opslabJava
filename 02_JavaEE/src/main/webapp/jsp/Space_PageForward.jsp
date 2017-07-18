<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP page属性范围测试</title>
</head>
<body>
	<center>
		<h1>JSP page属性范围测试-forward测试</h1>
		<%
			pageContext.setAttribute("username","username");
			pageContext.setAttribute("info", "welcome to sites");
		%>
		<jsp:forward page="Space_PageForwardTarget.jsp"></jsp:forward>
	</center>
</body>
</html>