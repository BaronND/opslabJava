function doSearch(value, name) {
	alert('You input: ' + value + '(' + name + ')');
}
$(function(){
	$('#pp').pagination({
		onSelectPage:function(pageNumber,pageSize){
			$('#dd').datagrid('load',{'page':pageNumber,'size':pageSize});
		}
	});
});