<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>当action和model在不同包的时候测试类型转换器</title>
</head>
<body>
	<s:debug></s:debug>
	<h5>直接写属性的方式</h5>
	<s:form action="/converter/userConverterAction.action" method="post">
		<s:textfield name="id" label="id"></s:textfield>
		<s:textfield name="username" label="username"></s:textfield>
		<s:textfield name="password" label="password"></s:textfield>
		<s:textfield name="role" label="role"></s:textfield>
		<s:textfield name="birth" label="birth"></s:textfield>
		<s:submit value="submit"></s:submit>
	</s:form>
	<h5>直接写属性名.属性的方式</h5>
	<s:form action="/converter/userConverterAction.action" method="post">
		<s:textfield name="user.id" label="id"></s:textfield>
		<s:textfield name="user.username" label="username"></s:textfield>
		<s:textfield name="user.password" label="password"></s:textfield>
		<s:textfield name="user.role" label="role"></s:textfield>
		<s:textfield name="user.birth" label="birth"></s:textfield>
		<s:submit value="submit"></s:submit>
	</s:form>
	<h5>以同一个字段名提交</h5>
	<s:form action="/converter/userConverterAction.action" method="post">
		<s:textfield name="user" label="id" value="1:root:123456:root:1971-01-01"></s:textfield>
		<s:submit value="submit"></s:submit>
	</s:form>
</body>
</html>