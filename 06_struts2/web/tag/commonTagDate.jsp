<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="s" uri="/struts-tags" %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>struts通用标签测试</title>
</head>
<body>
	<s:debug></s:debug>
	<h1>Date标签</h1>
	<%
		request.setAttribute("date", new Date());
	%>
	<s:date name="#request.date" format="yyyy-MM-dd" />
</body>
</html>