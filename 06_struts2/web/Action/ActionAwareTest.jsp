<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试ActionAware</title>
</head>
<body>
	<%
		application.setAttribute("appName", "测试ActionAware");
		application.setAttribute("appVersion", "appVersion 0.0.1");
		
		session.setAttribute("userName","snake");
		session.setAttribute("role", "ghost-like");
		
		
		/**
		 * 注意：这样设置后服务端是获取不到值的，因为他是通过超链接的方式访问即另外发起了一个请求
		 * 此处除非是forward跳转，即服务端跳转
		 */
		request.setAttribute("requestId", "ghost007");
		request.setAttribute("Test01", "Test01");
		request.setAttribute("Test02", "Test02");
	%>
	
	<form action="../action/ActionAwareTest.action">
		<input type="text" name="id" value="007"><br>
		<input type="text" name="productId" value="apple-001"><br>
		<input type="text" name="productName" value="apple-mac-pro"><br>
		<input type="submit" value="Test ActionContext">
	</form>
</body>
</html>