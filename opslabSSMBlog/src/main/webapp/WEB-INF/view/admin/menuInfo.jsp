<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>菜单信息</title>
    <jsp:include page="/ScriptEasyUI.jsp"/>
</head>
<body>
<table class="gridtable" style="width: 100%;">
    <tr>
        <td width="15%" class="title">菜单类型</td>
        <td width="85%">${menu.type}</td>
    </tr>
    <tr>
        <td width="15%" class="title">父级菜单</td>
        <td width="85%">${menu.pId}</td>
    </tr>
    <tr>
        <td class="title">菜单名称</td>
        <td>${menu.name}</td>
    </tr>
    <tr>
        <td class="title">请求地址</td>
        <td>${menu.address}</td>
    </tr>
    <tr>
        <td class="title">是否有效</td>
        <td>${menu.valid}</td>
    </tr>
    <tr>
        <td class="title">描述信息</td>
        <td>${menu.desc}</td>
    </tr>
    <tr>
        <td colspan="2" style="text-align: center">
            <c:choose>
                <c:when test="${1 == menu.valid}">
                    <button class="easyui-linkbutton"
                            onclick="easyui_do('${contextPath}/admin/menu/delete/${menu.id}')">
                        停用</button>
                </c:when>
                <c:when test="${0 == menu.valid}">
                    <button class="easyui-linkbutton"
                            onclick="easyui_do('${contextPath}/admin/menu/activate/${menu.id}')">
                        启用</button>
                </c:when>
            </c:choose>
        </td>
    </tr>
</table>
</body>
</html>
