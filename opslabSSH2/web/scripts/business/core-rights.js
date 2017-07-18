var core_rights = function(){};
core_rights.prototype ={
		//新增页面表单提交
		form_submit:function(){
			$('#ff').form('submit', {
				url : 'rights_add.action',
				onSubmit : function() {
					// do some check   
					// return false to prevent submit;   
				},
				success : function(data) {
					message(data);
				}
			});
		},
		//新增页面表单数据校验
		form_Valid:function(){
			$("#ff").form()
		},
		//展现页面新增权限按钮响应事件
		list_add:function(){
		    $("#win1").window({closed:false}).window('open');
		    $.parser.parse('#ff');
		},
		//修改
		list_load:function(){
			//获取当前页面选择的记录的ID
			var row =$('#dd').datagrid('getChecked');
			$("#win1").window({closed:false}).window('open');
			$.parser.parse('#ff');
			$('#ff').form('load',row);
		},
		//分页组件事件函数
		page_load:function(page,size){
			$('#dd').datagrid('load',{'page':page,'size':size});
		}

};

$(function(){
	//折叠所有的treegrid节点
	$('#dd').treegrid('collapseAll');
	
	var rights = new core_rights(); 
	
	//为响应的按钮绑定事件函数
	$('#list-add').bind('click',rights.list_add);
	$('#list-edit').bind('click',rights.list_load);
	$('#form-add').bind('click',rights.form_submit);

});


