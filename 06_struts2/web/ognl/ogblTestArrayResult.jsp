<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OGNL测试</title>
</head>
<body>
<h1>通过ognl访问array</h1>
<%
	String[] names = new String[]{"AA","BB","CC","DD"};
	request.setAttribute("names", names);
%>
<!-- 访问数组的属性 -->
length:<s:property value="#request.names.lenght"/><br>
<!-- 访问数组 -->
names[2]:<s:property value="#request.names[2]"/><br>

</body>
</html>