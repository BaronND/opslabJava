/*BlogAdd.jsp‘s Script*/

var testEditor;

$(function() {
    testEditor = editormd("test-editormd", {
        width   : "100%",
        height  : 400,
        syncScrolling : "single",
        path    : "../resoure/editor/lib/"
    });

    /*
     // or
     testEditor = editormd({
     id      : "test-editormd",
     width   : "90%",
     height  : 640,
     path    : "../lib/"
     });
     */

    $("#submit").click(function(){
        var postdata = {
            "title":escape($("#title").val()),
            "label":escape($("#label").val()),
            "content":escape($("textarea").val())
        };

        $.ajax({
            url:'blogSave.action',
            type:'post',
            dataType:'json',
            data:postdata,
            success:function(result){
                alert(result);
            }
        });
    });
});