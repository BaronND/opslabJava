<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>业务日志</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/resource/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/resource/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/resource/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/style/admin/common.css">
</head>
<body class="easyui-layout">
<div id="dialog"></div>
<div id="query" class="easyui-panel">
    <form id="queryForm" action="#">
        <table class="gridtable" style="width: 100%;">
            <tr>
                <td class="title">上传组名称</td>
                <td>
                    <input id="gid" class="easyui-textbox" name="gid" value="${gid}" type="text" style="width:300px;">
                </td>
                <td class="title">业务主键</td>
                <td>
                    <input id="bid" class="easyui-textbox" name="bid" value="${bid}" type="text" style="width:300px;">
                </td>
            </tr>
            <tr>
                <td class="title">上传文件</td>
                <td>
                    <input id="oldName" class="easyui-textbox" name="oldName" value="${oldName}" type="text"
                           style="width:300px;">
                </td>
                <td class="title">存储文件</td>
                <td>
                    <input id="newName" class="easyui-textbox" name="name" value="${newName}" type="text"
                           style="width:300px;">
                </td>
            </tr>
            <tr>
                <td width="15%" class="title">开始时间</td>
                <td width="35%">
                    <input id="starttime" name="starttime" class="easyui-datetimebox" style="width:300px;"
                           value="${starttime}">
                </td>
                <td width="15%" class="title">结束时间</td>
                <td width="35%">
                    <input id="endtime" name="endtime" class="easyui-datetimebox" style="width:300px;"
                           value="${endtime}">
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
        <table id="userlist" class="easyui-datagrid" title="业务日志" data-options="rownumbers:true">
            <thead>
            <tr>
                <th data-options="field:'gid'" width="5%">上传用户组</th>
                <th data-options="field:'bid'" width="5%">业务主键</th>
                <th data-options="field:'createTime'" width="10%">上传时间</th>
                <th data-options="field:'oldName'" width="10%">上传文件</th>
                <th data-options="field:'newName'" width="18%">存储文件</th>
                <th data-options="field:'size'" width="8%">文件大小</th>
                <th data-options="field:'path'">文件存储路径</th>
            </tr>
            </thead>
        </table>
        <div id="userpage" class="easyui-pagination" style="border: 1px solid #95B8E7;" data-options="
                total:${count},
                pageSize:20,
                pageList: [10,15,20,25],
                onSelectPage:onSelect"></div>
    </div>
</div>
<script src="<%=path%>/resource/easyui/jquery.min.js"></script>
<script src="<%=path%>/resource/easyui/jquery.easyui.min.js"></script>
<script src="<%=path%>/resource/easyui/locale/easyui-lang-zh_CN.js"></script>
<script src="<%=path%>/scripts/easyui-setting.js"></script>
<script src="<%=path%>/resource/ztree/js/jquery.ztree.all.min.js"></script>
<script src="<%=path%>/scripts/App.js"></script>
<script src="<%=path%>/scripts/business-util.js"></script>
<script>
    function onSelect(pageNo, pageSize) {
        var data = new FormData(document.getElementById("queryForm"));
        data.append('page', pageNo);
        data.append('rows', pageSize);
        $.ajax({
            url: APP_URL + "/uploadlog/page.do",
            data: data,
            type: "POST",
            contentType: false,
            processData: false,
            dataType: 'json',
            success: function (data) {
                $('#userlist').datagrid('loadData', data);
            },
            error: function (er) {
                $.messager.alert('Warning', "请求异常，请稍后再试!");
            }
        });
    }
    function ClickRow(index, data) {
        $("#dialog").dialog({
            title: '相信信息',
            width: 500,
            height: 800,
            closable: true,
            closed: false,
            cache: false,
            href: APP_URL + "/uploadlog/info.do?id=" + data.id,
            modal: true
        });
    }
    $(function () {
        $("#userpage").pagination("select", 1);
    });
</script>
</body>
</html>