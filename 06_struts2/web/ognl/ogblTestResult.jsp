<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OGNL测试</title>
</head>
<body>
<h1>通过ognl访问action的上下文</h1>
	<p>parameters:<s:property value="#parameters.msg"/></p>
	<p>request:<s:property value="#request.msg"/></p>
	<p>session:<s:property value="#session.msg"/></p>
	<p>application:<s:property value="#application.msg"/></p>
<h1>通过struts标签和OGNL遍历list</h1>
	<s:iterator value="persons">
		<p>姓名:<s:property value="name"/>|年龄:<s:property value="age"/>|生日:<s:property value="birthday"/></p>
	</s:iterator>
</body>
</html>