<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>工作组管理</title>
    <jsp:include page="/ScriptEasyUI.jsp"/>
    <link rel="stylesheet" type="text/css" href="${contextPath}/style/admin/workgroup.css">
    <script type="text/javascript">

    </script>
</head>
<body class="easyui-layout">
<div class="center" data-options="region:'center',noheader:true">
    <div class="easyui-panel" title="工作组信息">
        <table id="table" class="gridtable">
            <tr>
                <td width="15%" class="title">工作组id</td>
                <td width="35%">${group.groupId}</td>
                <td width="15%" class="title">工作组名称</td>
                <td width="35%">${group.groupName}</td>
            </tr>
            <tr>
                <td width="15%" class="title">父id</td>
                <td width="35%">${group.parentId}</td>
                <td width="15%" class="title">创建时间</td>
                <td width="35%">${group.createTime}</td>
            </tr>
            <tr>
                <td width="15%" class="title">是否有效</td>
                <td width="35%">${group.valid}</td>
                <td width="15%" class="title">组内用户数量</td>
                <td width="35%">${userCount}</td>
            </tr>
            <tr>
                <td colspan="4" class="title">工作组描述</td>
            </tr>
            <tr>
                <td colspan="4">${group.descript}</td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
