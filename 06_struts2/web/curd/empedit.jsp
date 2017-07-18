<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>employee list</title>
</head>
<body>
	<s:debug></s:debug>
	<s:form action="emp-update" method="post">
	    <s:hidden name="employeeId"></s:hidden>
		<s:textfield name="employeeName" label="employeeName"></s:textfield>
		<s:radio name="sex" list="#{'男':'男','女':'女' }" label="sex"></s:radio>
		<s:textfield name="skill" label="skill"></s:textfield>
		<s:submit value="join-in"></s:submit>
	</s:form>
</body>
</html>