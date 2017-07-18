<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户管理</title>
    <jsp:include page="/ScriptEasyUI.jsp"/>
    <script type="text/javascript">
        /**
         * 新增user
         */
        function addUser() {
            $("#dd").dialog({
                title: '新增用户',
                width: 600,
                height: 400,
                closable: false,
                closed: false,
                cache: false,
                href: '${contextPath}/admin/user/add',
                modal: true
            });
        }
        /**
         * 添加用户
         */
        function addSave() {
            $.ajax({
                type: "post",
                url: "${contextPath}/admin/user/save",
                cache: false,
                data: $("#add_user_form").serialize(),
                dataType: "json",
                success: function (data) {
                    $.messager.alert(data.result, data.msg, "info", function () {
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

        function onUserPageSelect(pageNo, pageSize) {
            var url = appurl("admin/user/list");
            var fromdata = appdata($("#queryfrom"), {page: pageNo, rows: pageSize});
            $.getJSON(url, fromdata, function (data) {
                $('#userlist').datagrid('loadData', data);
            });
        }
        $(function () {
            $("#userpage").pagination("select", 1);
        });
    </script>
</head>
<body>
<div id="dd"></div>
<div id="query" class="easyui-panel query" title="用户管理">
    <form id="queryfrom" action="" method="post">
        <table class="gridtable">
            <tr>
                <td width="15%" class="title">
                    用户编码
                </td>
                <td width="35%">
                    <input type="text" id="usercode" name="usercode" value="${usercode}" class="form-control">
                </td>
                <td width="15%" class="title">
                    用户名称
                </td>
                <td width="35%">
                    <input type="text" id="username" name="username" value="${username}" class="form-control">
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <button type="submit" class="btn btn-primary btn-xs">查询</button>
                    <button type="reset" class="btn btn-primary btn-xs">重置</button>
                    <button type="button" class="btn btn-primary btn-xs" onclick="addUser()">新增</button>
                </td>
            </tr>
        </table>
    </form>
</div>
<table id="userlist" class="easyui-datagrid" title="用户列表" data-options="rownumbers:true">
    <thead>
    <tr>
        <th data-options="field:'userId'" width="20%">用户ID</th>
        <th data-options="field:'userCode'" width="15%">用户编码</th>
        <th data-options="field:'userName'" width="20%">用户名称</th>
        <th data-options="field:'deptId'" width="20%">用户部门</th>
        <th data-options="field:'valid'" width="5%">用户状态</th>
        <th data-options="field:'createTime'" width="15%">创建时间</th>
    </tr>
    </thead>
</table>
<div id="userpage" class="easyui-pagination tablepagination" data-options="
      total:${userCount},
      pageSize:App.page,
      pageList: [10,15,20,25],
      onSelectPage:onUserPageSelect"></div>
</div>
</body>
</html>