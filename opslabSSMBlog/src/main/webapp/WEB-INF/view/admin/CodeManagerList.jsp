<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>编码管理</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/resource/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/resource/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/resource/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/style/admin/common.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/style/admin/deptlist.css">
</head>
<body  class="easyui-layout">
<div class="west" data-options="region:'west'">
    <ul id="codelist" class="ztree"></ul>
</div>
<div id="codeInfo" class="center" data-options="region:'center'">
    <table class="gridtable">
        <tr>
            <td width="15%" class="title">业务主键</td>
            <td width="35%">
                {{code.keyId}}
            </td>
            <td width="15%" class="title">编码类型值</td>
            <td width="35%" id="info-id">
                {{code.id}}
            </td>
        </tr>
        <tr>
            <td class="title">编码名称</td>
            <td>
                {{code.name}}
            </td>
            <td class="title">创建时间</td>
            <td>
                {{code.createTime}}
            </td>
        </tr>
        <tr>
            <td class="title">编码类型</td>
            <td>
                {{code.codeType}}
            </td>
            <td class="title">是否有效</td>
            <td v-if="code.valid">
                是
            </td>
            <td v-if="code.valid ==0">
                否
            </td>
        </tr>
        <tr>
            <td class="title">编码描述</td>
            <td colspan="3">
                {{code.memo}}
            </td>
        </tr>
        <tr>
            <td colspan="4" style="text-align: center">
                <!--
                <button v-if="code.valid" onclick="disable()">停用编码</button>
                <button v-if="code.valid ==0" onclick="activate()">启用编码</button>
                -->
                <button onclick="addCodeType()">新增分类</button>
                <button onclick="addCode()">新增编码</button>
            </td>
        </tr>
    </table>
    <div id="tt" class="easyui-tabs" data-options='fit:true,border:false'>
        <div title="编码值">
            <table id="codeinfo-list" class="easyui-datagrid">

            </table>

        </div>
    </div>
</div>
<div id="addCodeTypeDialog" class="easyui-dialog" title="添加分类" style="width:400px;height:300px;"
     data-options="modal:true,closed:true">
    <form id="addCodeTypeForm" action="<%=path%>/amdin/menu/add.do">
        <table class="gridtable" style="width: 100%;">
            <tr>
                <td class="title">编码分类</td>
                <td>
                    <input id="addCodeType-parentId" name="parentId" type="hidden">
                    <input id="addCodeType-name" class="easyui-textbox" name="name" type="text" style="width:300px;">
                </td>
            </tr>
            <tr>
                <td class="title">编码名称</td>
                <td>
                    <input id="addCodeType-codeName"  class="easyui-textbox" name="codeName" type="text" style="width:300px;">
                </td>
            </tr>
            <tr>
                <td class="title">编码类型</td>
                <td>
                    <input id="addCodeType-codeType" class="easyui-textbox" name="codeType" type="text" style="width:300px;">
                </td>
            </tr>
            <tr>
                <td class="title">编码说明</td>
                <td>
                    <input id="addCodeType-memo" class="easyui-textbox" name="memo" type="text" style="width:300px;">
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center;">
                    <input type="button" onclick="submitCodeType()" value="提交"/>
                    <input class="btn-close" type="button" value="取消"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<div id="addCodeDialog" class="easyui-dialog" title="添加编码值" style="width:500px;height:400px;"
     data-options="modal:true,closed:true">
    <form id="addCodeForm" action="<%=path%>/amdin/menu/add.do">
        <table class="gridtable" style="width: 100%;">
            <tr>
                <td class="title">编码分类</td>
                <td>
                    <input id="addCode-parentId"  name="parentId" type="hidden" >
                    <input id="addCode-name" class="easyui-textbox input-text" name="name" type="text" >
                </td>
            </tr>
            <tr>
                <td class="title">编码值</td>
                <td>
                    <input id="addCode-codeId" class="easyui-textbox input-text" name="codeId" type="text">
                </td>
            </tr>
            <tr>
                <td class="title">编码名称</td>
                <td>
                    <input id="addCode-codeName" class="easyui-textbox input-text" name="codeName" type="text">
                </td>
            </tr>
            <tr>
                <td class="title">编码排序</td>
                <td>
                    <input id="addCode-orderId" class="easyui-textbox input-text" name="orderId" type="text">
                </td>
            </tr>
            <tr>
                <td class="title">编码说明</td>
                <td>
                    <input id="addCode-memo" class="easyui-textbox input-text" name="memo" type="text">
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center;">
                    <input id="btn-AddCode" type="button" onclick="submitCode()" value="提交"/>
                    <input class="btn-close" type="button" value="取消"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<script src="<%=path%>/resource/easyui/jquery.min.js"></script>
