package com.opslab.hibernate.entity.extend.subclass;

public class Employee {
	private Integer EmployeeId;
	
	private String  userName;

	public Integer getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		EmployeeId = employeeId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Employee [EmployeeId=" + EmployeeId + ", userName=" + userName + "]";
	}
	
}
