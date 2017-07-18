package st2Demo.validation.hello.Action;

import com.opensymphony.xwork2.ActionSupport;

public class nonFieldValidationAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private  String password;
	
	private  String rpassword;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRpassword() {
		return rpassword;
	}

	public void setRpassword(String rpassword) {
		this.rpassword = rpassword;
	}
	
	@Override
	public String toString() {
		return "nonFieldValidationAction [password=" + password + ", rpassword=" + rpassword + "]";
	}

	@Override
	public String execute() throws Exception {
		System.out.println(this);
		return SUCCESS;
	}
}
