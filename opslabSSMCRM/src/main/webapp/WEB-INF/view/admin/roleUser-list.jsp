<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>角色用户信息</title>
    <jsp:include page="/ScriptEasyUI.jsp"/>
    <link rel="stylesheet" type="text/css" href="${contextPath}/style/admin/deptlist.css">
    <script type="text/javascript">

    </script>
</head>
<body>
<table id="userlist" class="easyui-datagrid" title="用户列表"
       data-options="rownumbers:true,pagination:true,
               url:'${contextPath}/admin/role/users/${roleId}',method:'post'">
    <thead>
    <tr>
        <th data-options="field:'id'" width="15%">用户ID</th>
        <th data-options="field:'userCode'"  width="15%">用户编码</th>
        <th data-options="field:'userName'"  width="20%">用户名称</th>
        <th data-options="field:'deptId'"  width="20%">用户部门</th>
        <th data-options="field:'valid'"  width="5%">用户状态</th>
        <th data-options="field:'createTime'"  width="15%">创建时间</th>
    </tr>
    </thead>
</table>
</body>
</html>