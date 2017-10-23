/**
 * 业务系统通用的js组件
 */
/**
 * 返回一个iframe
 * @param url
 * @returns {string}
 */
function iframe(url) {
    return '<iframe scrolling="auto" frameborder="0" src=" ' + url + '" style="width:100%;height:99%;"></ifrmae>';
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
 * 弹出部门单选选择的对话框，并将选择的结果返回
 */
function selectDept(callbak) {
    $("body").append("<div id=\"business-selectDept\"></div>");
    $("body").append("<div id=\"business-selectDept-result\">" +
        "<input type=\"hidden\" id='opslab-deptid' name=\"opslab-deptid\">" +
        "<input type='hidden' id='opslab-deptname' name=\"opslab-deptname\">" +
        "</div>");
    $("#business-selectDept").dialog({
        title: '部门信息',
        width: 400,
        height: 600,
        closable: false,
        closed: false,
        cache: false,
        href: appurl("selectdept"),
        modal: true,
        onClose: function () {
            var deptId = $("#opslab-deptid").val();
            var deptname = $("#opslab-deptname").val();
            callbak(deptId, deptname);
        }
    });
}
/**
 * 弹出部门多选的对话框，并将选择的结果返回
 */
function selectDepts() {

}

/**
 * 使用自定义的函数将数组转换为字符串
 * @param arr
 * @param func
 * @returns {*}
 */
function arrayToString(arr, func) {
    var ids = "";
    if (!arr) {
        return ids;
    }
    for (var i = 0; i < arr.length; i++) {
        var v = func(arr[i]);
        ids += v + ",";
    }
    if (ids.length > 0) {
        return ids.substr(0, ids.length - 1);
    }
    return "";
}

