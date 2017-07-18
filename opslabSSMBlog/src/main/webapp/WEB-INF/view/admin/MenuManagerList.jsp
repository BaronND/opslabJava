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
               data-options="url:'<%=path%>/admin/menu/manlist.do',idField:'id',treeField:'name'">
            <thead>
            <tr>
                <th data-options="field:'name'" width="35%">菜单名称</th>
                <th data-options="field:'type'" width="20%">类型</th>
                <th data-options="field:'valid'" width="5%">是否有效</th>
                <th data-options="field:'time'" width="10%">创建时间</th>
                <th data-options="field:'address'" width="30%">菜单地址</th>
            </tr>
            </thead>
        </table>
    </div>
</div>
<div id="dialog" class="easyui-dialog" title="添加菜单" style="width:400px;height:300px;" data-options="modal:true,closed:true">
    <form id="addmenu" action="<%=path%>/amdin/menu/add.do">
        <input type="hidden" name="pId" id="Add-pId">
        <table class="gridtable" style="width: 100%;">
            <tr>
                <td class="title">菜单名称</td>
                <td>
                    <input  id="Add-name" class="easyui-textbox" name="name"  type="text" style="width:300px;">
                </td>
            </tr>
            <tr>
                <td class="title">菜单类型</td>
                <td>
                    <select id="Add-type" class="easyui-combobox" name="type" style="width:300px;">
                        <option value="LEAF">菜单链接</option>
                        <option value="BRANCH">菜单分类</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td class="title">菜单链接</td>
                <td>
                    <input  id="Add-address" class="easyui-textbox" name="address"  type="text" style="width:300px;">
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center;">
                    <input id="btn-AddCode" type="button" value="提交"/>
                    <input id="btn-close" type="button" value="取消"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<script src="<%=path%>/resource/easyui/jquery.min.js"></script>
<script src="<%=path%>/resource/easyui/jquery.easyui.min.js"></script>
<script src="<%=path%>/resource/easyui/locale/easyui-lang-zh_CN.js"></script>
<script src="<%=path%>/scripts/easyui-setting.js"></script>
<script src="<%=path%>/scripts/App.js"></script>
<script type="text/javascript">



    $(function(){
        //取消
        $("#btn-close").click(function(){
            $("#dialog").dialog('close');
        });

        //新增菜单
        $("#btn-AddCode").click(function(){
            var pId = $("#Add-pId").val();
            if(!pId){
                $.messager.alert('Warning', "pId错误!");
                return;
            }
            var name = $("#Add-name").val();
            if(!name){
                $.messager.alert('Warning', "name不能为空");
                return;
            }
            var type = $("#Add-type").val();
            var address = $("#Add-address").val();
            if(type =='BRANCH' ){
                if(address){
                    $.messager.alert('Warning', "菜单分类不能携带地址");
                    return;
                }
            }
            if(type == 'LEAF'){
                if(!address){
                    $.messager.alert('Warning', "菜单地址不能为空");
                    return;
                }
            }
            var formData = {"pId":pId,"name":name,"type":type,"address":address};
            easyui_get('<%=path%>/admin/menu/save.do',formData,function(data){
                if(data.result == "success"){
                    $.messager.alert('success','操作成功!');
                }else{
                    $.messager.alert('Warning',data.msg);
                }
            });
        });

        //新增
        $("#btn-Add").click(function(){
            if($("#tt").treegrid('getSelections').length != 0){
                var select = $("#tt").treegrid('getSelections')[0];
                if(select.type == 'BRANCH'){
                    $("#Add-pId").val(select.id);
                    $("#dialog").dialog('open');
                }
            }else{
                $.messager.alert('Warning', "请选择相应的分支再添加!");
            }
        });

        //删除菜单
        $("#btn-del").click(function(){
            if($("#tt").treegrid('getSelections').length > 0){
                var select = $("#tt").treegrid('getSelections')[0];
                if(select.type == 'LEAF' || (select.type='BRANCH' && select.children.length == 0) ){
                    $.messager.confirm('确认','确认删除该项?',function(r){
                       if(r){
                           easyui_get('<%=path%>/admin/menu/delete.do',{"id":select.id},function(data){
                              if(data.result == "success"){
                                  $.messager.alert('success','操作成功!');
                              }else{
                                  $.messager.alert('Warning',data.msg);
                              }
                           });
                       }
                    });
                }else{
                    $.messager.alert('Warning', "存在子菜单，无法删除!");
                }
            }else{
                $.messager.alert('Warning', "请选择需要停用的菜单!");
            }
        });
    });
</script>
</body>
</html>