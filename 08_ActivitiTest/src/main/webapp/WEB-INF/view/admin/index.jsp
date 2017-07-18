<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Spring-mvc</title>
    <!--导入通用的样式文件和javascript文件-->
    <link rel="stylesheet" type="text/css" href="<%=path%>/resource/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/resource/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/admin/style/index.css" />
    <script type="text/javascript" src="<%=path%>/resource/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resource/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=path%>/admin/scripts/index.js"></script>
</head>
<body class="easyui-layout">
<div class="north" data-options="region:'north',border:false">
    <div>
        <div>
        </div>
    </div>
    <div class="panel-header panel-header-noborder top-toolbar">
        <div id="infobar">当前用户:sysadmin 用户组:超级管理员</div>
        <div id="buttonbar">
            <a href="#" class="easyui-linkbutton" data-options="plain:true">清楚缓存</a>
            <a href="#" class="easyui-linkbutton" data-options="plain:true">全屏模式</a>
            <a href="#" class="easyui-linkbutton" data-options="plain:true">退出系统</a>
        </div>
    </div>
</div>
<div class="west" data-options="region:'west',title:'系统管理'">
    <div  style="padding:0px;">
        <ul id="menu-list" class="easyui-tree">
            <li>
                <a href="javascript:addTabs('用户管理','<%=path%>/admin/user')">用户管理</a>
            </li>
            <li>
                <a href="javascript:addTabs('部门管理','<%=path%>/admin/dept')">部门管理</a>
            </li>
            <li>
                <a href="javascript:addTabs('流程管理','<%=path%>/workflow/processdef')">流程管理</a>
            </li>
            <li>
                <a href="javascript:addTabs('流程模型','<%=path%>/activiti-model')">流程模型</a>
            </li>
        </ul>
    </div>
</div>
<div class="east" data-options="region:'east',split:false,collapsed:true,title:'信息'">
    <div class="easyui-calendar" style="height:150px;"></div>
</div>
<div class="south" data-options="region:'south',border:false">
    <div id="status"></div>
</div>
<div class="center" data-options="region:'center',noheader:true">
    <div id="tt" class="easyui-tabs" data-options='fit:true,border:false'>
        <div title="About">
            <p style="font-size:14px">jQuery EasyUI framework helps you build your web pages easily.</p>
            <ul>
                <li>easyui is a collection of user-interface plugin based on jQuery.</li>
                <li>easyui provides essential functionality for building modem, interactive, javascript applications.</li>
                <li>using easyui you don't need to write many javascript code, you usually defines user-interface by writing some HTML markup.</li>
                <li>complete framework for HTML5 web page.</li>
                <li>easyui save your time and scales while developing your products.</li>
                <li>easyui is very easy but powerful.</li>
            </ul>
        </div>
    </div>
    <div id="w" class="modelWindow easyui-window" title="Modal Window" data-options="modal:true,closed:true,closable:false,collapsible:false,minimizable:false,maximizable:false,resizable:false">
        <div class="easyui-layout" data-options="fit:true">
            <div data-options="border:false" style="padding:5px 0 0;">
                prompt content
            </div>
            <div class="dialog-button">
                <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="alert('ok');$('#w').window('close');" style="width:80px">Ok</a>
                <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="alert('cancel')" style="width:80px">Cancel</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
