<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Arrays" %>
<%--利用Spring MVC做统一的异常处理--%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>请求异常</title>
    <jsp:include page="/ScriptBootstrap.jsp"/>
</head>
<body>
<div class="container">
    <div class="panel panel-danger">
        <div class="panel-heading">
            <h4 class="panel-title">请求异常</h4>
        </div>
        <div class="panel-body">
            <h5>请求地址:${uri}</h5>
            <p>请求时间:${date}</p>
            <p>请求结果:${result}</p>
            <p>异常信息:${msg}</p>
            <p>堆栈信息:</p>
            <pre>
                ${startTrace}
            </pre>
        </div>
        <table class="table">
            <thead>
            <tr>
                <td width="10%">序号</td>
                <td width="30%">参数名称</td>
                <td width="60%">参数值</td>
            </tr>
            </thead>
            <%
                Map<String,Object> requestParameter = (Map<String, Object>) request.getAttribute("requestParameter");
                if(requestParameter != null && requestParameter.size() > 0){
                    int i = 0;
                    for (Map.Entry<String, Object> entry : requestParameter.entrySet()) {
                        i++;
                        String parameter = entry.getKey();
                        Object value = entry.getValue();
                        if(value.getClass().isArray()){
                            value = Arrays.toString((Object[]) value);
                        }
            %>
            <tr>
                <td><%=i%></td>
                <td><%=parameter%></td>
                <td><%=value%></td>
            </tr>
            <%
                    }
                }
            %>

        </table>
    </div>
</div>
</body>
</html>
