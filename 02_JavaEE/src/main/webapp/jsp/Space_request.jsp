<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP request属性范围</title>
</head>
<body>
	<center>
		<h1>JSP request属性范围</h1>
		<p>request表示请客户请求，一次客户端请求会做一次响应，如果这时服务器端做了跳转，也记为一次响应，
		即地址没有发生变化。跳转前后的request是同一个，所以俩个页面可以传递值。
		如果地址烂发生变化了，则意味着发起第二次请求</p>
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
	</center>
</body>
</html>