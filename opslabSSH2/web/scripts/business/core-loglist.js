function doSearch(value, name) {
    alert('You input: ' + value + '(' + name + ')');
}

function onClickLogRow(rowIndex, rowData) {
    var html = "<table>" +
        "<tr><td>操作人</td><td>"+rowData.userNmae+"</td></tr>" +
        "<tr><td>IP地址</td><td>"+rowData.address+"</td></tr>" +
        "<tr><td>开始时间</td><td>"+rowData.startTime+"</td></tr>" +
        "<tr><td>日志类型</td><td>"+rowData.type+"</td></tr>" +
        "<tr><td>操作名称</td><td>"+rowData.operationName+"</td></tr>" +
        "<tr><td>操作参数</td><td>"+rowData.operationParam+"</td></tr>" +
        "<tr><td>URL地址</td><td>"+rowData.uri+"</td></tr>" +
        "<tr><td>操作结果</td><td>"+rowData.result+"</td></tr>" +
        "</table>";
    $("#row").html(html).dialog({closed: false});

}
$(function () {
    $('#pp').pagination({
        onSelectPage: function (pageNumber, pageSize) {
            $('#dd').datagrid('load', {'page': pageNumber, 'size': pageSize});
        }
    });
});