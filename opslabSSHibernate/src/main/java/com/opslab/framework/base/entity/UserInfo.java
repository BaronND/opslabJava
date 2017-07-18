package com.opslab.framework.base.entity;



/**
 *  业务实体
 */
public class UserInfo {
	private String userId;

    private String userCode;

    private String userName;

    private String deptId;

    private String password;

    private String valid;

    private String createTime;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public UserInfo() {
		super();
	}

	public UserInfo(String userCode, String userName, String deptId, String password) {
		this.userCode = userCode;
		this.userName = userName;
		this.deptId = deptId;
		this.password = password;
		this.valid="1";
	}
}
