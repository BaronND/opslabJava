package st2Demo.convert.complext.Action;

import st2Demo.convert.complext.CRM.Deptment;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @summary:
 * 	测试符合类型
 * 1. Department 是模型, 实际录入的 Department. deptName 可以直接写到
 * s:textfield 的 name 属性中. 那 mgr 属性如何处理呢 ?
 * 
 * struts2 表单标签的 name 值可以被赋为 属性的属性: name=mgr.name, name=mgr.birth
 * 
 * 2. mgr 中有一个 Date 类型的 birth 属性, Struts2 可以完成自动的类型转换吗 ?
 * 
 * 全局的类型转换器可以正常工作!
 *
 */ 
public class complextModelAction extends ActionSupport implements ModelDriven<Deptment> {
	private static final long serialVersionUID = -4545293962142711779L;
	
	private Deptment deptment;
	
	public Deptment getDeptment() {
		return deptment;
	}

	public void setDeptment(Deptment deptment) {
		this.deptment = deptment;
	}

	@Override
	public Deptment getModel() {
		deptment = new Deptment();
		return deptment;
	}

	public String execute(){
		System.out.println(this.deptment);
		return SUCCESS;
	}
	
}
