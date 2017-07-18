<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:debug></s:debug>
	<s:form action="/converter/dateconvertimpl.action" method="post">
		<s:textfield name="age" label="Age"></s:textfield>
		<s:textfield name="brith" label="Brith"></s:textfield>
		<s:submit value="submit"></s:submit>
	</s:form>
</body>
</html>