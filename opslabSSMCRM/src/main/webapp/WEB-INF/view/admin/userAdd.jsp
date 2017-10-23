<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form id="add_user_form" class="form-horizontal" role="form" action="#">
    <input type="hidden" name="parentId" value="${parentID}">
<table class="gridtable" >

    <tr>
        <td width="15%" style="text-align: center">用户编码</td>
        <td width="35%" style="text-align: center">
            <input type="text" class="form-control" name="userCode"  placeholder="userCode">
        </td>
        </tr>
    <tr>
        <td width="15%" style="text-align: center">用户密码</td>
        <td width="35%" style="text-align: center">
            <input type="password" class="form-control" name="password">
        </td>
    </tr>
    <tr>
        <td width="15%" style="text-align: center">用户名称</td>
        <td width="35%" style="text-align: center">
            <input type="text" class="form-control" name="userName" placeholder="userName">
        </td>
    </tr>
    <tr>
        <td width="15%" style="text-align: center">用户性别</td>
        <td width="35%" style="text-align: center">
            <select class="form-control" name="sex">
                <option value="1">男</option>
                <option value="2">女</option>
            </select>
        </td>
    </tr>
    <tr>
        <td width="15%" style="text-align: center">用户部门</td>
        <td width="35%" style="text-align: center">
            <input id="deptid" type="hidden" name="deptName">
            <input id="deptname" type="text" class="form-control" name="deptName"  placeholder="部门名称"
                   onfocus="selectDept(function(deptId,deptName){
                $('#deptid').val(deptId);
                $('#deptname').val(deptName);
            })">
        </td>
    </tr>
    <tr>
        <td colspan="2" style="text-align: center">
            <button type="button" class="btn btn-default btn-ms" onclick="addSave()">
                添加
            </button>
            <button type="button" class="btn btn-default btn-ms" onclick="closeDialog()">
                关闭
            </button>
        </td>
    </tr>
</table>
</form>