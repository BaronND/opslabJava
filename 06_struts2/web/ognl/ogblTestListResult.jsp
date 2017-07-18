<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="st2Demo.ognl.Person" %>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OGNL测试</title>
</head>
<body>
<h1>通过ognl访问访问list</h1>
<%
	List<Person> list = new ArrayList<Person>();

	Person p = new Person();
	p.setName("test1");
	p.setAge(20);
	p.setBirthday(new Date());
	list.add(p);

	p = new Person();
	p.setName("test2");
	p.setAge(11);
	p.setBirthday(new Date());
	list.add(p);
	
	p = new Person();
	p.setName("test3");
	p.setAge(22);
	p.setBirthday(new Date());
	list.add(p);
	
	p = new Person();
	p.setName("test4");
	p.setAge(11);
	p.setBirthday(new Date());
	list.add(p);
	
	request.setAttribute("list", list);
%>
<!-- 使用s:iterator遍历list -->
<s:iterator value="#request.list">
	<s:property value="name"/>:<s:property value="age"/>:<s:property value="birthday"/>
</s:iterator>
<!-- 在遍历前对list进行过滤 -->
<h1>通过ognl遍历并过滤list</h1>
<s:iterator value="#request.list.{?#this.age>=20}">
	<s:property value="name"/>:<s:property value="age"/>:<s:property value="birthday"/>
</s:iterator>
</body>
</html>