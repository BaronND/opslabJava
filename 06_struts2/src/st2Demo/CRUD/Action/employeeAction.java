package st2Demo.CRUD.Action;

/*
 * @summary：
 * 		实现一个完整的Action实例
 * 注意：
 * 		此处使用了ModelDrvien接口技术
 */

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.omg.PortableInterceptor.ACTIVE;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.util.ValueStack;

import st2Demo.CRUD.CRM.Employee;
import st2Demo.CRUD.CRM.employeeDao;

@SuppressWarnings("unused")
public class employeeAction implements RequestAware,ModelDriven<Employee>,Preparable,ServletRequestAware{
	
	private employeeDao dao = new employeeDao();
	
	private Map<String, Object> requestMap;

	private HttpServletRequest request;
	
	private Employee employee;
	
	private Integer employeeId;
	

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		requestMap = arg0;
	}

	/**
	 * action通过实现ModelDriven接口，将请求信息封装成一个Employee对象
	 */
	@Override
	public Employee getModel() {
		/**
		 * 该方法会在调用action的action方法前回将该函数返回的对象压入到值栈中
		 * 
		 * 因此可以通过通过盘的employee对象的id属性来判断当前操作是对现有的对象做修改还是新增
		 * （需要在该action中添加一个id属性，同时需要注意为了在做判断前为id属性赋值，
		 *  此处需要使用paramsPrepareParamsStack拦截器栈
		 *  在package中加入<!-- 修改该包中的默认的拦截器栈 -->
		 *  <default-interceptor-ref name="paramsPrepareParamsStack"></default-interceptor-ref>
		 *  ）
		 *  
		 * 
		 */
		//为action添加employeeId
//		if(employeeId ==  null){
//			//新增操作
//			employee = new Employee();
//		}else{
//			//对现有的做修改
//			employee = dao.getById(employeeId);
//		}
		//employee = new Employee();
		return employee;
	}
	
	/**
	 * Action  
	 */
	public String listAction() {
		requestMap.put("employeeList", dao.getList());
		return "emp-list";
	}
	///////////////////////////////////////////////////////////
	public void prepareDeleteAction(){
		employee = dao.getById(employeeId);
	}
	public String deleteAction() {
		dao.deleteById(employee.getEmployeeId());
		return "success";
	}

	///////////////////////////////////////////////////////////
	public void prepareAddAction(){
		employee = new Employee();
	}
	public String addAction(){
		dao.add(employee);
		return "success";
	}
	
	///////////////////////////////////////////////////////////
	public void prepareUpdateAction(){
		employee = dao.getById(employeeId);
	}
	public String updateAction(){
		dao.edit(employee);
		return "success";
	}
	
	
	///////////////////////////////////////////////////////////
	public void prepareEditAction(){
		//action使用paramsPrepareParamsStack拦截器栈
		//并且实现了preapare接口，
		//所以再调用editAction方法前，改方法被调用，为ModelDriven准备对象，以便压入到对象栈顶
		System.out.println("prepareEditAction is call....");
		employee = dao.getById(employeeId);
	}
	public String editAction(){
		//下面的方式不能完成表单回显
		//因为employee对象新建后与valuestack栈中的对象就断绝关系，成俩个对立的对象
		//employee = dao.getById(employee.getEmployeeId());
		
		
		//1.首先该action实现了ModelDriven接口，所以edit?employeeId=xx提交的时候employee对象的id被赋值了
		//2.通过dao获取一个employeed对象并将其压入valuestack，中用于回显
		//3.注意此时valuestack中有俩个valuestack对象
		//ActionContext.getContext().getValueStack().push(dao.getById(employee.getEmployeeId()));
		return "emp-edit";
	}


	@Override
	public void prepare() throws Exception {
		//当action实现了prepare接口后，struts在调用目标action的action方法前会调用
		//prepareMehotd或prepareDoMethod方法，当然改方法在modeldriven前调用，因此可以通过改方式觉得
		//新建一个employee对象还是从数据库中返回一个对象
		ActionContext context = ActionContext.getContext();
		System.out.println(ActionContext.getContext().getActionInvocation());
		System.out.println(ActionContext.getContext().get("current.property.path"));
/*		Enumeration<String> enumeration = request.getAttributeNames();
		while(enumeration.hasMoreElements()){
			String name = enumeration.nextElement();
			System.out.println(name+":"+request.getAttribute(name));
		}*/
		//System.out.println(request.getAttribute("javax.servlet.forward.request_uri"));
	
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}


}
