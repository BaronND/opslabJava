<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试集合类型</title>
<script type="text/javascript" src="../scripts/jquery-1.11.1.js"></script>
<script type="text/javascript">
	
	$(function(){
		var count = 0;
		$("#add").click(function(){
			count++;
			$("#button").before("<tr><td><input name='persons[" + count + "].name'/></td><td><input name='persons[" + count + "].birth'/></td></tr>");
			return false;
		
		});
		
		$("#remove").click(function(){
			count--;
			$("#button").prev("tr").remove();
			$("#button").prev("tr").remove();
			
			return false;
		
		});
	});
	
</script>
</head>
<body>
	<form action="converter/collectionAction.action" method="post">
		<table>
			<tr>
				<td>Name</td>
				<td>birth</td>
			</tr>
			<tbody>
				<tr>
					<td><input name="persons[0].name"/></td>
					<td><input name="persons[0].birth"/></td>
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
	</form>
</body>
</html>