package com.opslab.workflow.framework.entity.business;

import java.util.List;


/***
 * @function:
 * 		树形选项是的映射实体
 *
 */
public class Tree {

	//业务主键ID
	private Integer id;

	//叶子节点ID
	private String  treeId;

	//叶子节点名称
	private String  treeName;

	//父节点ID
	private String  parentId;

	//是否叶子节点
	private boolean isLeaf;

	//是否有效
	private boolean isValid;

	//节点类型ID
	private String  treeTypeId;

	//节点类型名称
	private String  treeTypeName;

	//根节点Id
	private String  rootId;

	//根节点名称
	private String  rootName;

	//全名称
	private String  allName;

	//子节点集合
	List<Tree> child;

	public void setIsLeaf(boolean b){
		this.isLeaf =b;
	}

	public boolean getIsLeaf(){
		return this.isLeaf;
	}

	public void setIsValid(boolean b){
		this.isValid = b;
	}

	public boolean getIsValid(){
		return this.isValid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTreeId() {
		return treeId;
	}

	public void setTreeId(String treeId) {
		this.treeId = treeId;
	}

	public String getTreeName() {
		return treeName;
	}

	public void setTreeName(String treeName) {
		this.treeName = treeName;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getTreeTypeId() {
		return treeTypeId;
	}

	public void setTreeTypeId(String treeTypeId) {
		this.treeTypeId = treeTypeId;
	}

	public String getTreeTypeName() {
		return treeTypeName;
	}

	public void setTreeTypeName(String treeTypeName) {
		this.treeTypeName = treeTypeName;
	}

	public String getRootId() {
		return rootId;
	}

	public void setRootId(String rootId) {
		this.rootId = rootId;
	}

	public String getRootName() {
		return rootName;
	}

	public void setRootName(String rootName) {
		this.rootName = rootName;
	}

	public String getAllName() {
		return allName;
	}

	public void setAllName(String allName) {
		this.allName = allName;
	}

	public List<Tree> getChild() {
		return child;
	}

	public void setChild(List<Tree> child) {
		this.child = child;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	
	
}
