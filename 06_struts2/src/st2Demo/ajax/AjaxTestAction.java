package st2Demo.ajax;

import com.opensymphony.xwork2.ActionSupport;

public class AjaxTestAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String data;

	private int count=0;
	
	public int getCount() {
		return count++;
	}
	public String getData() {
		data = "service data";
		return data;
	}
	
	public Long getServiceTime(){
		return System.currentTimeMillis();
	}
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
}
