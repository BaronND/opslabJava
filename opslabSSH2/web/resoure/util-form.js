var Form = function(forms){
	this. ff = forms;
}
Form.prototype ={
	dataURI:function(){
		var data = this.data(),str='';
		for (var i in data) {
			str +='&'+i+'='+data[i];
		};
		return str.substr(1,str.length);
	},
	//返回表单的有效值及获取所有的输入内容
	data:function(){
		var nodes = this.ff.elements,data ={};
		for (var i = 0; i< nodes.length; i++) {
			var node =nodes[i];
			if(node.name && node.value){
				if(this.equalsIgnoreCase(node.type,'radio') || this.equalsIgnoreCase(node.type,'checkbox')){
					if(node.checked){
						data[node.name] = node.value;
					}
				}else{
					data[node.name] = node.value;
				}
			}
		}
		return data;	
	},
	//返回表单元素的数据集
	dataAll:function(){
		var nodes = this.ff.elements,data ={};
		for (var i = 0; i< nodes.length; i++) {
			var node =nodes[i];
			if(node.name){
				if(node.nodeName == 'SELECT'){
					if(node.name in data){
						data[node.name] = data[node.name]+','+this.optionAll(node).join(',');
					}else{
						data[node.name] = this.optionAll(node).join(',');
					}					
				}else{
					if(node.name in data){
						data[node.name] = data[node.name]+','+node.value;
					}else{
						data[node.name] = node.value;
					}
				}

			}
		}
		return data;	
	},
	//返回select的所有可选项['value|name',]的数组
	optionAll:function(elt){
		if(elt.nodeName != 'SELECT')
			throw new Error('Object is not Select-Elements');
		var nodes = elt.options,data=[];
		for(var i =0;i< nodes.length;i++){
			var node =nodes[i];
			data[i]=node.value+"|"+node.text;
		}
		return data;
	},
	equalsIgnoreCase:function(str1, str2){
		if(str1.toUpperCase() == str2.toUpperCase()){
			return true;
		}
		return false;
	} 
};
