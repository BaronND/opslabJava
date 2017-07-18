<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>编码管理</title>
    <jsp:include page="/ScriptEasyUI.jsp"/>
    <link rel="stylesheet" type="text/css" href="${contextPath}/style/admin/deptlist.css">
    <script type="text/javascript">
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
        /**
         * 获取当前选择中的部门ID
         */
        function getCurrentNode() {
            var treeObj = $.fn.zTree.getZTreeObj("codelist");
            try {
                var nodes = treeObj.getCheckedNodes(true);
                if (nodes) return nodes[0].id;
            } catch (e) {
            }
        }


        function addCodeType() {
            var codeType = getCurrentNode();
            if(!codeType){
                codeType="SYS_CODE";
            }
            var url = '${contextPath}/admin/code/addtype/' + codeType;

            $("#dd").dialog({
                title: '新增',
                width: 600,
                height: 400,
                closable: false,
                closed: false,
                cache: false,
                href: url,
                modal: true
            });
        }
        function addSave(){
            $.ajax({
                type: "post",
                url: "${contextPath}/admin/code/save",
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

        function onClickCodeItem(event, treeId, treeName) {
            var treeObj = $.fn.zTree.getZTreeObj("codelist");
            treeObj.checkNode(treeName, true, false);
            var url = appurl("admin/code/info/" + treeName.id);
            $("#codeInfo").html(iframe(url));
        }

        function codeList() {
            $.getJSON("${contextPath}/admin/code/codelist", function (data) {
                $.fn.zTree.init($("#codelist"), setting, data);
                //全部展开
                var treeObj = $.fn.zTree.getZTreeObj("codelist");
                treeObj.expandAll(true);
            });
        }

        $(function () {
            codeList();
        });
    </script>
</head>
<body class="easyui-layout">
<div id="dd"></div>
<div class="west" data-options="region:'west',title:'编码类型'">
    <div id="toolsbar">
        <button class="easyui-linkbutton" width="100px" onClick="addCodeType()">新增编码分类</button>
    </div>
    <ul id="codelist" class="ztree"></ul>
</div>
<div id="codeInfo" class="center" data-options="region:'center',title:'编码信息'">
</div>
</body>
</html>