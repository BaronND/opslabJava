<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>演示JSP的include指令</title>
</head>
<body>
<pre>
	该指令用于在JSP页面中静态包含一个文件,该文件可以是JSP页面,HTML网页,文本件或一段Java代码.使用了include指令的JSP页面在转换时,<br/>
		JSP容器会在其中插入包含文件的文本或代码,include指令的语法如下:<br/>
		&lt%@ include file="relativeURLspec"%&gt<br/>
		XML语法格式的include指令如下:<br/>
		&ltjsp:directive.include file="relativeURLspec" /&gt<br/>
		file属性的值被解释为相对当前的JSP文件的URL.<br/>
</pre>
	<h1>欢迎你！现在时间是:<jsp:include page="Date.jsp"></jsp:include></h1>
</body>
</html>