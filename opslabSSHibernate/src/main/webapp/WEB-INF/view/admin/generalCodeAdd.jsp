<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form id="add_code_form" class="form-horizontal" role="form" action="#">
    <input type="hidden" name="codeType" value="${codeType}">
    <input type="hidden" name="tree" value="${tree}">
    <input type="hidden" name="partenId" value="${parentId}">
    <table class="gridtable" >
        <tr>
            <td width="15%" style="text-align: center">编码ID</td>
            <td width="35%" style="text-align: center">
                <input type="text" class="form-control" name="codeId"  placeholder="编码id">
            </td>
        </tr>
        <tr>
            <td width="15%" style="text-align: center">编码名称</td>
            <td width="35%" style="text-align: center">
                <input type="text" class="form-control" name="codeName"  placeholder="编码名称">
            </td>
        </tr>
        <tr>
            <td width="15%" style="text-align: center">排序字段</td>
            <td width="35%" style="text-align: center">
                <input type="text" class="form-control" name="orderId"  placeholder="排序字段">
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
            <td width="15%" style="text-align: center">编码描述</td>
            <td width="35%" style="text-align: center">
                <input type="text" class="form-control" name="memo" placeholder="编码描述">
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