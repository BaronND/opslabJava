<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table class="gridtable" style="width: 100%;">
    <tr>
        <td width="20%" class="title">开始时间</td>
        <td width="80%" style="word-wrap:break-word;word-break:break-all;">
            ${log.startTime}
        </td>
    </tr>
    <tr>
        <td class="title">结束时间</td>
        <td style="word-wrap:break-word;word-break:break-all;">
            ${log.endTime}
        </td>
    </tr>
    <tr>
        <td class="title">操作名称</td>
        <td style="word-wrap:break-word;word-break:break-all;">
            ${log.businessName}
        </td>
    </tr>
    <tr>
        <td class="title">业务层实现类</td>
        <td style="word-wrap:break-word;word-break:break-all;">
            ${log.operationName}
        </td>
    </tr>
    <tr>
        <td class="title">操作人</td>
        <td style="word-wrap:break-word;word-break:break-all;">
            ${log.userName}
        </td>
    </tr>
    <tr>
        <td class="title">操作结果</td>
        <td style="word-wrap:break-word;word-break:break-all;">
            ${log.result}
        </td>
    </tr>
    <tr>
        <td class="title">客户端地址</td>
        <td style="word-wrap:break-word;word-break:break-all;">
            ${log.ip}
        </td>
    </tr>
    <tr>
        <td class="title">操作类型</td>
        <td style="word-wrap:break-word;word-break:break-all;">
            ${log.type}
        </td>
    </tr>
    <tr>
        <td class="title">附加信息</td>
        <td style="word-wrap:break-word;word-break:break-all;">
            ${log.msg}
        </td>
    </tr>
</table>