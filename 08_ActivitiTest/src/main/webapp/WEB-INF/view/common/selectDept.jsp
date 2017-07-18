<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<script type="text/javascript">
    /*左侧部门树相关的操作*/
    function onClieckDeptItem(event, treeId, treeName) {
        var treeObj = $.fn.zTree.getZTreeObj("deptlist");
        treeObj.checkNode(treeName, true, false);
        //初始化部门信息
        $('#table').datagrid({
            url: '<%=path%>/admin/dept/info?id=' + treeName.id,
            columns: [[
                {field: 'id', title: 'id', width: '20%'},
                {field: 'deptId', title: '部门编码', width: '20%'},
                {field: 'detpName', title: '部门名称', width: '20%'},
                {field: 'valid', title: '部门状态', width: '20%'},
                {field: 'parentId', title: '上级部门', width: '20%'}
            ]]
        });
        //初始化部门人员信息
        $("#userlist").datagrid({
            url: '<%=path%>/admin/dept/userlist.do?deptId=' + treeName.id,
            title: '部门人员',
            columns: [[
                {field: 'id', title: 'id', width: '20%'},
                {field: 'userCode', title: '用户编码', width: '15%'},
                {field: 'userName', title: '用户名称', width: '20%'},
                {field: 'deptId', title: '所在部门', width: '15%'},
                {field: 'valid', title: '用户状态', width: '10%'},
                {field: 'createTime', title: '创建时间', width: '20%'},
            ]]
        });
    }
    var setting = {
        data: {
            simpleData: {
                enable: true
            }
        },
        check: {
            enable: true,
            chkStyle: "radio",
            radioType: "all"
        }
    };
    /**
     * 获取选中的部门并返回
     */
    function returnDept() {
        var tree = $.fn.zTree.getZTreeObj("deptlist");
        var node = tree.getCheckedNodes(true);
        if(node.length > 0){
            $("#opslab-deptid").val(node[0].id);
            $("#opslab-deptname").val(node[0].name);
            $("#business-selectDept").dialog('close');
            return;
        }
        $.messager.alert("错误提示","请选择一个部门");
    }
    /**
     * 初始化左侧的部门列表树
     */
    function initList() {
        $.getJSON("<%=path%>/admin/dept/json.do", function (data) {
            $.fn.zTree.init($("#deptlist"), setting, data);
            //全部展开
            var treeObj = $.fn.zTree.getZTreeObj("deptlist");
            treeObj.expandAll(true);
        });
    }
    $(function () {
        initList();
    });
</script>
<%--
    注意该页面的写法，该页面不是一个标准的html结构
    页面中不能出现body标签，如果出现body标签那么在
    利用easyui加载该页面的时候该页面的js会不执行,
    因此会出现一些无法预期的错误！
    根据浏览器的特性不写body标签页面单独打开的时候
    也可以正常显示！
--%>
<div class="deptlist-tree" data-options="title:'组织机构'">
    <ul id="deptlist" class="ztree"></ul>
</div>
<div style="text-align: center">
    <button type="button" class="btn btn-primary btn-xs" onclick="returnDept()">确定</button>
</div>
