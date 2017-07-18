<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<!--利用jsp统一导入后台JSP公用的css和js文件-->
<!--导入通用的样式文件和javascript文件-->
<link rel="stylesheet" type="text/css" href="<%=path%>/resource/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/resource/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/resource/ztree/css/zTreeStyle/zTreeStyle.css">
<!--自定义的通用CSS-->
<link rel="stylesheet" type="text/css" href="<%=path%>/style/admin/common.css">


<script type="text/javascript" src="<%=path%>/resource/easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/resource/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path%>/resource/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=path%>/scripts/easyui-setting.js"></script>
<script type="text/javascript" src="<%=path%>/resource/ztree/js/jquery.ztree.all.min.js"></script>


<script type="text/javascript" src="<%=path%>/scripts/business-util.js"></script>


<!--应用JS-->
<jsp:include page="session.jsp"/>
