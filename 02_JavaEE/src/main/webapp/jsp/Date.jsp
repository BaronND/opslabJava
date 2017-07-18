<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	out.println(sdf.format(new Date()));
%>
<script>
	function reload(){
		window.location = window.location;
	}
	setInterval(reload,2000);
</script>