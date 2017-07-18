<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP forward的跳转</title>
</head>
<body>
	<jsp:forward page="forwardTarget.jsp">
		<jsp:param value="test" name="name"/>
		<jsp:param value="this 's string" name="info"/>
	</jsp:forward>
</body>
</html>