<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户管理</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/resource/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/resource/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/resource/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/style/admin/common.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/style/admin/deptlist.css">
</head>
<body>
<div id="dd"></div>
<div id="query" class="easyui-panel query" title="用户管理">
    <form id="queryfrom" action="<%=path%>/admin/user.do" method="post">
        <table class="gridtable">
            <tr>
                <td width="15%" class="title">
                    用户ID
                </td>
                <td width="35%">
                    <input type="text" id="userId" name="userId" value="${userId}" class="easyui-textbox" style="width:300px;">
                </td>
                <td width="15%" class="title">
                    用户code
                </td>
                <td width="35%">
                    <input type="text" id="userCode" name="userCode" value="${userCode}" class="easyui-textbox" style="width:300px;" >
                </td>
            </tr>
            <tr>
                <td width="15%" class="title">
                    用户名称
                </td>
                <td width="35%">
                    <input type="text" id="name" name="name" value="${name}" class="easyui-textbox" style="width:300px;">
                </td>
                <td width="15%" class="title">
                    用户部门
                </td>
                <td width="35%">
                    <select id="deptId" class="easyui-combotree" name="deptId" style="width: 300px" value="${deptId}"
                            data-options="url:'<%=path%>/admin/dept/list-child.do'"></select>
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <button type="submit" class="btn btn-primary btn-xs">查询</button>
                    <button type="reset" class="btn btn-primary btn-xs">重置</button>
                    <button type="button" class="btn btn-primary btn-xs" onclick="addUser()">新增</button>
                </td>
            </tr>
        </table>
    </form>
</div>
<table id="userlist" class="easyui-datagrid" title="用户列表" data-options="rownumbers:true">
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
<div id="userpage" class="easyui-pagination tablepagination" data-options="
      total:${count},
      pageSize:${pageSize},
      pageList: [10,15,20,25],
      onSelectPage:onUserPageSelect"></div>
</div>
<script src="<%=path%>/resource/easyui/jquery.min.js"></script>
<script src="<%=path%>/resource/easyui/jquery.easyui.min.js"></script>
<script src="<%=path%>/resource/easyui/locale/easyui-lang-zh_CN.js"></script>
<script src="<%=path%>/scripts/easyui-setting.js"></script>
<script src="<%=path%>/resource/ztree/js/jquery.ztree.all.min.js"></script>
<script src="<%=path%>/scripts/App.js"></script>
<script type="text/javascript">
    /**
     * 新增user
     */
    function addUser() {
        $("#dd").dialog({
            title: '新增用户',
            width: 600,
            height: 400,
            closable: false,
            closed: false,
            cache: false,
            href: '<%=path%>/admin/user/add.do',
            modal: true
        });
    }
    /**
     * 获取表单有效数据,删除json数据中的值为空的属性
     * @param jsondata
     */
    function appdata(form, data) {
        var loginForm = $(form).serializeArray();
        var loginFormObject = {};
        $.each(loginForm,
                function (i, v) {
                    if (v.value) {
                        loginFormObject[v.name] = v.value;
                    }
                });
        for (var t in data) {
            if (data[t]) {
                loginFormObject[t] = data[t];
            }
        }
        return loginFormObject;
    }
    /**
     * 添加用户
     */
    function addSave() {
        $.ajax({
            type: "post",
            url: "<%=path%>/admin/user/save.do",
            cache: false,
            data: $("#add_user_form").serialize(),
            dataType: "json",
            success: function (data) {
                $.messager.alert(data.result, data.msg, "info", function () {
                    window.location.reload();
                });
            }
        });
    }
    /**
     * 关闭新增窗口
     */
    function closeDialog() {
        $("#dd").dialog({closed: true});
    }

    /**
     * 获取查询表达的数据
     * easyui通过特定的方法获取表单的值，因此不能使用像formdata这边编辑的方法了，因此比较蛋疼
     */
    function getQueryFormData(){
        var userId = $("#userId").textbox('getValue');
        var userCode =$("#userCode").textbox('getValue');
        var name = $("#name").textbox('getValue');
        var deptId = $("#deptId").combotree('getValue');
        return {"userId":userId,"userCode":userCode,"name":name,"deptId":deptId}
    }

    function onUserPageSelect(pageNo, pageSize) {
        var formData = getQueryFormData();
        formData['page', pageNo];
        formData['rows', pageSize];
        $.ajax({
            type: "post",
            url: "<%=path%>/admin/user/list.do",
            cache: false,
            data: formData,
            success: function (data) {
                $('#userlist').datagrid('loadData', data);
            }
        });
    }
    $(function () {
            $("#deptId").combotree('setValue',"${deptId}");
        $("#userpage").pagination('select',1);
    });
</script>
</body>
</html>