<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>模型列表</title>
    <jsp:include page="/adminScript.jsp"/>
    <script type="text/javascript">
        function closeDialog(){
            $("#dd").dialog({closed: true});
        }
        function deploy(){

        }
        $(function() {
            $("#list").datagrid({
                title: '流程信息',
                pagination: true,
                rownumbers:true,
                columns: [[
                    {field: 'id', title: 'id', width: '5%'},
                    {field: 'key', title: '模型key', width: '15%'},
                    {field: 'name', title: '模型名称', width: '15%'},
                    {field: 'category', title: '模型分类', width: '15%'},
                    {field: 'createTime', title: '创建时间', width: '15%'},
                    {field: 'deploymentId', title: '部署ID', width: '10%'},
                    {field: 'version', title: '版本号', width: '5%'},
                    {field: '',title:'操作',width:'15%',formatter:function(value,row,index){
                        return "<button onclick=parent.addTabs('编辑','<%=path%>/workflow/modeler.html?modelId="+row.id+"','流程编辑','_blank')>编辑</button>" +
                                "<button onclick='deploy('"+row.id+"')>部署</button>";
                        }
                    }
                ]]
            });
            var pager = $("#list").datagrid("getPager");
            pager.pagination({
                total:${count},
                pageSize:App.page,
                onSelectPage: function (pageNo, pageSize) {
                    $.getJSON('<%=path%>/activiti-model/list/' + pageNo + "/" + pageSize,function(data){
                        $("#list").datagrid("loadData",data);
                    })
                }
            });
            pager.pagination('select',1);
        });

        function addModel(){
            $("#dd").dialog({
                title: '新增用户',
                width: 600,
                height: 400,
                closable: false,
                closed: false,
                cache: false,
                href: '<%=path%>/activiti-model/add',
                modal: true
            });
        }
        function addSave(){
            $.ajax({
                type:"post",
                url:"<%=path%>/activiti-model/create",
                cache:false,
                data:$("#add_model_form").serialize(),
                dataType:"json",
                success:function(data){
                    $.messager.alert(data.result,data.msg,"info",function(){
                        window.location.reload();
                    });
                }
            });
        }
    </script>
</head>
<body>
<div id="dd"></div>
<div id="query"  class="easyui-panel query" title="用户管理" >
    <table class="gridtable" >
        <tr>
            <td width="15%">
                用户编码
            </td>
            <td width="35%">
                <input type="text" name="usercode" class="form-control">
            </td>
            <td width="15%">
                用户名称
            </td>
            <td width="35%">
                <input type="text" name="username" class="form-control">
            </td>
        </tr>
        <tr>
            <td colspan="4">
                <button type="button" class="btn btn-primary btn-xs">查询</button>
                <button type="button" class="btn btn-primary btn-xs">重置</button>
                <button type="button" class="btn btn-primary btn-xs" onclick="addModel()">新增</button>
            </td>
        </tr>
    </table>
</div>
<div id="list"></div>
</body>
</html>