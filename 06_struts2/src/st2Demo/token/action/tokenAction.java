package st2Demo.token.action;

import com.opensymphony.xwork2.ActionSupport;

public class tokenAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String username;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(this.id+"-"+this.username);
		return SUCCESS;
	}
	
	

}
