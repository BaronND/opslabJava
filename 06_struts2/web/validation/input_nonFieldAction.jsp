<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>输入验证</title>
</head>
<body>
	<s:debug></s:debug>
	<s:form action="/validation/nonfieldAction.action">
		<s:textfield name="password" label="password"></s:textfield>
		<s:textfield name="rpassword" label="rep-password"></s:textfield>
		${errorMessages }
		<s:submit value="提交"></s:submit>
	</s:form>
</body>
</html>