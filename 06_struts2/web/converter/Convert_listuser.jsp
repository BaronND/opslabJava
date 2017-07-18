<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	*{
		margin: 0px;
		padding: 0px;
	}
</style>
<script type="text/javascript" src="../scripts/jquery-1.11.1.js"></script>
<title>当action和model在不同包的时候测试类型转换器</title>
<script type="text/javascript">
$(function(){
	var count = 0;
	$("#add").click(function(){
		count++;
		$("#button").before("<tr>"+
				"<td><input name='id[" + count + "]'/></td>"+
				"<td><input name='username[" + count + "]'/></td>"+
				"<td><input name='password[" + count + "]'/></td>"+
				"<td><input name='role[" + count + "]'/></td>"+
				"<td><input name='birth[" + count + "]'/></td>"+
				"<td></tr>");
		return false;
	});
	
	$("#add1").click(function(){
		count++;
		$("#button1").before("<tr>"+
				"<td><input name='user[" + count + "].id'/></td>"+
				"<td><input name='user[" + count + "].username'/></td>"+
				"<td><input name='user[" + count + "].password'/></td>"+
				"<td><input name='user[" + count + "].role'/></td>"+
				"<td><input name='user[" + count + "].birth'/></td>"+
				"</tr>");
		return false;
	
	});
	$("#add2").click(function(){
		count++;
		$("#button2").before("<tr>"+
				"<td><input name='userlist[" + count + "].id'/></td>"+
				"<td><input name='userlist[" + count + "].username'/></td>"+
				"<td><input name='ususerlister[" + count + "].password'/></td>"+
				"<td><input name='userlist[" + count + "].role'/></td>"+
				"<td><input name='userlist[" + count + "].birth'/></td>"+
				"</tr>");
		return false;
	
	});
	
	$("#remove").click(function(){
		count--;
		$("#button").prev("tr").remove();
		$("#button").prev("tr").remove();
		return false;
	
	});
	$("#remove1").click(function(){
		count--;
		$("#button1").prev("tr").remove();
		$("#button1").prev("tr").remove();
		return false;
	
	});
	$("#remove2").click(function(){
		count--;
		$("#button2").prev("tr").remove();
		$("#button2").prev("tr").remove();
		return false;
	
	});
});
</script>
</head>
<body>
	<s:debug></s:debug>
	
	<h5>List:直接写属性（貌似不行）</h5>
	<s:form action="/converter/userConverterAction.action" method="post">
	<table>
		<tr>
			<td>id</td>
			<td>username</td>
			<td>password</td>
			<td>role</td>
			<td>birth</td>
		</tr>
		<tr>
				<td><input name="id[0]"/></td>
				<td><input name="username[0]"/></td>
				<td><input name="password[0]"/></td>
				<td><input name="role[0]"/></td>
				<td><input name="birth[0]"/></td>
		</tr>
		<tr id="button">
				<td><button id="add">新加一个</button></td>
				<td><button id="remove">删除一个</button></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" value="Submit"/>
			</td>
		</tr>
		</tbody>
	</table>
	</s:form>
	
	<h5>List:直接写(属性名)属性</h5>
	<s:form action="/converter/userConverterAction.action" method="post">
	<table>
		<tr>
			<td>id</td>
			<td>username</td>
			<td>password</td>
			<td>role</td>
			<td>birth</td>
		</tr>
		<tr>
				<td><input name="user[0].id"/></td>
				<td><input name="user[0].username"/></td>
				<td><input name="user[0].password"/></td>
				<td><input name="user[0].role"/></td>
				<td><input name="user[0].birth"/></td>
		</tr>
		<tr id="button1">
				<td><button id="add1">新加一个</button></td>
				<td><button id="remove1">删除一个</button></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" value="Submit"/>
			</td>
		</tr>
		</tbody>
	</table>
	</s:form>
	
		<h5>List:直接写(属性名)属性</h5>
	<s:form action="/converter/userConverterAction.action" method="post" validate="true">
	<s:fielderror name="errors"></s:fielderror>
	<table>
		<tr>
			<td>id</td>
			<td>username</td>
			<td>password</td>
			<td>role</td>
			<td>birth</td>
		</tr>
		<tr>
				<td><input name="userlist[0].id"/></td>
				<td><input name="userlist[0].username"/></td>
				<td><input name="userlist[0].password"/></td>
				<td><input name="userlist[0].role"/></td>
				<td><input name="userlist[0].birth"/></td>
		</tr>
		<tr id="button2">
				<td><button id="add2">新加一个</button></td>
				<td><button id="remove2">删除一个</button></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" value="Submit"/>
			</td>
		</tr>
		</tbody>
	</table>
	</s:form>
</body>
</html>