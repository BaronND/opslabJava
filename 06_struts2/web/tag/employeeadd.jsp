<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>struts表单标签测试</title>
</head>
<body>
	<s:debug></s:debug>
	<s:form action="/form/employeesave" method="post">
		<s:textfield name="userName" label="userName"></s:textfield>
		<s:radio name="sex" list="#{'1':'男','2':'女' }" label="sex"></s:radio>
		<s:select name="depts" list="#application.listDept" listKey="deptId" listValue="deptName" label="部门"></s:select>
		<s:checkboxlist name="roles" list="#request.listRole" listKey="roleId" listValue="roleName" label="角色" ></s:checkboxlist>
		<s:textarea name="desc" label="desc"></s:textarea>
		<s:submit value="join-in"></s:submit>
	</s:form>
</body>
</html>