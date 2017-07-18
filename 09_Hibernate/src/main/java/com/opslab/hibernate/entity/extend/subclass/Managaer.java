package com.opslab.hibernate.entity.extend.subclass;

public class Managaer extends Employee{
	private String ManagerDept;

	public String getManagerDept() {
		return ManagerDept;
	}

	public void setManagerDept(String managerDept) {
		ManagerDept = managerDept;
	}

}
