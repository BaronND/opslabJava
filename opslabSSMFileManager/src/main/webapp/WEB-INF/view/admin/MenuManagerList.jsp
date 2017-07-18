<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>菜单管理</title>
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
                <td class="title">菜单名称</td>
                <td>
                    <input id="gid" class="easyui-textbox" name="gid" value="${gid}" type="text" style="width:300px;">
                </td>
                <td class="title">菜单类型</td>
                <td>
                    <input id="bid" class="easyui-textbox" name="bid" value="${bid}" type="text" style="width:300px;">
                </td>
            </tr>
            <tr>
                <td width="15%" class="title">菜单地址</td>
                <td width="35%">
                    <input id="address" name="address" class="easyui-textbox" style="width:300px;"
                           value="${address}">
                </td>
                <td width="15%" class="title">创建时间</td>
                <td width="35%">
                    <input id="time" name="time" class="easyui-datetimebox" style="width:300px;" value="${time}">
                </td>
            </tr>
            <tr>
                <td colspan="4" style="text-align: center;">
                    <input type="submit" value="查询"/>
                    <input type="button" value="重置"/>
                    <input id="btn-Add" type="button" value="新增菜单"/>
                    <input id="btn-del" type="button" value="删除菜单"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<div class="easyui-panel">
    <div title="查询结果" style="padding: 5px;overflow:auto">
        <table id="tt" class="easyui-treegrid"
               data-options="url:'<%=path%>/admin/menu/manlist',idField:'id',treeField:'name'">
            <thead>
            <tr>
                <th data-options="field:'name'" width="40%">菜单名称</th>
                <th data-options="field:'type'" width="20%">类型</th>
                <th data-options="field:'time'" width="10%">创建时间</th>
                <th data-options="field:'address'" width="30%">菜单地址</th>
            </tr>
            </thead>
        </table>
    </div>
</div>
<script src="<%=path%>/resource/easyui/jquery.min.js"></script>
<script src="<%=path%>/resource/easyui/jquery.easyui.min.js"></script>
<script src="<%=path%>/resource/easyui/locale/easyui-lang-zh_CN.js"></script>
<script src="<%=path%>/scripts/easyui-setting.js"></script>
<script src="<%=path%>/scripts/App.js"></script>
<script type="text/javascript">

    function closeDialog(){
        $("#dialog").dialog('close');
    }

    $(function(){



        //新增
        $("#btn-Add").click(function(){
            if($("#tt").treegrid('getSelections').length != 0){
                var type = $("#tt").treegrid('getSelections')[0].type;
                var pid = $("#tt").treegrid('getSelections')[0].id;
                if(type == 'branch' || type == 'root'){
                    $("#dialog").dialog({
                        title: '新增菜单',
                        width: 600,
                        height: 400,
                        closable: false,
                        closed: false,
                        cache: false,
                        href: APP_URL + '/admin/menu/add?pid=' + pid,
                        modal: true
                    });
                    return;
                }
            }
            $.messager.alert('Warning', "请选择相应的分支在做添加!");
        });
    });
</script>
</body>
</html>