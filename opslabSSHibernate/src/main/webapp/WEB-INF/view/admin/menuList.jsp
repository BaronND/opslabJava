<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>菜单管理</title>
    <jsp:include page="/ScriptEasyUI.jsp"/>
    <link rel="stylesheet" type="text/css" href="${contextPath}/style/admin/manage-layout.css">
    <script type="text/javascript">
        /*左侧部门树相关的操作*/
        function onClieckDeptItem(event, treeId, treeName) {
            var treeObj = $.fn.zTree.getZTreeObj("menulist");
            treeObj.checkNode(treeName, true, false);
            var url = appurl('admin/menu/info/' + treeName.id);
            $("#deptInfo").html(iframe(url));
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
            var treeObj = $.fn.zTree.getZTreeObj("menulist");
            try {
                var nodes = treeObj.getCheckedNodes(true);
                if (nodes) return nodes[0].id;
            } catch (e) {
            }
            return "";
        }
        /**
         * 刷新左侧的部门列表树
         */
        function refreshDeptTree() {
            initList();
            var treeObj = $.fn.zTree.getZTreeObj("menulist");
            treeObj.expandAll(true);
        }
        /**
         * 新增菜单
         */
        function addMenu(){
            var currentNodeId = getCurrentNode();
            $("#dd").dialog({
                title: '新增菜单',
                width: 600,
                height: 400,
                closable: false,
                closed: false,
                cache: false,
                href: '${contextPath}/admin/menu/add?pid=' + currentNodeId,
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
                    $.getJSON("${contextPath}/admin/dept/del.do", data, function (data) {
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
            var data = decodeURIComponent($("#add_menu_form").serialize());
            $.getJSON("${contextPath}/admin/menu/save", data, function (data) {
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

        //页面加载完毕后执行一些页面初始化的操作
        /**
         * 初始化左侧的部门列表树
         */
        function initList() {
            $.getJSON(appurl("/admin/menu/list"), function (data) {
                $.fn.zTree.init($("#menulist"), setting, data);
                //全部展开
                var treeObj = $.fn.zTree.getZTreeObj("menulist");
                treeObj.expandAll(true);
            });

        }
        $(function () {
            initList();
        });
    </script>
</head>
<body class="easyui-layout">
<div id="dd"></div>
<div class="west" data-options="region:'west',title:'组织机构'">
    <div id="buttons" class="btn-group" role="group">
        <a href="#" class="easyui-linkbutton"  width="100px" onclick="addMenu()">新增菜单</a>
    </div>
    <ul id="menulist" class="ztree"></ul>
</div>
<div id="deptInfo" class="center" data-options="region:'center',title:'部门信息'">
</div>
</body>
</html>