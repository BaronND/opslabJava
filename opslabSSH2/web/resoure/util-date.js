///////////////////////////////////////////////
//
//@function:通过原型对时间类进行扩充
//
///////////////////////////////////////////////
/*
 * @通过原型对时间类进行扩充
 * @usage:showtime = new Date().format("yyyy-MM-dd hh:mm:ss");
 */
Date.prototype.format = function(format)  
{  
   var o = {  
     "M+" : this.getMonth()+1, //month  
     "d+" : this.getDate(),    //day  
     "h+" : this.getHours(),   //hour  
     "m+" : this.getMinutes(), //minute  
     "s+" : this.getSeconds(), //second  
     "q+" : Math.floor((this.getMonth()+3)/3), //quarter  
     "S" : this.getMilliseconds() //millisecond  
   }  
   if(/(y+)/.test(format)) format=format.replace(RegExp.$1,  
     (this.getFullYear()+"").substr(4 - RegExp.$1.length));  
   for(var k in o)if(new RegExp("("+ k +")").test(format))  
     format = format.replace(RegExp.$1,  
       RegExp.$1.length==1 ? o[k] :   
         ("00"+ o[k]).substr((""+ o[k]).length));  
   return format;  
} 

/*
 * 函数：计算两个日期之间的差值
 * 参数：date是日期对象
 *    flag：ms-毫秒，s-秒，m-分，h-小时，d-天，M-月，y-年
 * 返回：当前日期和date两个日期相差的毫秒/秒/分/小时/天
 */
Date.prototype.dateDiff = function (date,flag) {
     var msCount;
     var diff = this.getTime() - date.getTime();
     switch (flag) {
         case "ms":
             msCount = 1;
             break;
         case "s":
             msCount = 1000;
             break;
         case "m":
             msCount = 60 * 1000;
             break;
         case "h":
             msCount = 60 * 60 * 1000;
             break;
         case "d":
             msCount = 24 * 60 * 60 * 1000;
             break;
     }
     return Math.floor(diff / msCount);
};
/*
 * 函数将yyyy-MM-dd类型时间的字符串转换成Date类型
 */
Date.prototype.parse = function(str){
	str = str.replace(/-/g,"/");
	var date = new Date(str);
	return date;
}