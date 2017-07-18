package st2Demo.validation.hello.Action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @summary:
 * 	 测试struts的输入验证，
 * 		此处验证客户端提交的age师傅在16~80 
 *
 */
public class validateAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private int  age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String execute(){
		System.out.println(this.age);
		return SUCCESS;
	}
}
