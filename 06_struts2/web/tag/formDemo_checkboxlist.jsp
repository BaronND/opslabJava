<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>struts表单标签测试</title>
</head>
<body>
	<s:debug></s:debug>
	<s:form action="/form/checkboxlist.action" method="post">
		<s:checkboxlist name="skill" list="list" listKey="lanuageId" listValue="langageName" label="skill"></s:checkboxlist>
		<s:submit value="submit"></s:submit>
	</s:form>
</body>
</html>