package st2Demo.CRUD.CRM;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class employeeDao {
	
	/**
	 * use map as db
	 */
	public static Map<Integer,Employee> map = new LinkedHashMap<Integer, Employee>();
	
	static {
		map.put(1001, new Employee(1001,"AA","男","Java Coder"));
		map.put(1002, new Employee(1002,"BB","女","WEB UI"));
		map.put(1003, new Employee(1003,"CC","男","DBA"));
		map.put(1004, new Employee(1004,"DD","男","System Manager"));
		map.put(1005, new Employee(1005,"EE","男","PYTHON"));
		map.put(1006, new Employee(1006,"FF","男","CODE SEC"));
		map.put(1007, new Employee(1007,"HH","男","PM"));
	}
	
	/**
	 * @summary: add object into db
	 * @param e
	 * @return
	 */
	public boolean add(Employee e){
		int id=(int) System.currentTimeMillis();
		e.setEmployeeId(id);
		map.put(id, e);
		return true;
	};
	
	/**
	 * @summary:update object into db
	 * @param e
	 * @return
	 */
	public boolean edit(Employee e){
		map.put(e.getEmployeeId(), e);
		return true;
	}
	
	/**
	 * @summary:delete object form db
	 * @param id
	 * @return
	 */
	public boolean deleteById(Integer id){
		map.remove(id);
		return true;
	}
	
	/**
	 * @summary:get object with object's id 
	 * @param id
	 * @return
	 */
	public Employee getById(Integer id){
		return map.get(id);
	}
	
	/**
	 * @summary:get all object as list
	 * @return
	 */
	public List<Employee> getList(){
		List<Employee> list = new ArrayList<Employee>(map.values());
		return list;
	}
	
	
}
