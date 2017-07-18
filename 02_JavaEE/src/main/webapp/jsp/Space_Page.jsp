<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>演示JSP的Page属性范围</title>
</head>
<body>
	<center>
		<h1>演示JSP的Page属性范围应用</h1>
		page属性范围使用pageContext表示，但习惯上称为page属性返回。
		在该范围中设置的属性，只能在也面中使用forward后无法使用
		<%
			pageContext.setAttribute("username", "username");
			pageContext.setAttribute("info", "welcome to sites");
		%>
		在page范围能设置了俩个属性username,info
		<%
			String username =(String)pageContext.getAttribute("username");
			String info = (String)pageContext.getAttribute("info");
		%>
		<p>username:<%=username %></p>
		<p>info:<%=info %></p>
	</center>
</body>
</html>