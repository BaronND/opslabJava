function openModelWindow() {
	$("#w").window('open');
}

/**
 * @function 创建一个tabs页面
 * @param title#tabs标签页的标题
 * @param url#tabs页面包含内的url.(利用iframe实现远程加载)
 */
function addTabs(title, url) {
	if ($('#tt').tabs('exists', title)) {
		$('#tt').tabs('select', title);
	} else {
		var content = '<iframe scrolling="auto" frameborder="0" src=" ' + url+ '" style="width:100%;height:99%;"></ifrmae>';
		$('#tt').tabs('add', {
			title : title,
			content : content,
			fit : true,
			closable : true,
			onLoad : function() {
				$("#status").text('onload:' + url);
			},tools: [{   
					iconCls:'icon-mini-refresh',   
					handler:function(){
						var tabs =$('#tt').tabs('getSelected');
						if(tabs.find('iframe').length > 0){
							tabs.find('iframe')[0].contentWindow.location.reload(true);
						}
					}
				},{
					iconCls:'icon-mini-add',
					handler:function(){
						var tabs =$('#tt').tabs('getSelected');
						window.open(tabs.find('iframe')[0].contentWindow.location.href);
					}
				},{
					iconCls:'icon-mini-edit',
					handler:function(){
						var tabs =$('#tt').tabs('getSelected');
						window.open('view-source:'+tabs.find('iframe')[0].contentWindow.location.href);
					}
				}] 

		});
	}
}

/**
 * @function 刷性主窗口被选择的tabs
 */
function tabsReresh(){
	var tabs = $("#tt").tabs('getSelected');
	if(tabs.find('iframe').length > 0){
		tabs.find('iframe')[0].contentWindow.location.reload(true);
	}
}

/**
 * @function 主页面的消息框
 */
function Windowmessage(msg,timeout){
	//设置显示事件默认为5秒
	var time = arguments[1]?arguments[1]:5000;
	$.messager.show({
		title:'消息提示',
		msg:msg,
		timeout:time,
		showType:'show'
	});
}
/**
 * 页面加载完后执行
 */
$(function(){
	message("Load compleating...",1000);
	//加载手风琴菜单
	$.getJSON("rights_listroot.action",{},function(response,status){
		if("success" == status){
			for(var i=0;i < response.length;i++){
				$("#accordion-demo").accordion('add', {
					title:response[i].text,
					content:'<ul id="'+response[i].id+'"></ul>',
					iconCls:'icon-ok',
					selected: false
				});
				$('#'+response[i].id).tree({
					url:'rights_listtype.action?id='+response[i].rid,
					id:'href',
					onClick:function(n){
						addTabs(n.text,n.attributes.href);
					},
				});
			}
		}else{
			message("加载菜单错误...",0);
		}
	});
});

