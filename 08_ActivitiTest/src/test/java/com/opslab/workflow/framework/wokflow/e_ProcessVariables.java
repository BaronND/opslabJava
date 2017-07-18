package com.opslab.workflow.framework.wokflow;

import java.util.Date;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

import com.opslab.workflow.ActivitiTest;
import com.opslab.workflow.framework.entity.CustomerInfo;
import com.opslab.workflow.util.JacksonUtil;

public class e_ProcessVariables extends ActivitiTest{

	@Test
	public void deployProcessDefinition(){
		String processDefinition = "flow/processVariables.bpmn";
		Deployment deploy = repositoryService.createDeployment()
			.addClasspathResource(processDefinition)
			.deploy();
		System.out.println("Deploy:" + JacksonUtil.toJSON(deploy));
		System.out.println("部署ID:" + deploy.getId());
		System.out.println("部署名称:" + deploy.getName());
	}
	
	@Test
	public void startProcessInstance(){
		String processInstanceKey ="processVariables";
		ProcessInstance processInstance = 
				runtimeService.startProcessInstanceByKey(processInstanceKey);
		System.out.println("流程ID:"+processInstance.getId());
	}
	
	/**
	 * 设置任务变量
	 * 其值会保存在表act_ru_variable中
	 */
	@Test
	public void setTaskVariables(){
		Task task = taskService.createTaskQuery()
			.taskAssignee("张晓晓")
			.orderByTaskCreateTime().desc()
			.singleResult();
		
		System.out.println("taskId:"+task.getId());
		System.out.println("taskName:"+task.getName());
		System.out.println("task:"+JacksonUtil.toJSON(task));
		
		String taskId = task.getId();
		//设置基础类型的环境变量
		taskService.setVariable(taskId, "开始时间", new Date());
		taskService.setVariable(taskId, "申请人", "张晓晓");
		//设置javabean类型(必须实现serializable接口)
		taskService.setVariable(taskId, "客户信息",
				new CustomerInfo("customerId","客户名称"));
		
		taskService.complete(taskId);
	}
}
