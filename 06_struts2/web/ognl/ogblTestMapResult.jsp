<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OGNL测试map</title>
</head>
<body>
<h1>通过ognl访问map</h1>
<!-- 构造一个map -->
<s:set name="map" value="#{'id':'test','name':'testName' }"/>
<s:iterator value="#map" var="o">
	<%
	//可以按照如下方式访问
	//<s:property value="#o.key"/>:<s:property value="#on.value"/>
	%>
	<s:property value="key"/>:<s:property value="value"/>
</s:iterator>


</body>
</html>