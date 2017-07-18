package struts1.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class loginForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	private String username;

	private String password;

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors error = new ActionErrors();
		if(this.username == null || "".equals(this.username)){
			error.add("username",new ActionMessage("loginError.username"));
		}
		if(this.password == null || "".equals(this.password)){
			error.add("password",new ActionMessage("loginError.password"));
		}
		return error;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
