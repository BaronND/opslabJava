<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<script type="text/javascript">
    <!--利用json的方式创建一个全局的应用信息的JS对象-->
    var App = {
        schema:"<%=path%>",
        user:"${sessionScope.user}",
        page:"${sessionScope.pageSize}"
    };
</script>
