<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户角色管理</title>
    <jsp:include page="/ScriptEasyUI.jsp"/>
    <script type="text/javascript">
        function onUserPageSelect(pageNo, pageSize) {
            $.getJSON('${contextPath}/admin/role/userlist/${role.roleId}',
                    {page: pageNo, rows: pageSize},
                    function (data) {
                        $('#userlist').datagrid('loadData', data);
                    });
        }
        $(function () {
            $("#userpage").pagination("select",1);
        })
    </script>
</head>
<body>
<table class="gridtable" style="width: 100%;">
    <tr>
        <td width="15%" class="title">角色ID</td>
        <td width="35%">${role.roleId}</td>
        <td width="15%" class="title">角色名称</td>
        <td width="35%">${role.roleName}</td>
    </tr>
    <tr>
        <td width="15%" class="title">分类</td>
        <td width="35%">${role.parentId}</td>
        <td width="15%" class="title">创建时间</td>
        <td width="35%">${role.createTime}</td>
    </tr>
    <tr>
        <td width="15%" class="title">是否有效</td>
        <td width="35%">${role.valid}</td>
        <td width="15%"></td>
        <td width="35%"></td>
    </tr>
    <tr>
        <td width="15%" class="title">描述信息</td>
        <td colspan="3" width="75%">${role.descript}</td>
    </tr>
</table>
<div class="easyui-tabs">
    <div title="用户列表"  style="padding: 5px;overflow:auto">
        <table id="userlist" class="easyui-datagrid" title="用户列表" data-options="rownumbers:true">
            <thead>
            <tr>
                <th data-options="field:'userId'" width="20%">用户ID</th>
                <th data-options="field:'userCode'"  width="15%">用户编码</th>
                <th data-options="field:'userName'"  width="20%">用户名称</th>
                <th data-options="field:'deptId'"  width="20%">用户部门</th>
                <th data-options="field:'valid'"  width="5%">用户状态</th>
                <th data-options="field:'createTime'"  width="15%">创建时间</th>
            </tr>
            </thead>
        </table>
        <div id="userpage" class="easyui-pagination" style="border: 1px solid #95B8E7;" data-options="
                total:${userCount},
                pageSize:App.page,
                pageList: [10,15,20,25],
                onSelectPage:onUserPageSelect"></div>
    </div>
    <div title="权限列表"  style="padding:10px;">
        <table id="rightslist"></table>
    </div>
</div>
</body>
</html>


