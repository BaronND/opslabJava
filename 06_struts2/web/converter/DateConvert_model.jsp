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
	<s:form action="/converter/dateconvertModel.action" method="post">
		<s:textfield name="personId" label="personId"></s:textfield>
		<s:textfield name="personName" label="personName"></s:textfield>
		<s:textfield name="birth" label="birth"></s:textfield>
		<s:submit value="submit"></s:submit>
	</s:form>
</body>
</html>