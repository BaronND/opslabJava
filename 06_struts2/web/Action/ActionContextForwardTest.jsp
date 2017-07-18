<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试ActionContext</title>
</head>
<body>
	<%
		application.setAttribute("appName", "测试ActionContext");
		application.setAttribute("appVersion", "appVersion 0.0.1");
		
		session.setAttribute("userName","snake");
		session.setAttribute("role", "ghost-like");
		
		
		/**
		 * 注意：这样设置后服务端是获取不到值的，因为他是通过超链接的方式访问即另外发起了一个请求
		 * 此处除非是forward跳转，即服务端跳转
		 */
		request.setAttribute("requestId", "ghost007");
	%>
	<jsp:forward page="../action/ActionContextTest.action"></jsp:forward>
	
</body>
</html>