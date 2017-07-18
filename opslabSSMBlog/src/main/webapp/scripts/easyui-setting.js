//设置easyui的全局时间格式
$.fn.datebox.defaults.formatter = function (date) {
    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    var d = date.getDate();
    return y + '-' + (m < 10 ? ('0' + m) : m) + '-' + (d < 10 ? ('0' + d) : d);
};
$.fn.datebox.defaults.parser = function (s) {
    if (!s) return new Date();
    var ss = s.split('-');
    var y = parseInt(ss[0], 10);
    var m = parseInt(ss[1], 10);
    var d = parseInt(ss[2], 10);
    if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {
        return new Date(y, m - 1, d);
    } else {
        return new Date();
    }
};

//一些通用的函数
/*
 * 通用的提示框函数
 */


function easyui_get(url, json, func) {
    $.ajax({
        type: "get",
        url: url,
        cache: false,
        data: json,
        dataType: "json",
        success: func,
        error:function(XMLHttpRequest, textStatus, errorThrown){
            $.messager.alert("请求异常", "异常信息:"+textStatus, "error", function () {
                window.location.reload();
            });
        }
    });
}

function easyui_post(url, json, func) {
    $.ajax({
        type: "post",
        url: url,
        cache: false,
        data: json,
        dataType: "json",
        success: func,
        error:function(XMLHttpRequest, textStatus, errorThrown){
            $.messager.alert("请求异常", "异常信息:"+textStatus, "error", function () {
                window.location.reload();
            });
        }

    });
}

/**
 * 简单的请求操作，并返回请求操作是否成功
 */
function easyui_do(url, json) {
    easyui_get(url, json, function (data) {
        $.messager.alert(data.result, data.msg, "info", function () {
            window.location.reload();
        });
    });
}