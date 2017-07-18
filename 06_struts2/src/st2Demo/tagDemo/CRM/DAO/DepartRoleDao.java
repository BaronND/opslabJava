package st2Demo.tagDemo.CRM.DAO;

import java.util.ArrayList;
import java.util.List;

import st2Demo.tagDemo.CRM.Department;
import st2Demo.tagDemo.CRM.Role;

public class DepartRoleDao {
	public List<Department> getDeptList(){
		List<Department> list = new ArrayList<Department>();
		
		list.add( new Department(1001,"产品研发部"));
		
		list.add(new Department(1002,"发展规划部"));
		
		list.add(new Department(1003,"信息安全部"));
		
		list.add(new Department(1004,"市场营销部"));
		
		list.add( new Department(1004,"财务部"));
		
		list.add(new Department(1004,"行政部"));
		return list;
		
	}
	
	public List<Role> getRoleList(){
		List<Role> list = new ArrayList<Role>();
		list.add(new Role(1001,"BOSS"));
		
		list.add(new Role(1002,"loader"));
		
		list.add(new Role(1003,"Manager"));
		
		list.add( new Role(1004,"member"));
		
		return list;
	}
}
