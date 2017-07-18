<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
   String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Spring-mvc</title>
    <jsp:include page="/adminScript.jsp"/>
    <script type="text/javascript">
        /**
         * 新增user
         */
        function addUser(){
            $("#dd").dialog({
                title: '新增用户',
                width: 600,
                height: 400,
                closable: false,
                closed: false,
                cache: false,
                href: '<%=path%>/admin/user/add',
                modal: true
            });
        }
        /**
         * 添加用户
         */
        function addSave(){
            $.ajax({
                type:"post",
                url:"<%=path%>/admin/user/save",
                cache:false,
                data:$("#add_user_form").serialize(),
                dataType:"json",
                success:function(data){
                    $.messager.alert(data.result,data.msg,"info",function(){
                        window.location.reload();
                    });
                }
            });
        }
        /**
         * 关闭新增窗口
         */
        function closeDialog() {
            $("#dd").dialog({closed: true});
        }
        //页面加载完毕后显示的数据
        function initList(){
            $('#table').datagrid({
                url:'/admin/user/list',
                title: '查询结果',
                columns:[[
                    {field:'id',title:'id',width:'20%'},
                    {field:'userCode',title:'用户编码',width:'15%'},
                    {field:'userName',title:'用户名称',width:'20%'},
                    {field:'deptId',title:'所在部门',width:'15%'},
                    {field:'valid',title:'用户状态',width:'10%'},
                    {field:'createTime',title:'创建时间',width:'20%'},
                ]]
            });
        }
        $(function(){
            initList();
        });
    </script>
</head>
<body>
<div id="dd"></div>
<div id="query"  class="easyui-panel query" title="用户管理" >
    <table class="gridtable" >
        <tr>
            <td width="15%">
                用户编码
            </td>
            <td width="35%">
                <input type="text" name="usercode" class="form-control">
            </td>
            <td width="15%">
                用户名称
            </td>
            <td width="35%">
                <input type="text" name="username" class="form-control">
            </td>
        </tr>
        <tr>
            <td colspan="4">
                <button type="button" class="btn btn-primary btn-xs">查询</button>
                <button type="button" class="btn btn-primary btn-xs">重置</button>
                <button type="button" class="btn btn-primary btn-xs" onclick="addUser()">新增</button>
            </td>
        </tr>
    </table>
</div>
<table id="table"></table>
</body>
</html>