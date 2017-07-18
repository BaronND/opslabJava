package com.opslab.workflow;

import com.opslab.workflow.framework.service.WorkFlow;
import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;


public class ActivitiTest extends SpringTest{
	protected ProcessEngine processEngine;
	
	protected RepositoryService repositoryService;
	
	protected RuntimeService runtimeService;
	
	protected TaskService taskService;
	
	protected FormService formService;
	
	protected HistoryService historyService;
	
	protected ManagementService managementService;

	protected IdentityService identityService;
	
	protected WorkFlow workFlow;

	@Override
	public void after() {
		super.after();
	}

	@Override
	public void before() {
		super.before();
		processEngine = (ProcessEngine) Context.getBean("processEngine");
		repositoryService = (RepositoryService) Context.getBean("repositoryService");
		runtimeService = (RuntimeService) Context.getBean("runtimeService");
		taskService = (TaskService) Context.getBean("taskService");
		formService = (FormService) Context.getBean("formService");
		historyService = (HistoryService) Context.getBean("historyService");
		managementService = (ManagementService) Context.getBean("managementService");
		identityService = (IdentityService) Context.getBean("identityService");
		workFlow = (WorkFlow) Context.getBean("activitiWorkFlow");
	}
	
	

}
