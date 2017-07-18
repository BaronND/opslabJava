<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>系统登录</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/resource/bootstrap/css/bootstrap.min.css">
    <style type="text/css">
        .signin {
            width:477px;
            height:402px;
            background:url(<%=path%>/images/login_bg.png) no-repeat;
            margin:0 auto;
            position:absolute;
            top:50%;
            left:50%;
            margin-top:-239px;
            margin-left:-238px;
        }
        .signin-head {
            margin:0 auto;
            padding-top:30px;
            width:120px;
        }
        .form-signin {
            max-width: 330px;
            padding: 43px 15px 15px 15px;
            margin: 0 auto;
        }
        .form-signin .checkbox {
            margin-bottom: 10px;
        }
        .form-signin .checkbox {
            font-weight: normal;
        }
        .form-signin .form-control {
            position: relative;
            font-size: 16px;
            height: auto;
            padding: 10px;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
        }
        .form-signin .form-control:focus {
            z-index: 2;
        }
        .form-signin input[type="text"] {
            margin-bottom: 14px;
            border-radius: 0;
            background: url(<%=path%>/images/login_user.png) 0 0  no-repeat;
            padding-left:60px;
        }
        .form-signin input[type="password"] {
            margin-bottom: 10px;
            border-radius: 0;
            background: url(<%=path%>/images/login_pas.png) 0 0  no-repeat;
            padding-left:60px;
        }
        .form-signin button {
            border-radius: 0;
        }
    </style>
    <script type="text/javascript" src="<%=path%>/resource/easyui/jquery.min.js"></script>
    <!-- 以下两个插件用于在IE8以及以下版本浏览器支持HTML5元素和媒体查询，如果不需要用可以移除 -->
    <!--[if lt IE 9]>
    <script type="text/javascript" src="<%=path%>/resource/bootstrap/html5shiv.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resource/bootstrap/respond.min.js"></script>
    <![endif]-->
    <!-- 包括所有bootstrap的js插件或者可以根据需要使用的js插件调用　-->
    <script type="text/javascript" src="<%=path%>/resource/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function login(){
            var userid = $("#userid").val();
            var passwd = $("#passwd").val();
            if(userid && passwd){
                $("#form").submit();
            }
            return false;
        }
    </script>
</head>
<body>
<div class="signin">
    <div class="signin-head"><img src="images/test/head_120.png" alt="" class="img-circle"></div>
    <form id="form" class="form-signin" role="form" action="<%=path%>/userlogin" method="post">
        <input type="text" id="userid" name="userid" class="form-control" placeholder="用户名" required autofocus />
        <input type="password" id="passwd" name="passwd" class="form-control" placeholder="密码" required />
        <button class="btn btn-lg btn-warning btn-block" type="button" onclick="login()">登录</button>
        <label class="checkbox">
            <input type="checkbox" value="remember-me"> 记住我
        </label>
    </form>
</div>
</body>
</html>
