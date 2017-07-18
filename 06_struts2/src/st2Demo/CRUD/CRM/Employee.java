package st2Demo.CRUD.CRM;

public class Employee {
	private 	Integer	 employeeId;
	private 	String 	 employeeName;
	private		String sex;
	private     String skill;
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	@Override
	public String toString() {
		return "employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", sex=" + sex + ", skill=" + skill + "]";
	}
	public Employee(Integer employeeId, String employeeName, String sex, String skill) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.sex = sex;
		this.skill = skill;
	}
	public Employee() {
	}
	
}
