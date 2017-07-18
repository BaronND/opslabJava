<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="opslab" uri="http://0opslab.com/opslabJ2ee" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>编码信息</title>
    <jsp:include page="/ScriptEasyUI.jsp"/>
    <script type="text/javascript">
        function selectPage(pageNo, pageSize) {
            $.getJSON('${contextPath}/admin/code/list/${codeType}',
                    {page: pageNo, rows: pageSize},
                    function (data) {
                        $('#codelist').datagrid('loadData', data);
                    });
        }
        function closeDialog() {
            $("#dialog").dialog({closed: true});
        }

        function addSave() {
            var url = "${contextPath}/admin/code/save";
            var data = appdata("#add_code_form");
            easyui_post(url, data, function (data) {
                $.messager.alert(data.result, data.msg, "info", function () {
                    window.location.reload();
                });
            });
        }


        function addCode() {
            $("#dialog").dialog({
                title: '新增',
                width: 600,
                height: 400,
                closable: false,
                closed: false,
                cache: false,
                href: '${contextPath}/admin/code/add/${codeType}',
                modal: true
            });
        }

        function nonsuse(id) {
            var url = "${contextPath}/admin/code/delete/" + id;
            easyui_get(url, "", function (data) {
                $.messager.alert(data.result, data.msg, "info", function () {
                    window.location.reload();
                });
            });
        }

        function activate(id) {
            var url = "${contextPath}/admin/code/activate/" + id;
            easyui_get(url, "", function (data) {
                $.messager.alert(data.result, data.msg, "info", function () {
                    window.location.reload();
                });
            });
        }
        function deleteItems(){
            var items = $("#codelist").datagrid('getChecked');
            var ids = arrayToString(items,function(d){return d.key;});
            if(ids){
                var url = "${contextPath}/admin/code/delete/" + ids;
                easyui_get(url, "", function (data) {
                    $.messager.alert(data.result, data.msg, "info", function () {
                        window.location.reload();
                    });
                });
            }else{
                $.messager.alert("提示", "请选择相应的记录", "info");
            }
        }

        $(function () {
            $("#codepage").pagination("select", 1);
        })
    </script>
</head>
<body>
<div class="easyui-panel" title="编码详细信息" style="margin-bottom: 5px;">
    <table class="gridtable">
        <tr>
            <td width="15%" class="title">业务主键</td>
            <td width="35%">
                ${code.id}
            </td>
            <td width="15%"  class="title">编码类型值</td>
            <td width="35%">
                ${code.codeId}
            </td>
        </tr>
        <tr>
            <td  class="title">编码名称</td>
            <td>
                ${code.codeName}
            </td>
            <td  class="title">创建时间</td>
            <td>
                ${code.createTime}
            </td>
        </tr>
        <tr>
            <td  class="title">编码类型</td>
            <td>
                ${code.codeType}
            </td>
            <td  class="title">是否有效</td>
            <td>
                ${code.valid}
            </td>
        </tr>
        <tr>
            <td  class="title">编码描述</td>
            <td colspan="3">
                ${code.memo}
            </td>
        </tr>
        <tr>
            <td colspan="4" style="text-align: center">
                <c:choose>
                    <c:when test="${1 == code.valid}">
                        <button class="easyui-linkbutton" onclick="nonsuse('${code.id}')">停用</button>
                    </c:when>
                    <c:when test="${0 == code.valid}">
                        <button class="easyui-linkbutton" onclick="activate('${code.id}')">启用</button>
                    </c:when>
                </c:choose>
            </td>
        </tr>
    </table>
</div>
<table id="codelist" class="easyui-datagrid" data-options="rownumbers:true">
    <thead>
    <tr>
        <th field="ck" checkbox="true"></th>
        <th data-options="field:'id'" width="20%">编码ID</th>
        <th data-options="field:'name'" width="20%">编码名称</th>
        <th data-options="field:'createTime'" width="15%">创建时间</th>
        <th data-options="field:'orderId'" width="5%">排序</th>
        <th data-options="field:'valid'" width="5%">是否有效</th>
        <th data-options="field:'memo'" width="30%">描述</th>
    </tr>
    </thead>
</table>
<div id="codepage" class="easyui-pagination tablepagination" data-options="
                total:${codeCount},
                pageSize:App.page,
                pageList: [10,15,20,25],
                onSelectPage:selectPage,
                buttons: [{
			            iconCls:'icon-add',
			            handler:addCode
		            },'-',{
			            iconCls:'icon-remove',
			            handler:deleteItems}]"></div>
<div id="dialog"></div>
</body>
</html>