<%@ page import="app.constant.constant" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% String path=request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<%=path%>/resoure/editor/css/editormd.css" />
    <link rel="stylesheet" href="<%=path%>/resoure/editor/css/editormd.preview.css" />
    <link rel="stylesheet" href="<%=path%>/resoure/bootstrap/css/bootstrap.min.css">
    <style>
        .row > div{
            margin: 0px;
            padding: 0px;
            width: 100%;
        }
        #layout >header,div{
            width: 100%;
        }
    </style>
    <!-- 以下两个插件用于在IE8以及以下版本浏览器支持HTML5元素和媒体查询，如果不需要用可以移除 -->
    <!--[if lt IE 9]>
    <script src="<%=path%>/resoure/bootstrap/html5shiv.js"></script>
    <script src="<%=path%>/resoure/bootstrap/respond.min.js"></script>
    <![endif]-->

    <script type="text/javascript" src="<%=path%>/resoure/jquery.js"></script>
    <script type="text/javascript" src="<%=path%>/resoure/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resoure/editor/lib/marked.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resoure/editor/lib/prettify.min.js"></script>

    <script type="text/javascript" src="<%=path%>/resoure/editor/lib/raphael.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resoure/editor/lib/underscore.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resoure/editor/lib/sequence-diagram.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resoure/editor/lib/flowchart.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resoure/editor/lib/jquery.flowchart.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resoure/editor/editormd.min.js"></script>
    <script type="text/javascript" src="<%=path%>/scripts/business/blog-blogpage.js"></script>
    <title>新增日志</title>
</head>
<body>
<div id="layout" class="container">
    <div class="row">
        <h1>${model.title}</h1>
    </div>
    <div class="row">
        <span class="label label-success">${model.label}</span>
    </div>
    <div id="test-editormd-view" class="row">
<textarea id="content" style="display:none;">${model.content}</textarea>
    </div>
</div>
</body>
</html>