<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<pre>
	<h1>脚本元素</h1>
	脚本元素包括三个部分:声明,脚本段和表达式.EL表达式作为脚本元素的另一个选择.
	声明脚本元素用于声明其他脚本元素中可以使用的变量和方法.
	脚本段是一段java代码,用于描述在对请求的响应中要执行的动作.
	表达式脚本元素是java语言中完整的表达式,在响应请求时被计算,计算的结果将被转换为字符串,插入到输出流中.
	这三种脚本元素都是基于&lt% 的语法:
	&lt%! this is a declaration %&gt
	&lt% this is a scriptlet %&gt
	&lt%=  this is an expression %&gt
	<h2>声明</h2>
	声明脚本元素用于在JSP页面的脚本语言中使用的变量和方法,声明必须是完整的声明语句,遵循java语法.声明不会在当前的输出流中产生任何的输出.
	语法如下:
	&lt%!  declaration(s) %&gt
	XML:
	&ltjsp:declaration&gtdeclaration(s)&lt/jsp:declaration&gt
	例如:
	&lt%! int i =0 ;%&gt
	&lt%! public String f (int i ) {if (i < 3) return ("...");}%&gt
	可以在一个声明做声明多个变量和方法,也可以使用多个声明,声明只在当前JSP页面中有效.
	
	利用&lt%! %&gt 声明的变量,在JSP容器转换JSP页面为Servlet类时,将作为该类的实例变量或者类变量(声明时使用了static关键字),在多用户并发
	访问时,这将导致线程安全的问题,除非确认是单用户访问或者变量是只读的.
	<h2>脚本段</h2>
	脚本段是在请求处理期间要执行的JAVA代码,脚本段可以产生输出,并将输出发送到客户端,也可以是一些流程控制语句.脚本段以
	&lt% 开始 , 以%&gt结束.它的语法如下:
	&lt% scriptlet %&gt
	XML语法格式的脚本段如下:
	&ltjsp:scriptlet&gtscriptlet&lt/jsp:script&gt
	
	在JSP容器转换JSP页面为Servlet类时,页面中的代码段会按照出现的次序,依次被转换为_jspService()方法中的代码,在脚本中声明的变量,将成为
	_jspService方法的本地变量,因此脚本段中的变量是线程安全的.
	<h2>表达式</h2>
	表达式脚本元素是Java语言中完整的表达式,在请求处理时计算这些表达式,计算的结果将被转换为字符串,插入到当前的输出流中.
	语法
	&lt%= expression %&gt
	xml:
	&ltjsp:expression&gt expression &lt/jsp:expression&gt
	
	</pre>
	
	例子:<br/>
	<%!
		//声明段
		String str = "this is declaration";
		int i =3;
	%>
	<table border="1">
	
	<%
		//脚本段
		for(int x=0;x<i;x++){
	%>
	<tr>
		<% //表达式段  %>
		<td><%=str %></td>
	</tr>	
	
	<%
		}
	%>
	</table>
</body>
</html>