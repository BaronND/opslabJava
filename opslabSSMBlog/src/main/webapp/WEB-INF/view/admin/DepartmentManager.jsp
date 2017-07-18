<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>部门管理</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/resource/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/resource/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/resource/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/style/admin/common.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/style/admin/deptlist.css">
</head>
<body class="easyui-layout">
<div class="west" data-options="region:'west',title:'组织机构'">
    <ul id="deptlist" class="ztree"></ul>
</div>
<div id="deptInfo" class="center" data-options="region:'center',title:'部门信息'">
    <table class="gridtable">
        <tr>
            <td width="15%" class="title">
                部门ID
            </td>
            <td width="35%">
                {{dept.deptId}}
            </td>
            <td width="15%" class="title">
                部门名称
            </td>
            <td width="35%">
                {{dept.name}}
            </td>
        </tr>
        <tr>
            <td width="15%" class="title">
                上级部门
            </td>
            <td width="35%">
                {{dept.parentId}}
            </td>
            <td width="15%" class="title">
                部门状态
            </td>
            <td width="35%">
                {{dept.status}}
            </td>
        </tr>
        <tr>
            <td width="15%" class="title">
                备注信息
            </td>
            <td colspan="3" width="85%">
                {{dept.memo}}
            </td>
        </tr>
        <tr>
            <td colspan="4" style="align-content: center; text-align: center;">
                <button type="button" class="btn btn-default" onClick="addNewDept()">新级部门</button>
                <button type="button" class="btn btn-default">修改部门</button>
                <button type="button" class="btn btn-default" onClick="deleteDept()">删除部门</button>
            </td>
        </tr>
    </table>
    <div id="tt" class="easyui-tabs" data-options='fit:true,border:false'>
        <div title="用户列表">
            <table id="userlist" class="easyui-datagrid" data-options="rownumbers:true">
                <thead>
                <tr>
                    <th data-options="field:'userId'" width="10%">用户ID</th>
                    <th data-options="field:'userCode'" width="10%">用户编码</th>
                    <th data-options="field:'name'" width="15%">用户名称</th>
                    <th data-options="field:'email'" width="15%">邮箱地址</th>
                    <th data-options="field:'deptId'" width="20%">用户部门</th>
                    <th data-options="field:'status'" width="5%">用户状态</th>
                    <th data-options="field:'createTime'" width="15%">创建时间</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>
<div id="addDeptDialog" class="easyui-dialog" title="新增部门" style="width:500px;height:400px;"
     data-options="modal:true,closed:true">
    <form id="addDeptForm">
        <table class="gridtable" style="width: 100%;">
            <tr>
                <td class="title">上级部门</td>
                <td style="text-align: center">
                    <input id="addDept-parentId"  name="parentId" type="hidden" >
                    <input id="addDept-Pname" class="easyui-textbox input-text" name="pname" type="text" >
                </td>
            </tr>
            <tr>
                <td class="title">部门名称</td>
                <td style="text-align: center">
                    <input id="addDept-name" class="easyui-textbox input-text" name="name" type="text">
                </td>
            </tr>
            <tr>
                <td class="title">附件信息</td>
                <td style="text-align: center">
                    <input id="addCode-memo" class="easyui-textbox input-text" name="memo" type="text">
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center;">
                    <input id="btn-AddCode" type="button" onclick="submitDept()" value="提交"/>
                    <input class="btn-close" type="button"  onclick="closeDialog()" value="取消"/>
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
<script type="text/javascript">
    var setting = {
        data: {
            simpleData: {
                enable: true,
                idKey: 'deptId',
                pIdKey: 'parentId'
            }
        },
        callback: {
            onClick: onClieckDeptItem,
            onCheck: onClieckDeptItem
        },
        check: {
            enable: true,
            chkStyle: "radio",
            radioType: "all"
        }
    };
    /*左侧部门树相关的操作*/
    function onClieckDeptItem(event, treeId, treeName) {
        var treeObj = $.fn.zTree.getZTreeObj("deptlist");
        treeObj.checkNode(treeName, true, false);
        loadDeptInfo(treeName.deptId);
    }

    /**
     * 关闭dialog
     */
    function closeDialog(){
        $("#addDeptDialog").dialog('close');
    }
    /**
     * 新增加部门
     */
    function addNewDept() {
        console.log("新增部门");
        $("#addDept-parentId").val(AppDeptInfo.dept.deptId);
        $("#addDept-Pname").textbox('setValue',AppDeptInfo.dept.name);
        $("#addDeptDialog").dialog('open');
    }

    /**
     * 新增部门
     */
    function submitDept(){
        var parentId = $("#addDept-parentId").val();
        if(!parentId){
            $.messager.alert("Warning", "上级编码错误！");
            return;
        }
        var name= $("#addDept-name").textbox('getValue');
        if(!name){
            $.messager.alert("Warning", "部门名称不能为空");
            return;
        }
        var memo= $("#addCode-memo").textbox('getValue');
        if(!memo){
            $.messager.alert("Warning", "备注信息不能为空");
            return;
        }
        var data = {"parentId":parentId,"name":name,"memo":memo};
        easyui_post("<%=path%>/admin/dept/add.do", data, function (data) {
            $.messager.alert(data.result, data.msg, "info", function () {
                window.location.reload();
            });
        });
    }
    /**
     * 删除当前选定的部门
     */
    function deleteDept() {
        console.log("删除部门");
    }
    /**
     * 修改部门信息
     */
    function editDept() {
        console.log("修改部门");
    }
    /**
     * 新增部门
     * 提交数据到后台并刷新部门树
     */
    function addSave() {
        $.getJSON("<%=path%>/admin/dept/save.do", data, function (data) {
            if ("error" == data.result) {
                $.messager.alert('error', data.msg);
                return;
            }
        });
    }


    /**
     * 加载部门信息
     */
    function loadDeptInfo(deptId) {
        console.log("加载部门信息:" + deptId);
        $.getJSON("<%=path%>/admin/dept/info.do?deptId=" + deptId, function (data) {
            if (data.result == "success") {
                AppDeptInfo.dept = data.data.dept;
                AppDeptInfo.userCount = data.data.userCount;
                loadDeptUserListTab(AppDeptInfo.userCount);
            } else {
                $.messager.alert("Error", "加载部门信息异常");
            }
        });
    }

    /**
     *  加载部门员工信息
     */
    function loadDeptUserListTab(count){
        console.log("加载部门员工信息:"+AppDeptInfo.dept.deptId);
        easyui_post("<%=path%>/admin/dept/userlist.do",{"deptId":AppDeptInfo.dept.deptId},function(data){
            $("#userlist").datagrid({data:data});
        });
    }
    // 创建app实例
    var AppDeptInfo = new Vue({
        el: '#deptInfo',
        data: {
            dept: {},
            userCount: 0
        }
    });

    $(function () {

        /**
         * 初始化左侧的部门列表树
         */
        $.getJSON("<%=path%>/admin/dept/list.do", function (data) {
            if (data.result == "success") {
                $.fn.zTree.init($("#deptlist"), setting, data.data);
                var ztree = $.fn.zTree.getZTreeObj("deptlist");
                var node = ztree.getNodeByParam('deptId', 100001);
                if (node) {
                    ztree.checkNode(node, true, true);
                }
                ztree.expandAll(true);
            } else {
                $.messager.alert("Error", "获取部门列表信息异常");
            }
        });
        //加载默认的部门信息
        loadDeptInfo(100001);

    });
</script>
</body>
</html>