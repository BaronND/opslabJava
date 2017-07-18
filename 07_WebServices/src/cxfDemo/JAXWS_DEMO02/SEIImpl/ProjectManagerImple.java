package cxfDemo.JAXWS_DEMO02.SEIImpl;

import javax.jws.WebService;

import cxfDemo.JAXWS_DEMO02.SEI.ProjectManager;


@WebService(serviceName="ProjectManagerWS", name="ProjectManagerWS")
public class ProjectManagerImple implements ProjectManager {

	@Override
	public String getProjectName() {
		String result="Service Print:getProjectName";
		System.out.println(result);
		return result;
	}

	@Override
	public String getProjectNameById(String Id) {
		String result="Service Print:getProjectNameById:"+Id;
		System.out.println(result);
		return result;
	}

}
