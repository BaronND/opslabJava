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
<body class="easyui-layout">
<div id="dialog"></div>
<div class="west" data-options="region:'west'">
    <ul id="codelist" class="ztree"></ul>
</div>
<div id="codeInfo" class="center" data-options="region:'center'">
    <table class="gridtable">
        <tr>
            <td width="15%" class="title">业务主键</td>
            <td width="35%">
                {{code.key}}
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
                <button v-if="code.valid" onclick="disable()">停用编码</button>
                <button v-if="code.valid ==0" onclick="activate()">启用编码</button>
                <button onclick="addCodeType()">新增编码分类</button>
                <button onclick="addCode()">新增编码值</button>
            </td>
        </tr>
    </table>
    <div id="tt" class="easyui-tabs" data-options='fit:true,border:false'>
        <div title="编码值">
            <table id="codeinfo-list" class="easyui-datagrid">

            </table>
            <div id="codepage" class="easyui-pagination tablepagination"></div>
        </div>
    </div>
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

    function fixWidth(percent){
        return document.getElementById("codeInfo").clientWidth * percent;
    }


    /**
     * 新增编码分类
     */
    function addCodeType() {
        console.log("启用编码:" + JSON.stringify(AppCodeInfo.code));
        $("#dd").dialog({
            title: '新增',
            width: 600,
            height: 400,
            closable: false,
            closed: false,
            cache: false,
            href: '<%=path%>/admin/code/addtype/' + AppCodeInfo.code.codeType,
            modal: true
        });
    }
    function addCode() {
        $.ajax({
            type: "post",
            url: "<%=path%>/admin/code/save",
            cache: false,
            data: appdata($("#add_code_form")),
            dataType: "json",
            success: function (data) {
                $.messager.alert(data.result, data.msg, "info", function () {
                    window.location.reload();
                });
            }
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
        $.messager.confirm('停用','你确定停用“'+AppCodeInfo.code.name+'”？',function(r){
           if(r){
               var data = {"key":AppCodeInfo.code.key};
               easyui_get("<%=path%>/admin/code/delete.do",data , function (data) {
                   $.messager.alert(data.result, data.msg, "info", function () {
                       window.location.reload();
                   });
               });
           }
        });

    }

    function onClickCodeItem(event, treeId, treeName) {
        console.log("点击tree"+treeId+":"+treeName.id+"="+treeName.name);
        $.fn.zTree.getZTreeObj("codelist").checkNode(treeName, true, false);
        $.ajax({
            type: "post",
            url: "<%=path%>/admin/code/typeinfo.do?type=" + treeName.id,
            async: true,
            dataType: "json",
            success: function (data) {
                AppCodeInfo.code = data.code;
                codeInfoListTab(data.code.id,data.count);
            }
        });
    }

    function codeInfoListTab(codeType,count){
        console.log("加载编码值tab:"+codeType);
        $("#codeinfo-list").datagrid({
            url:"<%=path%>/admin/code/typelist.do?type="+codeType,
            columns:[[
                {field:'ck',checkbox:true},
                {field:'id',title:'编码ID',width:fixWidth(0.1)},
                {field:'name',title:'编码名称',width:fixWidth(0.1)},
                {field:'createTime',title:'创建时间',width:fixWidth(0.1)},
                {field:'orderId',title:'排序',width:fixWidth(0.1)},
                {field:'valid',title:'是否有效',width:fixWidth(0.1)},
                {field:'memo',title:'描述',width:fixWidth(0.45)}
            ]],
            rownumbers:true,
            checkOnSelect:true,
            selectOnCheck:true
        });
        $("#codepage").pagination({
            total:count,
            pageList: [10,15,20,25],
            onSelectPage:selectPage
        });
    }

    function selectPage(pageNo, pageSize) {
        $.getJSON('<%=path%>/admin/code/list/${codeType}',
                {page: pageNo, rows: pageSize},
                function (data) {
                    $('#codelist').datagrid('loadData', data);
                });
    }
    function closeDialog() {
        $("#dialog").dialog({closed: true});
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


    function addCode() {
        $("#dialog").dialog({
            title: '新增',
            width: 600,
            height: 400,
            closable: false,
            closed: false,
            cache: false,
            href: '<%=path%>/admin/code/add/${codeType}',
            modal: true
        });
    }




    function deleteItems(){
        var items = $("#codeinfo-list").datagrid('getChecked');
        var ids = arrayToString(items,function(d){return d.key;});
        if(ids){
            var url = "<%=path%>/admin/code/delete.do";
            easyui_get(url, "", function (data) {
                $.messager.alert(data.result, data.msg, "info", function () {
                    window.location.reload();
                });
            });
        }else{
            $.messager.alert("提示", "请选择相应的记录", "info");
        }
    }
    // 创建app实例
    var AppCodeInfo = new Vue({
        el: '#codeInfo',
        data: {
            code: {},
            count:0,
        },
        computed: {
            infourl: function () {
                return "<%=path%>/admin/code/map/" + this.code.codeType;
            }
        }
    });

    $(function () {
        // 初始化左侧编码列表
        $.getJSON("<%=path%>/admin/code/codelist.do", function (data) {
            $.fn.zTree.init($("#codelist"), setting, data);
            var ztree = $.fn.zTree.getZTreeObj("codelist");
            var node = ztree.getNodeByParam('key',1000);
            if(node){
                ztree.checkNode(node,true,true);
            }
            ztree.expandAll(true);
        });

        //加载默认的codeInfo
        $.ajax({
            type: "post",
            url: "<%=path%>/admin/code/typeinfo.do?type=ROOT" ,
            async: true,
            dataType: "json",
            success: function (data) {
                AppCodeInfo.code = data.code;
                codeInfoListTab(data.code.id,data.count);
            }
        });
    });



</script>
</body>
</html>