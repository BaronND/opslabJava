function blist(){
    $.getJSON("bloglist.action",function(json){
        if(json){
            alert(json['list'].length);
        }
    });
}

$(function(){
    alert(111);
   blist();
});