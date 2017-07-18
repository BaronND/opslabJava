<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>利用struts实现的ajax版的注册程序</title>
</head>
<body>
	<s:form action="/ajax/ajaxRegisterAction.action" theme="ajax" validate="true">
		<s:textfield name="username" label="UserName"></s:textfield>
		<s:textfield name="password" label="Password"></s:textfield>
		<s:textfield name="age" label="Age"></s:textfield>
		<s:textfield name="birth" label="Birht"></s:textfield>
		<s:submit value="REGISTER"></s:submit>
	</s:form>
</body>
</html>