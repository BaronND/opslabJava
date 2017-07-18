<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>表单重复提交</title>
</head>
<body>
	<s:form action="/token/tokenSessionTestImpl.action">
		<s:token></s:token>
		<s:textfield name="id" label="Id"></s:textfield>
		<s:textfield name="username" label="UserName"></s:textfield>
		<s:submit value="submit"></s:submit>
	</s:form>
</body>
</html>