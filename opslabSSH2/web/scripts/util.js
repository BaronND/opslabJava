/////////////////////////////////////////
// import jQuery easyui
/////////////////////////////////////////

/*
 * @function 主窗口的消息框
 */
function message(msg,timeout){
	var i =self;
	while(top != i){
		i= i.parent.window;
	}
	i.Windowmessage(msg,timeout);
}
/*
 * @function 主窗口的tabs刷新
 */
function tabsReresh(){
	var i = self;
	while(top != i){
		i = i.parent.window;
	}
	i.tabsReresh();
}


