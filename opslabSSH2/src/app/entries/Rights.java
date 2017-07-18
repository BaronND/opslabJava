package app.entries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.util.validata;
import lombok.Getter;
import lombok.Setter;

public class Rights {
	//ID
	@Getter @Setter private Integer rightsId;
	
	//权限编码(code)
	@Getter @Setter private Long  rightsCode;
	
	//权限组(code)
	@Getter @Setter private int  rightsGroup;
	
	//权限名称
	@Getter @Setter private String  rightsName;
	
	//功能分组
	@Getter @Setter private String  groupId;
	
	//功能分组根Id
	@Getter @Setter private String  rootId;
		
	//权限描述
	@Getter @Setter private String  rightsDesc;
	
	//权限地址
	@Getter @Setter private String  address;
	
	//主要用于树形结构的控制
	@Getter @Setter private List<Rights> children= new ArrayList<Rights>();
	
	//是否启用
	private boolean isValid;
	
	//是否是公共的
	private boolean isPublic;
	
	//是否权限管理目录
	private boolean isBranch;
	
	public void setIsBranch(boolean s){
		this.isBranch = s;
	}
	
	public boolean getIsBranch(){
		return this.isBranch;
	}
	
	public void setIsValid(boolean s){
		this.isValid=s;
	}
	
	public void setIsPublic(boolean s){
		this.isPublic =s;
	}
	
	public boolean getIsValid(){
		return this.isValid;
	}
	
	public boolean getIsPublic(){
		return this.isPublic;
	}

	@Override
	public String toString() {
		return "Rights [rightsId=" + rightsId + "]";
	}

	/**
	 * @function:将权限对象转换成UiTree便于前台数据的组装
	 */
	public static List<UiTree> Rights2UiTree(List<Rights> list){
		List<UiTree> r = new ArrayList<UiTree>();
		
		if(validata.isValid(list)){
			for(Rights s:list){
				Map<String,String> map = new HashMap<String,String>();
				UiTree t= new UiTree();
				t.setId(s.getRightsId().toString());
				t.setText(s.getRightsName());
				t.setPid(s.getGroupId());
				t.setRid(s.getRootId());
				map.put("href",s.getAddress());
				t.setAttributes(map);
				r.add(t);
			}
		}
		return r;
	}
	
	/**
	 * @function:组装权限从属关系
	 * @param pList
	 * @param cList
	 * @return
	 */
	public static List<Rights> packListForJson(List<Rights> pList,List<Rights> cList){
		List<Rights> r = new ArrayList<Rights>();
		List<Rights> t = new ArrayList<Rights>();
		if(validata.isValid(pList)){
			for(Rights p:pList){
				r.add(p);
				for(Rights pp:pList){
					if(p.getRightsId().toString().equals(pp.getGroupId())){
						p.getChildren().add(pp);
						t.add(pp);
					}
				}
				for(Rights c:cList){
					if(p.getRightsId().toString().equals(c.getGroupId())){
						p.getChildren().add(c);
					}
				}
			}
		}
		r.removeAll(t);
		return r;
	}
}