<script src="<%=path%>/resource/easyui/jquery.easyui.min.js"></script>
<script src="<%=path%>/resource/easyui/locale/easyui-lang-zh_CN.js"></script>
<script src="<%=path%>/scripts/easyui-setting.js"></script>
<script src="<%=path%>/resource/ztree/js/jquery.ztree.all.min.js"></script>
<script src="<%=path%>/resource/vue.min.js"></script>
<script src="<%=path%>/scripts/App.js"></script>
<script src="<%=path%>/scripts/business-util.js"></script>
<script>
    var setting = {
        data: {
            simpleData: {
                enable: true
            }
        },
        callback: {
            onClick: onClickCodeItem,
            onCheck: onClickCodeItem
        },
        check: {
            enable: true,
            chkStyle: "radio",
            radioType: "all"
        }
    };

    function fixWidth(percent) {
        return document.getElementById("codeInfo").clientWidth * percent;
    }


    /**
     * 新增编码分类
     */
    function addCodeType() {
        console.log("新增编码分类:" + JSON.stringify(AppCodeInfo.code));
        if ("BRANCH" == AppCodeInfo.code.treeType) {
            $("#addCodeType-parentId").val(AppCodeInfo.code.id);
            $("#addCodeType-name").textbox('setValue',AppCodeInfo.code.name);
            $("#addCodeTypeDialog").dialog('open');
        } else {
            $.messager.alert("Warning", "请选择相应的分类在做添加");
        }
    }

    /**
     * 校验并异步提交新增编码分类
     */
    function submitCodeType(){
        var parentId =$("#addCodeType-parentId").val();
        var name =$("#addCodeType-codeName").textbox('getValue');
        if(!name){
            $.messager.alert("Warning", "编码名称不能为空！");
            return;
        }
        var codeType= $("#addCodeType-codeType").textbox('getValue');
        if(!codeType){
            $.messager.alert("Warning", "编码类型不能为空！");
            return;
        }

        var memo = $("#addCodeType-memo").textbox('getValue');
        if(!memo){
            $.messager.alert("Warning", "编码说明不能为空！");
            return;
        }
        var data = {"parentId":parentId,"name":name,"codeType":codeType,"memo":memo};
        easyui_post("<%=path%>/admin/code/typeadd.do", data, function (data) {
            $.messager.alert(data.result, data.msg, "info", function () {
                window.location.reload();
            });
        });
    }
    /**
     * 新增编码值
     */
    function addCode() {
        var ztree = $.fn.zTree.getZTreeObj("codelist");
        var node = ztree.getNodeByParam('keyId', AppCodeInfo.code.keyId);
        if(node && !node.isParent){
            $("#addCode-parentId").val(AppCodeInfo.code.id);
            $("#addCode-name").textbox('setValue',AppCodeInfo.code.name);
            $("#addCodeDialog").dialog('open');
        }else{
            $.messager.alert("Warning", "请选择相应的分类在做添加");
        }
    }
    /**
     * 校验并异步提交新增编码分类
     */
    function submitCode(){
        var parentId =$("#addCode-parentId").val();
        var codeId= $("#addCode-codeId").textbox('getValue');
        if(!codeId){
            $.messager.alert("Warning", "编码值不能为空！");
            return;
        }
        var name =$("#addCode-codeName").textbox('getValue');
        if(!name){
            $.messager.alert("Warning", "编码名称不能为空！");
            return;
        }
        var orderId= $("#addCode-orderId").textbox('getValue');
        if(!orderId){
            $.messager.alert("Warning", "请输入编码排序");
            return;
        }
        var memo = $("#addCode-memo").textbox('getValue');
        if(!memo){
            $.messager.alert("Warning", "编码说明不能为空！");
            return;
        }
        var data = {"parentId":parentId,"name":name,"codeId":codeId,"orderId":orderId,"memo":memo};
        easyui_post("<%=path%>/admin/code/codeadd.do", data, function (data) {
            $.messager.alert(data.result, data.msg, "info", function () {
                window.location.reload();
            });
        });
    }

    function closeDialog() {
        $("#dd").dialog({closed: true});
    }
    /**
     * 启用编码
     * @param key
     */
    function activate() {
        console.log("启用编码:" + JSON.stringify(AppCodeInfo.code));
        var url = "<%=path%>/admin/code/delete/" + id;
        easyui_get(url, "", function (data) {
            $.messager.alert(data.result, data.msg, "info", function () {
                window.location.reload();
            });
        });
    }

    /**
     * 停用编码
     * @param key
     */
    function disable() {
        console.log("停用编码:" + JSON.stringify(AppCodeInfo.code));
        $.messager.confirm('停用', '你确定停用“' + AppCodeInfo.code.name + '”？', function (r) {
            if (r) {
                var deleteUrl = "<%=path%>/admin/code/delete.do?key=" + AppCodeInfo.code.keyId;
                easyui_get(deleteUrl, "", function (data) {
                    $.messager.alert(data.result, data.msg, "info", function () {
                        window.location.reload();
                    });
                });
            }
        });

    }

    function onClickCodeItem(event, treeId, treeName) {
        console.log("点击tree"+event+ treeId + ":" + treeName.keyId + "=" + treeName.name);
        $.fn.zTree.getZTreeObj("codelist").checkNode(treeName, true, false);
        $.ajax({
            type: "post",
            url: "<%=path%>/admin/code/typeinfo.do?type=" + treeName.id,
            async: true,
            dataType: "json",
            success: function (data) {
                try{
                    AppCodeInfo.code = data.code;
                    codeInfoListTab(data.code.id, data.count);
                }catch (e){}
            }
        });
    }

    function codeInfoListTab(codeType, count) {
        console.log("加载编码值tab:" + codeType);
        $("#codeinfo-list").datagrid({
            url: "<%=path%>/admin/code/typecodelist.do?type=" + codeType,
            columns: [[
                {field: 'ck', checkbox: true},
                {field: 'id', title: '编码ID', width: fixWidth(0.15)},
                {field: 'name', title: '编码名称', width: fixWidth(0.1)},
                {field: 'createTime', title: '创建时间', width: fixWidth(0.1)},
                {field: 'orderId', title: '排序', width: fixWidth(0.1)},
                {field: 'valid', title: '是否有效', width: fixWidth(0.1)},
                {field: 'memo', title: '描述', width: fixWidth(0.4)}
            ]],
            rownumbers: true,
            checkOnSelect: true,
            selectOnCheck: true
        });
//        <div id="codepage" class="easyui-pagination tablepagination"></div>
//        $("#codepage").pagination({
//            total: count,
//            pageList: [10, 15, 20, 25],
//            onSelectPage: selectPage
//        });
    }




    function addSave() {
        var url = "<%=path%>/admin/code/save";
        var data = appdata("#add_code_form");
        easyui_post(url, data, function (data) {
            $.messager.alert(data.result, data.msg, "info", function () {
                window.location.reload();
            });
        });
    }





    function deleteItems() {
        var items = $("#codeinfo-list").datagrid('getChecked');
        var ids = arrayToString(items, function (d) {
            return d.keyId;
        });
        if (ids) {
            var url = "<%=path%>/admin/code/delete.do";
            easyui_get(url, "", function (data) {
                $.messager.alert(data.result, data.msg, "info", function () {
                    window.location.reload();
                });
            });
        } else {
            $.messager.alert("提示", "请选择相应的记录", "info");
        }
    }
    // 创建app实例
    var AppCodeInfo = new Vue({
        el: '#codeInfo',
        data: {
            code: {},
            count: 0,
        },
        computed: {
            infourl: function () {
                return "<%=path%>/admin/code/map/" + this.code.codeType;
            }
        }
    });

    $(function () {
        // 初始化左侧编码列表
        $.getJSON("<%=path%>/admin/code/typelist.do", function (data) {
            if(data.result == "success"){
                $.fn.zTree.init($("#codelist"), setting, data.data);
                var ztree = $.fn.zTree.getZTreeObj("codelist");
                var node = ztree.getNodeByParam('keyId', 1000);
                if (node) {
                    ztree.checkNode(node, true, true);
                }
                ztree.expandAll(true);
            }else{
                $.messager.alert("ERROR","加载编码列表错误");
            }

        });

        //加载默认的codeInfo
        $.ajax({
            type: "post",
            url: "<%=path%>/admin/code/typeinfo.do?type=ROOT",
            async: true,
            dataType: "json",
            success: function (data) {
                AppCodeInfo.code = data.code;
                codeInfoListTab(data.code.keyId, data.count);
            }
        });


        $(".btn-close").click(function () {
            $(".easyui-dialog").dialog('close');
        });
    });


</script>
</body>
</html>