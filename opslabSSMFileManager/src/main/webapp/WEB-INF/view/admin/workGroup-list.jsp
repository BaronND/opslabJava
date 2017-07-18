<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>工作组管理</title>
    <jsp:include page="/ScriptEasyUI.jsp"/>
    <link rel="stylesheet" type="text/css" href="${contextPath}/style/admin/workgroup.css">
    <script type="text/javascript">

        function onClieckDeptItem(event, treeId, treeName) {
            var treeObj = $.fn.zTree.getZTreeObj("workgrouplist");
            treeObj.checkNode(treeName, true, false);
            var url=appurl("admin/workgroup/info/" + treeName.id);
            $("#wrokgroupInfo").html(iframe(url));

        }
        var setting = {
            data: {
                simpleData: {
                    enable: true
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
        /**
         * 获取当前选择中的部门ID
         */
        function getCurrentNode() {
            var treeObj = $.fn.zTree.getZTreeObj("deptlist");
            try {
                var nodes = treeObj.getCheckedNodes(true);
                if (nodes) return nodes[0].id;
            } catch (e) {
            }
        }
        /**
         * 刷新左侧的部门列表树
         */
        function refreshDeptTree() {
            initList();
            var treeObj = $.fn.zTree.getZTreeObj("deptlist");
            treeObj.expandAll(true);
        }
        /**
         * 新增加部门
         */
        function addNewDept() {
            var currentNodeId = getCurrentNode();
            if (!currentNodeId) {
                $.messager.alert('Warning', '请选择一个部门');
                return;
            }
            $("#dd").dialog({
                title: '新增下级部门',
                width: 600,
                height: 400,
                closable: false,
                closed: false,
                cache: false,
                href: appurl('/admin/dept/add.do?parentId=' + currentNodeId),
                modal: true
            });
        }
        /**
         * 删除当前选定的部门
         */
        function deleteDept() {
            var currentNodeId = getCurrentNode();
            if (!currentNodeId) {
                $.messager.alert('Warning', '请选择一个部门');
                return;
            }
            $.messager.confirm('Confirm', '确定要删除当前部门?', function (r) {
                if (r) {
                    var data = {
                        deptId: currentNodeId
                    }
                    $.getJSON(appurl("admin/dept/del"), data, function (data) {
                        if ("error" == data.result) {
                            $.messager.alert('error', data.msg);
                            return;
                        }
                    });
                    refreshDeptTree();
                }
            });

        }
        /**
         * 修改部门信息
         */
        function editDept() {
            var currentNodeId = getCurrentNode();
            if (!currentNodeId) {
                $.messager.alert('Warning', '请选择一个部门');
                return;
            }
        }
        /**
         * 新增部门
         * 提交数据到后台并刷新部门树
         */
        function addSave() {
            var data = decodeURIComponent($("#add_dept_form").serialize(), true);
            $.getJSON(appurl("admin/dept/save"), data, function (data) {
                if ("error" == data.result) {
                    $.messager.alert('error', data.msg);
                    return;
                }
            });
            closeDialog();
            refreshDeptTree();
        }
        /**
         * 关闭dialog对话框
         */
        function closeDialog() {
            $("#dd").dialog({closed: true});
        }

        $(function () {
            //初始化左侧的部门列表树
            $.getJSON(appurl("admin/workgroup/list"), function (data) {
                $.fn.zTree.init($("#workgrouplist"), setting, data);
                //全部展开
                var treeObj = $.fn.zTree.getZTreeObj("workgrouplist");
                treeObj.expandAll(true);
            });
        });
    </script>
</head>
<body class="easyui-layout">
<div id="dd"></div>
<div class="west" data-options="region:'west',title:'工作组管理'">
    <div id="buttons" class="btn-group" role="group">
        <button class="easyui-linkbutton"  width="100px"  onClick="addNewDept()">新增下级部门</button>
    </div>
    <ul id="workgrouplist" class="ztree"></ul>
</div>
<div id="wrokgroupInfo" class="center" data-options="region:'center',noheader:true">

</div>
</body>
</html>