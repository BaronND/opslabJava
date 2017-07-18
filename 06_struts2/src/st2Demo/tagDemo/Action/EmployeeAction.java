package st2Demo.tagDemo.Action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;

import st2Demo.tagDemo.CRM.DAO.DepartRoleDao;

public class EmployeeAction implements ApplicationAware, RequestAware {
	
	private Map<String, Object> applicationMap;
	
	private Map<String, Object> requestMap;
	
	private DepartRoleDao dao = new DepartRoleDao();
	
	private String userName;
	
	private String sex;
	
	private String depts;
	
	private String desc;
	
	private List<String> roles;

	@Override
	public String toString() {
		return "EmployeeAction [userName=" + userName + ", sex=" + sex + ", depts=" + depts + ", desc=" + desc + ", roles=" + roles + "]";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDepts() {
		return depts;
	}

	public void setDepts(String depts) {
		this.depts = depts;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.requestMap = arg0;
	}

	@Override
	public void setApplication(Map<String, Object> arg0) {
		this.applicationMap = arg0;
		
	}
	public String saveAction(){
		System.out.println("save:"+ this);
		return "success";
	}
	
	public String addAction(){
		applicationMap.put("listDept", dao.getDeptList());
		
		requestMap.put("listRole", dao.getRoleList());
		
		return "input";
	}
}
