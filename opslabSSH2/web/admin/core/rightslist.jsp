<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path =application.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="core/style/form.css">
<s:include value="/%{#request.getContextPath()}/scripts/script.jsp"></s:include>
<script type="text/javascript" src="scripts/util.js"></script>
<script type="text/javascript" src="scripts/business/core-rights.js"></script>
<script type="text/javascript" src="resoure/jquery.form.js"></script>
<title>Rights List</title>
</head>
<body>
		<div id="win1" class="easyui-window"  title="Rights Add" data-options="top: 160, left: 160, width: 350, height: 450,iconCls:'icon-add',resizable:false,closed:true">
	    <form id="ff" class="easyui-form" method="post">
	    	<table>
	    		<tr>
	    			<td>Rights Group:</td>
	    			<td><input class="easyui-combotree textbox"  name="groupId" data-options="required:true,url:'rights_listbranch.action',idField: 'rightsId',treeField: 'rightsName'"/></td>
	    		</tr>
	    		<tr>
	    			<td>Rights Name:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" name="rightsName" data-options="required:true,validType:'length[3,10]'"/></td>
	    		</tr>
	    		<tr>
	    			<td>Is Branch:</td>
	    			<td>
	    				<label>Yes</label><input type="radio" value="true" name="isBranch">
						<label>No</label><input type="radio" value="false" checked="checked" name="isBranch">
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>Address:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" name="address"/></td>
	    		</tr>
	    		<tr>
	    			<td>IsValid:</td>
	    			<td>
	    				<label>Yes</label><input type="radio" value="true" checked="checked" name="isValid"> 
						<label>No</label><input  type="radio" value="false" name="isValid">
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>IsPublic:</td>
	    			<td>
	    				<label>Yes</label><input type="radio" value="true" name="isPublic">
						<label>No</label><input type="radio" value="false" checked="checked" name="isPublic">
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>Rights Desc:</td>
	    			<td></td>
	    		</tr>
	    		<tr>
	    			<td></td>
	    			<td><textarea class="easyui-validatebox" name="rightsDesc" data-options="required:true"></textarea></td>
	    		</tr>
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<input id="form-add" type="button" class="easyui-linkbutton" value="JoinIn">
	    	<input id="form-reset" type="reset" class="easyui-linkbutton" value="Clear">
	    </div>
	</div>
	<table id="dd" class="easyui-treegrid" title="Rights List" 
		data-options="rownumbers:true,singleSelect:true,url:'rights_listmenuall.action',method:'get',toolbar:'#tb',fit:true,border:false,idField: 'rightsId',treeField: 'rightsName'">
		<thead>
			<tr>
				<th width="2%" data-options="field:'ck',checkbox:true"></th>
				<th width="15%" data-options="field:'rightsName'">权限名称</th>
				<th width="5%" data-options="field:'rightsId'">编码ID</th>
				<th width="5%" data-options="field:'rightsCode'">权限编码</th>
				<th width="5%" data-options="field:'rightsGroup'">权限编码组</th>
				<th width="5%" data-options="field:'isPublic'">是否公共</th>
				<th width="5%" data-options="field:'isValid'">是否有效</th>
				<th width="30%" data-options="field:'address'">权限地址</th>
				<th width="27%" data-options="field:'rightsDesc'">权限描述</th>
			</tr>
		</thead>
	</table>
	<div id="tb" style="padding: 2px; height: auto; text-align: left">
		<div class="easyui-buttons" id="buttons" style="margin-bottom: 2px">
			<input id="topSearchbox" name="topSearchbox" class="easyui-searchbox" data-options="width: 350, height: 26, prompt: '内容关键词', menu: '#topSearchboxMenu'" />
			<div id="topSearchboxMenu" style="width: 85px;">
				<div data-options="name:'0', iconCls: 'icon-hamburg-zoom'">SearchType</div>
				<div data-options="name:'1'">测试类型1</div>
				<div data-options="name:'2'">测试类型2</div>
				<div data-options="name:'3'">测试类型3</div>
				<div data-options="name:'4'">测试类型4</div>
			</div>
			<a href="#" id="list-add" class="easyui-linkbutton" data-options='iconCls:"icon-add",plain:"true"'></a>
			<a href="#" id="list-unuse" class="easyui-linkbutton" data-options='iconCls:"icon-remove",plain:"true"'></a> 
			<a href="#" id="list-edit" class="easyui-linkbutton" data-options='iconCls:"icon-edit",plain:"true"'></a> 
			<a href="#" id="list-save" class="easyui-linkbutton" data-options='iconCls:"icon-save",plain:"true"'></a> 
		</div>
	</div>
</body>
</html>