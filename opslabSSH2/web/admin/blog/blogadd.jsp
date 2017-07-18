<%@ page import="app.constant.constant" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% String path=request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<%=path%>/resoure/editor/css/editormd.css" />
    <link rel="stylesheet" href="<%=path%>/resoure/bootstrap/css/bootstrap.min.css">
    <!-- 以下两个插件用于在IE8以及以下版本浏览器支持HTML5元素和媒体查询，如果不需要用可以移除 -->
    <!--[if lt IE 9]>
    <script src="<%=path%>/resoure/bootstrap/html5shiv.js"></script>
    <script src="<%=path%>/resoure/bootstrap/respond.min.js"></script>
    <![endif]-->

    <script type="text/javascript" src="<%=path%>/resoure/jquery.js"></script>
    <script type="text/javascript" src="<%=path%>/resoure/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resoure/editor/editormd.min.js"></script>
    <script type="text/javascript" src="<%=path%>/scripts/business/blog-blogadd.js"></script>
    <title>新增日志</title>
</head>
<body>
<div id="layout" class="container">
    <form id="blogform" role="form">
        <div class="form-group">
            <input  class="form-control" id="title" placeholder="blog title">
        </div>
        <div class="form-group">
            <input  class="form-control" id="label" placeholder="blog label">
        </div>
        <div class="form-group" id="test-editormd">
            <textarea style="display:none;"></textarea>
        </div>
        <div style="text-align:center">
            <button type="button" id="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>
</div>
</body>
</html>