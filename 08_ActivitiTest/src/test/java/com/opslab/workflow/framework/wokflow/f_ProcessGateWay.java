package com.opslab.workflow.framework.wokflow;

import java.util.List;

import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmActivity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

import com.opslab.DateUtil;
import com.opslab.workflow.ActivitiTest;
import com.opslab.workflow.util.JacksonUtil;

public class f_ProcessGateWay extends ActivitiTest{
	
	@Test
	public void deploy(){
		Deployment deploy = repositoryService.createDeployment()
			.addClasspathResource("flow/c_gateway/GATEWAY01.bpmn")
			.addClasspathResource("flow/c_gateway/GATEWAY01.png")
			.deploy();
		System.out.println("Deploy:" + JacksonUtil.toJSON(deploy));
		System.out.println("部署ID:" + deploy.getId());
		System.out.println("部署名称:" + deploy.getName());

	}
	
	

	
	@Test
	public void startProcess(){
		String processKey ="GATEWAY01";
		ProcessInstance processInstance = 
				runtimeService.startProcessInstanceByKey(processKey);
		System.out.println("流程ID:"+processInstance.getId());
		
	
	}
	
	@Test
	public void queryTask(){
		List<Task> list = taskService.createTaskQuery().taskAssignee("张三")
					.list();
		if (list != null && list.size() > 0) {
			for (Task task : list) {
				System.out.println("任务ID:" + task.getId());
				System.out.println("任务名称:" + task.getName());
				System.out.println("任务的创建时间:" + DateUtil.DateTime(task.getCreateTime()));
				System.out.println("任务的办理人:" + task.getAssignee());
				System.out.println("流程实例ID：" + task.getProcessInstanceId());
				System.out.println("执行对象ID:" + task.getExecutionId());
				System.out.println("流程定义ID:" + task.getProcessDefinitionId());
				System.out.println("########################################################");
			}
		}
	}
	
	@Test
	public void queryExecution(){
		List<Execution> list = runtimeService.createExecutionQuery()
			.processDefinitionKey("GATEWAY01").list();
		if(list != null && list.size() > 0){
			for(Execution e:list){
				System.out.println(e.getId());
				System.out.println(e.getActivityId());
				System.out.println(e.getParentId());
				System.out.println(e.getProcessInstanceId());
			}
		}
	}

	@Test
	public void queryNextTask(){
		String currentActivitiId  = workFlow.currentActivityId("20001");
		ProcessDefinitionEntity processDefinitionEntity =
				workFlow.getProcessDefinitionEntity("20001");

		List<ActivityImpl> activities = processDefinitionEntity.getActivities();
		if(activities != null && activities.size() > 0){
			for(ActivityImpl a:activities){
				if(currentActivitiId.equals(a.getId())){
					System.out.println("当前环节:"+a.getId()+":"+a.getProperty("name"));
					List<PvmTransition> outgoingTransitions = a.getOutgoingTransitions();
					for(PvmTransition p:outgoingTransitions){
						PvmActivity destination = p.getDestination();
						System.out.println("下一个环节:"+destination.getId()+":"+destination.getProperty("name"));
					}
				}
			}
		}
	}
}
