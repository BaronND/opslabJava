package st2Demo.convert.instanceDemo;

import st2Demo.convert.instanceDemo.model.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{

	private static final long serialVersionUID = 1L;
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public User getModel() {
		user = new User();
		return user;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println(this.user);
		return super.execute();
	}

}
