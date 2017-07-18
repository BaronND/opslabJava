<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>struts通用标签测试</title>
</head>
<body>
	<s:debug></s:debug>
	<h1>URL标签测试</h1>
	<s:url value="/test" var="url1"></s:url>
	url1:${url1 }<br>
	
	<h1>添加参数</h1>
	<s:url value="/test" var="url2">
		<s:param name="parameterId" value="0001"></s:param>
	</s:url>
	url2:${url2 }<br>
	
	<h1>从值站中获取一个动态属性</h1>
	<%
		String parameterId ="111";
		request.setAttribute("parameterId", parameterId);
	%>
	<s:url value="/test" var="url3">
		<s:param  name="parameterId" value="#request.parameterId"></s:param>
	</s:url>
	url3:${url3 }<br>
	
	<s:url value="/test" var="url4">
		<!-- 使用单引号阻止struts对value进行OGNL解析 -->
		<s:param  name="parameterId" value="'#request.parameterId'"></s:param>
	</s:url>
	url4:${url4 }<br>
	
	<s:url value="/test" var="url5">
		<!-- 使用%{}让struts对value进行OGNL解析 -->
		<s:param  name="parameterId" value="%{#request.parameterId}"></s:param>
	</s:url>
	url5:${url5 }<br>
	
	<s:url action="userLogin" namespace="/user" var="url6">
		<!-- 使用%{}让struts对value进行OGNL解析 -->
		<s:param  name="parameterId" value="%{#request.parameterId}"></s:param>
	</s:url>
	url6:${url6 }<br>
</body>
</html>