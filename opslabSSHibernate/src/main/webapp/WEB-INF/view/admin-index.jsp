<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>opslabJ2ee</title>
    <!--导入通用的样式文件和javascript文件-->
    <link rel="stylesheet" type="text/css" href="${contextPath}/resource/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resource/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resource/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/style/admin/admin-index.css"/>
    <script type="text/javascript" src="${contextPath}/resource/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${contextPath}/resource/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${contextPath}/resource/ztree/js/jquery.ztree.all.min.js"></script>
    <script type="text/javascript">
        function onClieckItem(event, treeId, treeName) {
            if (treeName.address) {
                addTabs(treeName.name, "${contextPath}/" + treeName.address);
            }
        }
        var setting = {
            data: {
                simpleData: {
                    enable: true
                }
            },
            callback: {
                onClick: onClieckItem
            }
        };
        function openModelWindow() {
            $("#w").window('open');
        }
        /**
         * 提示信息
         * @param msg
         * @param timeout
         */
        function message(msg, timeout) {
            var time = arguments[1] ? arguments[1] : 5000;
            $.messager.show({
                title: '提示信息',
                msg: msg,
                timeout: time,
                showType: 'show'
            });
        }
        /**
         * 添加tab页面
         * @param title
         * @param url
         */
        function addTabs(title, url) {
            if ($('#tt').tabs('exists', title)) {
                $('#tt').tabs('select', title);
            } else {
                var content = '<iframe scrolling="auto" frameborder="0" src=" ' + url + '" style="width:100%;height:99%;"></ifrmae>';
                $('#tt').tabs('add', {
                    title: title,
                    content: content,
                    fit: true,
                    closable: true,
                    onLoad: function () {
                        $("#status").text('onload:' + url);
                    },
                    tools: [{
                        iconCls: 'icon-mini-refresh',
                        handler: function () {
                            var tabs = $('#tt').tabs('getSelected');
                            if (tabs.find('iframe').length > 0) {
                                tabs.find('iframe')[0].contentWindow.location.reload(true);
                            }
                        }
                    }, {
                        iconCls: 'icon-mini-add',
                        handler: function () {
                            var tabs = $('#tt').tabs('getSelected');
                            window.open(tabs.find('iframe')[0].contentWindow.location.href);
                        }
                    }, {
                        iconCls: 'icon-mini-edit',
                        handler: function () {
                            var tabs = $('#tt').tabs('getSelected');
                            window.open('view-source:' + tabs.find('iframe')[0].contentWindow.location.href);
                        }
                    }]
                });
            }
        }
        /**
         * console输出一些js的调试信息
         * @param str
         */
        function log(str) {
            $("status").text(str);
            if (window.console.log(str));
        }
        /**
         * 加在菜单栏
         * @param title
         */
        $(function () {
            $.getJSON("${contextPath}/admin/menu/list", function (data) {
                $.fn.zTree.init($("#menulist"), setting, data);
                //全部展开
                var treeObj = $.fn.zTree.getZTreeObj("menulist");
                treeObj.expandAll(true);
            });
        });

    </script>
</head>
<body class="easyui-layout">
<div class="north" data-options="region:'north',border:false">
    <div>
        <div>
        </div>
    </div>
    <div class="panel-header panel-header-noborder top-toolbar">
        <div id="infobar">当前用户:sysadmin 用户组:超级管理员</div>
        <div id="buttonbar">
            <a href="#" class="easyui-linkbutton" data-options="plain:true">清楚缓存</a>
            <a href="#" class="easyui-linkbutton" data-options="plain:true">全屏模式</a>
            <a href="#" class="easyui-linkbutton" data-options="plain:true">退出系统</a>
        </div>
    </div>
</div>
<div class="west" data-options="region:'west',title:'系统管理'">
    <div style="padding:0px;">
        <ul id="menulist" class="ztree"></ul>
    </div>
</div>
<div class="east" data-options="region:'east',split:false,collapsed:true,title:'信息'">
    <div class="easyui-calendar" style="height:150px;"></div>
</div>
<div class="south" data-options="region:'south',border:false">
    <div id="status"></div>
</div>
<div class="center" data-options="region:'center',noheader:true">
    <div id="tt" class="easyui-tabs" data-options='fit:true,border:false'>
        <div title="About">

        </div>
    </div>
    <div id="w" class="modelWindow easyui-window" title="Modal Window"
         data-options="modal:true,closed:true,closable:false,collapsible:false,minimizable:false,maximizable:false,resizable:false">
        <div class="easyui-layout" data-options="fit:true">
            <div data-options="border:false" style="padding:5px 0 0;">
                prompt content
            </div>
            <div class="dialog-button">
                <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)"
                   onclick="alert('ok');$('#w').window('close');" style="width:80px">Ok</a>
                <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)"
                   onclick="alert('cancel')" style="width:80px">Cancel</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
