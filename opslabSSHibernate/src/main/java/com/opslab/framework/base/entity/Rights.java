package com.opslab.framework.base.entity;

import java.util.ArrayList;
import java.util.List;

public class Rights {
	//ID
	private Integer rightsId;
	
	//权限编码(code)
	private Long  rightsCode;
	
	//权限组(code)
	private int  rightsGroup;
	
	//权限名称
	private String  rightsName;
	
	//功能分组
	private String  groupId;
	
	//功能分组根Id
	private String  rootId;
		
	//权限描述
	private String  rightsDesc;
	
	//权限地址
	private String  address;
	
	//主要用于树形结构的控制
	private List<Rights> children= new ArrayList<Rights>();
	
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
		return "Rights [rightsId=" + rightsId + ", rightsCode=" + rightsCode + ", rightsGroup=" + rightsGroup
				+ ", rightsName=" + rightsName + ", groupId=" + groupId + ", rootId=" + rootId + ", rightsDesc="
				+ rightsDesc + ", address=" + address + ", children=" + children + ", isValid=" + isValid
				+ ", isPublic=" + isPublic + ", isBranch=" + isBranch + "]";
	}

	public Integer getRightsId() {
		return rightsId;
	}

	public void setRightsId(Integer rightsId) {
		this.rightsId = rightsId;
	}

	public Long getRightsCode() {
		return rightsCode;
	}

	public void setRightsCode(Long rightsCode) {
		this.rightsCode = rightsCode;
	}

	public int getRightsGroup() {
		return rightsGroup;
	}

	public void setRightsGroup(int rightsGroup) {
		this.rightsGroup = rightsGroup;
	}

	public String getRightsName() {
		return rightsName;
	}

	public void setRightsName(String rightsName) {
		this.rightsName = rightsName;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getRootId() {
		return rootId;
	}

	public void setRootId(String rootId) {
		this.rootId = rootId;
	}

	public String getRightsDesc() {
		return rightsDesc;
	}

	public void setRightsDesc(String rightsDesc) {
		this.rightsDesc = rightsDesc;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Rights> getChildren() {
		return children;
	}

	public void setChildren(List<Rights> children) {
		this.children = children;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public void setBranch(boolean isBranch) {
		this.isBranch = isBranch;
	}


}
