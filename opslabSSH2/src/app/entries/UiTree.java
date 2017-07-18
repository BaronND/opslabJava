package app.entries;

import app.util.validata;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 
 * @function: 主要用于将业务实体分装成前台需要的JSON数据格式
 * @Summary： 不做Hibernate映射
 * 
 * @目标JSON格式 [{ "id":1, "text":"Folder1", "iconCls":"icon-save", "children":[{
 *           "text":"File1", "checked":true }] }]
 */
public class UiTree {

	@Getter @Setter private String id;

	@Getter @Setter private String pid;
	
	@Getter @Setter private String rid;

	@Getter @Setter private String text;

	@Getter @Setter private String isBranch;
	
	@Getter @Setter private Map<String,String> attributes = new HashMap<String,String>();

	@Getter @Setter private List<UiTree> children = new ArrayList<UiTree>();
	
	public UiTree() {}

	public UiTree(String id, String pid, String text, String isBranch, Map<String, String> attributes) {
		this.id = id;
		this.pid = pid;
		this.text = text;
		this.isBranch = isBranch;
		this.attributes = attributes;
	}


	/**
	 * 返回父子关联的结构化的数据
	 * @param pList
	 * @return
	 */
	public static List<UiTree> trimPList(List<UiTree> pList){
		List<UiTree> r = new ArrayList<UiTree>();
		List<UiTree> t = new ArrayList<UiTree>(); 
		if(validata.isValid(pList)){
			for(UiTree p:pList){
				r.add(p);
				for(UiTree pp:pList){
					if(p.getId().equals(pp.getPid())){
						p.getChildren().add(pp);
						t.add(pp);
					}
				}
			}
		}
		r.removeAll(t);
		return r;
	}

	/**
	 * 返回父子关联的结构化的数据
	 * @param pList
	 * @param cList
	 * @return
	 */
	public static List<UiTree> trimPList(List<UiTree> pList,List<UiTree> cList){
		List<UiTree> r = new CopyOnWriteArrayList<UiTree>();
		List<UiTree> t = new CopyOnWriteArrayList<UiTree>();
		if(validata.isValid(pList) && validata.isValid(cList)){
			for(UiTree p:pList){
				r.add(p);
				for(UiTree pp:pList){
					if(p.getId().equals(pp.getPid())){
						p.getChildren().add(pp);
						t.add(pp);
					}
				}
				for(UiTree c:cList){
					if(p.getId().toString().equals(c.getPid())){
						p.getChildren().add(c);
					}
				}
			}
		}

		r.removeAll(t);
		for(UiTree s:r){
			if(!validata.isValid(s.getChildren())){
				r.remove(s);
			}
		}

		return r;
	}
	
}
