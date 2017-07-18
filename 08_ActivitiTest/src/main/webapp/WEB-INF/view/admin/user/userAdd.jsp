<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-fluid" style="padding-top: 20px;">
    <form id="add_user_form" class="form-horizontal" role="form" action="#">
        <input type="hidden" name="parentId" value="${parentID}">

        <div class="input-group form-row">
            <span class="input-group-addon">用户编码</span>
            <input type="text" class="form-control" name="userCode"  placeholder="userCode">
        </div>

        <div class="input-group form-row">
            <span class="input-group-addon">用户密码</span>
            <input type="password" class="form-control" name="password">
        </div>

        <div class="input-group form-row">
            <span class="input-group-addon">用户名称</span>
            <input type="text" class="form-control" name="userName" placeholder="userName">
        </div>

        <div class="input-group form-row">
            <span class="input-group-addon">用户性别</span>
            <select class="form-control" name="sex">
                <option value="1">男</option>
                <option value="2">女</option>
            </select>
        </div>

        <div class="input-group form-row">
            <span class="input-group-addon">用户部门</span>
            <input id="deptid" type="hidden" name="deptName">
            <input id="deptname" type="text" class="form-control" name="deptName"  placeholder="部门名称"
            onfocus="selectDept(function(deptId,deptName){
                $('#deptid').val(deptId);
                $('#deptname').val(deptName);
            })">
        </div>
        <hr>
        <div class="container-fluid form-button-row">
            <button type="button" class="btn btn-default btn-ms" onclick="addSave()">
                添加
            </button>
            <button type="button" class="btn btn-default btn-ms" onclick="closeDialog()">
                关闭
            </button>
        </div>
    </form>
</div>