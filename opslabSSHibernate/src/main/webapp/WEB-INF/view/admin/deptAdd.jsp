<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--因为是利用easyui的特性将页面加载的父页面显示，因此此处只写html机构即可，样式与js全部在父页面完成--%>
<div class="container-fluid" style="padding-top: 50px;">
    <form id="add_dept_form" class="form-horizontal" role="form" action="#">
        <input type="hidden" name="parentId" value="${parentID}">

        <div class="input-group form-row">
            <span class="input-group-addon">上级部门</span>
            <input type="text" class="form-control" name="parentName" value="${parentName}" placeholder="parentId">
        </div>

        <div class="input-group form-row">
            <span class="input-group-addon">部门名词</span>
            <input type="text" class="form-control" name="deptName" placeholder="deptName">
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