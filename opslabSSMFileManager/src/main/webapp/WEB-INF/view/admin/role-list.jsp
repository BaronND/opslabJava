<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>用户角色管理</title>
  <jsp:include page="/ScriptEasyUI.jsp"/>
  <link rel="stylesheet" type="text/css" href="${contextPath}/style/admin/deptlist.css">
  <script type="text/javascript">
    /*左侧部门树相关的操作*/
    function onClieckDeptItem(event, treeId, tree) {
      var treeObj = $.fn.zTree.getZTreeObj("rolelist");
      treeObj.checkNode(tree, true, false);
      var url = appurl('/admin/role/info/'+tree.id);
      $("#contentPanel").html(iframe(url));
    }
    var setting = {
      data: {
        simpleData: {
          enable: true
        }
      },
      callback: {
        onClick: onClieckDeptItem,
        onCheck: onClieckDeptItem
      },
      check: {
        enable: true,
        chkStyle: "radio",
        radioType: "all"
      }
    };
    /**
     * 获取当前选择中的部门ID
     */
    function getCurrentNode() {
      var treeObj = $.fn.zTree.getZTreeObj("deptlist");
      try {
        var nodes = treeObj.getCheckedNodes(true);
        if (nodes) return nodes[0].id;
      } catch (e) {}
    }
    /**
     * 刷新左侧的部门列表树
     */
    function refreshDeptTree(){
      initList();
      var treeObj = $.fn.zTree.getZTreeObj("deptlist");
      treeObj.expandAll(true);
    }
    /**
     * 新增加部门
     */
    function addNewDept() {
      var currentNodeId = getCurrentNode();
      if (!currentNodeId) {
        $.messager.alert('Warning', '请选择一个部门');
        return;
      }
      $("#dd").dialog({
        title: '新增下级部门',
        width: 600,
        height: 400,
        closable: false,
        closed: false,
        cache: false,
        href: '${contextPath}/admin/dept/add.do?parentId=' + currentNodeId,
        modal: true
      });
    }
    /**
     * 删除当前选定的部门
     */
    function deleteDept(){
      var currentNodeId = getCurrentNode();
      if (!currentNodeId) {
        $.messager.alert('Warning', '请选择一个部门');
        return;
      }
      $.messager.confirm('Confirm','确定要删除当前部门?',function(r){
        if (r){
          var data ={
            deptId:currentNodeId
          }
          $.getJSON("${contextPath}/admin/dept/del.do",data,function(data){
            if("error"== data.result){
              $.messager.alert('error', data.msg);
              return;
            }
          });
          refreshDeptTree();
        }
      });

    }
    /**
     * 修改部门信息
     */
    function editDept() {
      var currentNodeId = getCurrentNode();
      if (!currentNodeId) {
        $.messager.alert('Warning', '请选择一个部门');
        return;
      }
    }
    /**
     * 新增部门
     * 提交数据到后台并刷新部门树
     */
    function addSave() {
      var data = decodeURIComponent($("#add_dept_form").serialize(),true);
      $.getJSON("${contextPath}/admin/dept/save.do",data,function(data){
        if("error"== data.result){
          $.messager.alert('error', data.msg);
          return;
        }
      });
      closeDialog();
      refreshDeptTree();
    }
    /**
     * 关闭dialog对话框
     */
    function closeDialog() {
      $("#dd").dialog({closed: true});
    }

    //页面加载完毕后执行一些页面初始化的操作
    /**
     * 初始化左侧的部门列表树
     */
    function initList() {
      $.getJSON("${contextPath}/admin/role/list", function (data) {
        $.fn.zTree.init($("#rolelist"), setting, data);
        //全部展开
        var treeObj = $.fn.zTree.getZTreeObj("rolelist");
        treeObj.expandAll(true);
      });

    }
    $(function () {
      initList();
    });
  </script>
</head>
<body class="easyui-layout">
<div id="dd"></div>
<div class="west" data-options="region:'west',title:'角色管理'">
  <div id="buttons" class="btn-group-xs" role="group">
  <button type="button" class="btn btn-default" onClick="addNewDept()">新增下级角色</button>
  <button type="button" class="btn btn-default" onClick="deleteDept()">删除当前部门</button>
</div>
  <div style="margin-left:10px">
    <input  type="checkbox" value="1" name="isAll"/>
    <lable for="isAll">显示已经删除的角色</lable>
  </div>
  <ul id="rolelist" class="ztree"></ul>
</div>
<div id="contentPanel" class="center" data-options="region:'center',title:'角色信息'">
</div>
</body>
</html>