<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<!--利用jsp统一导入后台JSP公用的css和js文件-->
<!--导入通用的样式文件和javascript文件-->
<link rel="stylesheet" type="text/css" href="<%=path%>/resource/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/resource/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/resource/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/resource/ztree/css/zTreeStyle/zTreeStyle.css">

<link rel="stylesheet" type="text/css" href="<%=path%>/admin/style/common.css">


<script type="text/javascript" src="<%=path%>/resource/easyui/jquery.min.js"></script>
<!-- 以下两个插件用于在IE8以及以下版本浏览器支持HTML5元素和媒体查询，如果不需要用可以移除 -->
<!--[if lt IE 9]>
<script type="text/javascript" src="<%=path%>/resource/bootstrap/html5shiv.min.js"></script>
<script type="text/javascript" src="<%=path%>/resource/bootstrap/respond.min.js"></script>
<![endif]-->
<!-- 包括所有bootstrap的js插件或者可以根据需要使用的js插件调用　-->
<script type="text/javascript" src="<%=path%>/resource/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path%>/resource/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path%>/resource/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=path%>/resource/ztree/js/jquery.ztree.all.min.js"></script>
<script type="text/javascript" src="<%=path%>/scripts/business-util.js"></script>
<jsp:include page="session.jsp"/>