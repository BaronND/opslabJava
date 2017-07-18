<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();

%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Spring-mvc</title>
    <jsp:include page="/adminScript.jsp"/>
    <script type="text/javascript">
        $(function() {
            $("#list").datagrid({
                title: '流程信息',
                pagination: true,
                rownumbers:true,
                columns: [[
                    {field: 'id', title: 'id', width: '15%'},
                    {field: 'deploymentId', title: '流程部署ID', width: '15%'},
                    {field: 'key', title: '流程key', width: '20%'},
                    {field: 'name', title: '流程名称', width: '15%'},
                    {field: 'version', title: '流程版本', width: '10%'},
                    {field: 'suspensionState', title: '流程状态', width: '20%'},
                ]]
            });
            var pager = $("#list").datagrid("getPager");
            pager.pagination({
                total:${count},
                pageSize:App.page,
                onSelectPage: function (pageNo, pageSize) {
                    $.getJSON('<%=path%>/workflow/processlist/' + pageNo + "/" + pageSize,function(data){
                        $("#list").datagrid("loadData",data);
                    })
                }
            });
            pager.pagination('select',1);
        });
    </script>
</head>
<body>
<div id="dd"></div>
<div id="page"></div>
<div id="list"></div>
</body>
</html>