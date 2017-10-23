<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form id="add_menu_form" class="form-horizontal" role="form" action="#" method="post">
    <table class="gridtable">
        <tr>
            <td width="15%" style="text-align: center">菜单类型</td>
            <td width="35%" style="text-align: center">
                <input  class="easyui-combotree"
                        data-options="url:'${contextPath}/codemap/SYS_MENU_TYPE',required:true"
                        style="width: 300px" name="type">
            </td>
        </tr>
        <tr>
            <td width="15%" style="text-align: center">父级菜单</td>
            <td width="35%" style="text-align: center">
                <input type="text" class="easyui-textbox" style="width: 300px" name="pId" value="${pId}">
            </td>
        </tr>
        <tr>
            <td width="15%" style="text-align: center">菜单名称</td>
            <td width="35%" style="text-align: center">
                <input type="text" class="easyui-textbox" style="width: 300px" name="name">
            </td>
        </tr>
        <tr>
            <td width="15%" style="text-align: center">是否有效</td>
            <td width="35%" style="text-align: center">
                <input name="valid"
                       class="easyui-combotree"
                       data-options="url:'${contextPath}/codemap/valid_status',required:true">
            </td>
        </tr>
        <tr>
            <td width="15%" style="text-align: center">菜单地址</td>
            <td width="35%" style="text-align: center">
                <input type="text" class="easyui-textbox" style="width: 300px" name="address">
            </td>
        </tr>
        <tr>
            <td width="15%" style="text-align: center">描述信息</td>
            <td width="35%" style="text-align: center">
                <input type="text" class="easyui-textbox" style="width: 300px" name="desc">
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