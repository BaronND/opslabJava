<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>struts表单标签测试</title>
</head>
<body>
	<s:form action="/user/login.action" method="post">
		<s:hidden name="sessionId"></s:hidden>
		<s:textfield name="userName" label="userName"></s:textfield>
		<s:password name="password" label="password"></s:password>
		<s:textarea name="desc" label="desc"></s:textarea>
		<s:submit value="Login"></s:submit>
	</s:form>
</body>
</html>