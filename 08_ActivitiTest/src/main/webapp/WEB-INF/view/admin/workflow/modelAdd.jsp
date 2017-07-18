<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();%>
<div class="container-fluid" style="padding-top: 20px;">
    <form id="add_model_form" class="form-horizontal" role="form" action="#">

        <div class="input-group form-row">
            <span class="input-group-addon">模型key</span>
            <input type="text" class="form-control" id="key" name="key">
        </div>

        <div class="input-group form-row">
            <span class="input-group-addon">模型名称</span>
            <input type="text" class="form-control" id="name" name="name">
        </div>

        <div class="input-group form-row">
            <span class="input-group-addon">模型分类</span>
            <input type="text" class="form-control" id="category" name="category">
        </div>

        <div class=" form-row">
            <span class="input-group-addon">描述</span>
            <textarea id="description" name="description"  class="form-control" rows="3"></textarea>
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