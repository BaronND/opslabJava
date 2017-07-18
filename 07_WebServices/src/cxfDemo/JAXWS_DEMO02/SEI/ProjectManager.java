package cxfDemo.JAXWS_DEMO02.SEI;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


@WebService(serviceName="ProjectManagerWS", name="ProjectManagerWS")
public interface ProjectManager {

	
	@WebMethod
	public String  getProjectName();
	
	@WebMethod
	public String  getProjectNameById(
			@WebParam(name="Id")
			String Id);
}
