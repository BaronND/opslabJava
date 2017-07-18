<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>当action和model在不同包的时候测试类型转换器</title>
</head>
<body>
	<%
	/*
	 * 1. Department 是模型, 实际录入的 Department. deptName 可以直接写到
	 * s:textfield 的 name 属性中. 那 mgr 属性如何处理呢 ?
	 * 
	 * struts2 表单标签的 name 值可以被赋为 属性的属性: name=mgr.name, name=mgr.birth
	 * 
	 * 2. mgr 中有一个 Date 类型的 birth 属性, Struts2 可以完成自动的类型转换吗 ?
	 * 
	 * 全局的类型转换器可以正常工作!
	 */
	%>
	<s:debug></s:debug>
	<s:form action="/converter/complext.action" method="post">
		<s:textfield name="name" label="DeptName"></s:textfield>
		<s:textfield name="manager.name" label="ManagerName"></s:textfield>
		<s:textfield name="manager.birth" label="ManagerBirth"></s:textfield>
		<s:submit value="submit"></s:submit>
	</s:form>
</body>
</html>