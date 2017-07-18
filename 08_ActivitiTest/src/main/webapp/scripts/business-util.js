/**
 * 业务系统通用的js组件
 */
/**
 * 因为纯JS种无法获取到JavaWeb根路径所以采取如下方式配置获取
 * @type {string}
 */
var BASEPATH="/";
function url(uri){
    return BASEPATH+uri;
}

/**
 * 弹出部门单选选择的对话框，并将选择的结果返回
 *
 */

function selectDept(callbak){
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
        href: url("selectDept"),
        modal: true,
        onClose:function(){
            var deptId = $("#opslab-deptid").val();
            var deptname = $("#opslab-deptname").val();
            callbak(deptId,deptname);
        }
    });
}
/**
 * 弹出部门多选的对话框，并将选择的结果返回
 */
function selectDepts(){

}