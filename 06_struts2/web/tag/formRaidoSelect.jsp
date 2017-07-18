<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="st2Demo.tag.city" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试radio和select标签</title>
</head>
<body>
	<h1>radio测试</h1>
	<s:form action="/form/radioAction.action">
		<s:radio list="#{'1':'man','2':'women' }" name="sex" label="sex"></s:radio>
		<s:submit value="submit"></s:submit>
	</s:form>
	
	
	<h1>select</h1>
	
	
	
	<%
	List<city> list = new ArrayList<city>();
	city c = new city("xining","西宁");
	list.add(c);
	c=new city("haidong","海东");
	list.add(c);
	c=new city("yushu","玉树");
	list.add(c);
	request.setAttribute("city", list);
	%>
	<s:form action="/form/selectAction.action">
		<s:select list="{18,19,20,21,22,23 }" headerKey="" headerValue="请选择" name="age" label="age">
			<!-- 使用optgroup -->
			<s:optgroup label="25-30" list="#{'25+':'25-30' }"></s:optgroup>
			<s:optgroup label="20-40" list="#{'30+':'30-40' }"></s:optgroup>
		</s:select>
		<s:select list="#request.city" listKey="cityId" listValue="cityName" name="citys" label="citys"></s:select>
		<s:submit value="submit"></s:submit>
	</s:form>
	
</body>
</html>