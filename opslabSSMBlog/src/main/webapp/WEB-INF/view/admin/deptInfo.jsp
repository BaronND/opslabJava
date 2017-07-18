<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="opslab" uri="http://0opslab.com/opslabJ2ee" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户角色管理</title>
    <jsp:include page="/ScriptEasyUI.jsp"/>
    <script type="text/javascript">
        function onUserPageSelect(pageNo, pageSize) {
            $.getJSON('${contextPath}/admin/dept/userlist/${dept.deptId}',
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
        <td width="15%" class="title">实体ID</td>
        <td width="35%">${dept.id}</td>
        <td width="15%" class="title">部门ID</td>
        <td width="35%">${dept.deptId}</td>
    </tr>
    <tr>
        <td width="15%" class="title">父部门</td>
        <td width="35%">
            <opslab:dept id="${dept.parentId}"/>
        </td>
        <td width="15%" class="title">部门名称</td>
        <td width="35%">${dept.detpName}</td>
    </tr>
    <tr>
        <td width="15%" class="title">是否有效</td>
        <td width="35%">${dept.valid}</td>
        <td width="15%"></td>
        <td width="35%"></td>
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
        <div id="userpage" class="easyui-pagination tablepagination" data-options="
                total:${countUser},
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



