package com.opslab.workflow.framework.entity.business;

import com.opslab.workflow.framework.entity.view.UiTree;

/**
 *  业务实体
 */
public class Deptments {
    private String id;

    private String deptId;

    private String detpName;

    private String valid;

    private String parentId;

    public UiTree toUiTree(){
        return new UiTree(deptId,detpName,parentId);
    }

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
