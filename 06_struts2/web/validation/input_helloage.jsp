<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>输入验证</title>
</head>
<body>
	<s:form action="/validation/helloage.action" theme="simple">
		<s:textfield name="age" label="Age"></s:textfield>${fieldErrors.age[0] }<br>
		<s:fielderror name="age"></s:fielderror>
		<s:submit name="submit"></s:submit>
	</s:form>
</body>
</html>