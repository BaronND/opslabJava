<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>业务日志</title>
    <jsp:include page="/ScriptEasyUI.jsp"/>
    <script type="text/javascript">
        function onSelect(pageNo, pageSize) {
            var data = {
                "startTime": $("#startTime").val(),
                "endTime": $("#endTime").val(),
                "businessName": $("#businessName").val(),
                "operationName": $("#operationName").val(),
                "userName": $("#userName").val(),
                "result": $("#result").val(),
                "page": pageNo,
                "rows": pageSize
            };
            $.ajax({
                url: "${contextPath}/log/business/list",
                data: data,
                type: "POST",
                dataType: 'json',
                success: function (data) {
                    $('#userlist').datagrid('loadData', data);
                },
                error: function (er) {
                    $.messager.alert('Warning', "请求异常，请稍后再试!");
                }
            });
        }
        function ClickRow(index,data){
            $("#dialog").dialog({
                title: '相信信息',
                width: 500,
                height: 800,
                closable: true,
                closed: false,
                cache: false,
                href: appurl("/log/business/info/"+data.id),
                modal: true
            });
        }
        $(function () {
            $("#userpage").pagination("select", 1);



        })
    </script>
</head>
<body class="easyui-layout">
<div id="dialog"></div>
<div id="query" class="easyui-panel">
    <form action="">
        <table class="gridtable" style="width: 100%;">
            <tr>
                <td width="15%" class="title">开始时间</td>
                <td width="35%">
                    <input id="startTime" name="startTime" class="easyui-datetimebox" style="width:300px;"
                           value="${startTime}">
                </td>
                <td width="15%" class="title">结束时间</td>
                <td width="35%">
                    <input id="endTime" name="endTime" class="easyui-datetimebox" style="width:300px;"
                           value="${endTime}">
                </td>
            </tr>
            <tr>
                <td class="title">操作名称</td>
                <td>
                    <input id="businessName" class="easyui-textbox" name="businessName" value="${businessName}"
                           type="text" style="width:300px;">
                </td>
                <td class="title">业务层实现类</td>
                <td>
                    <input id="operationName" class="easyui-textbox" name="operationName" value="${operationName}"
                           type="text" style="width:300px;">
                </td>
            </tr>
            <tr>
                <td class="title">操作人</td>
                <td>
                    <input id="userName" class="easyui-textbox" name="userName" value="${userName}" type="text"
                           style="width:300px;">
                </td>
                <td class="title">操作结果</td>
                <td>
                    <input id="result" class="easyui-textbox" name="result" type="text" value="${result}"
                           style="width:300px;">
                </td>
            </tr>
            <tr>
                <td colspan="4" style="text-align: center;">
                    <input type="submit" value="查询"/>
                    <input type="button" value="重置"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<div class="easyui-panel">
    <div title="查询结果" style="padding: 5px;overflow:auto">
        <table id="userlist" class="easyui-datagrid" title="业务日志" data-options="rownumbers:true,onDblClickRow:ClickRow">
            <thead>
            <tr>
                <th data-options="field:'startTime'" width="10%">开始时间</th>
                <th data-options="field:'uri'" width="20%">请求地址</th>
                <th data-options="field:'businessName'" width="10%">业务层操作名称</th>
                <th data-options="field:'userName'" width="10%">操作人</th>
                <th data-options="field:'operationName'" width="25%">业务层实现类及方法</th>
                <th data-options="field:'operationParam'" width="15%">操参数</th>
                <th data-options="field:'result'" width="8%">操作结果</th>
            </tr>
            </thead>
        </table>
        <div id="userpage" class="easyui-pagination" style="border: 1px solid #95B8E7;" data-options="
                total:${count},
                pageSize:App.page,
                pageList: [10,15,20,25],
                onSelectPage:onSelect"></div>
    </div>
</div>
</body>
</html>