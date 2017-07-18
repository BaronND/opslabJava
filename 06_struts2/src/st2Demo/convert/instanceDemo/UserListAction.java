package st2Demo.convert.instanceDemo;

import java.util.ArrayList;
import java.util.List;

import st2Demo.convert.instanceDemo.model.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.ConditionalVisitorFieldValidator;

public class UserListAction extends ActionSupport implements ModelDriven<List<User>>{

	private static final long serialVersionUID = 1L;
	
	private List<User> userlist;

	
	public List<User> getUserlist() {
		return userlist;
	}

	@ConditionalVisitorFieldValidator(appendPrefix=true, 
				context= "complext" ,message="User:", expression = "userlist !=null")
	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}

	@Override
	public List<User> getModel() {
		userlist = new ArrayList<User>();
		return userlist;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println(this.userlist);
		return super.execute();
	}

}
