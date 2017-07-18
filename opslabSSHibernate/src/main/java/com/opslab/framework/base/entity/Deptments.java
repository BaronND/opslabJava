package com.opslab.framework.base.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *  业务实体
 */
public class Deptments {
	@JsonProperty("key")
    private String id;

	@JsonProperty("id")
    private String deptId;

	@JsonProperty("name")
    private String detpName;

    private String valid;

	@JsonProperty("pId")
    private String parentId;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDetpName() {
		return detpName;
	}

	public void setDetpName(String detpName) {
		this.detpName = detpName;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}



}
