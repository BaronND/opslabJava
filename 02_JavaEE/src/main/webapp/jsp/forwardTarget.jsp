<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Forward跳转页面</title>
</head>
<body>
	<center>
	<h1>这是jsp forward的跳转目标页面</h1>
	<h2>参数一:<%=request.getParameter("name") %></h2>
	<h2>参数一:<%=request.getParameter("info") %></h2>
	</center>
</body>
</html>