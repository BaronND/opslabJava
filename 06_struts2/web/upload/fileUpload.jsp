<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>
	<s:debug></s:debug>
	<s:form action="/file/Fileupload.action" method="post" enctype="multipart/form-data" theme="simple">
		<s:fielderror name="file"></s:fielderror><s:actionerror/>
		<s:file name="file" label="File"></s:file>
		<s:submit value="upload"></s:submit>
	</s:form>
</body>
</html>