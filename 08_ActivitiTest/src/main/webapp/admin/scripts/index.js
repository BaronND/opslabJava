function openModelWindow() {
    $("#w").window('open');
}
/**
 * 提示信息
 * @param msg
 * @param timeout
 */
function message(msg,timeout){
    var time = arguments[1]?arguments[1]:5000;
    $.messager.show({
        title:'提示信息',
        msg:msg,
        timeout:time,
        showType:'show'
    });
}
/**
 * 添加tab页面
 * @param title
 * @param url
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
            },
            tools: [{
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
 * console输出一些js的调试信息
 * @param str
 */
function log(str){
    $("status").text(str);
    if(window.console.log(str));
}
/**
 * 加在菜单栏
 * @param title
 */
function menuLoad(title){
    var url = title+"_json.json";
    $.getJSON(url,function(response,status){
        if("success" == status){
            var name= response.name;
            var type= response.type;
            if("tree" == type){

            }else{
                var text ="";
                for(var i=0;i<response.content.length;i++){
                    var temp = response.content[i];
                    text +='<a href="javascript:void(0);" onClick="addTabs(\''+temp.title+"','"
                        +temp.url+"');>"+temp.title+"</a><br>";
                    $("#menu-list").append(text);
                }
            }
        }else{
            log("加在菜单失败:"+status);
        }
    });
}





