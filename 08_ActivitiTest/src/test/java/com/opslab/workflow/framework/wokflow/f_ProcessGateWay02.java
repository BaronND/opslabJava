package com.opslab.workflow.framework.wokflow;

import java.util.List;

import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmActivity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

import com.opslab.DateUtil;
import com.opslab.workflow.ActivitiTest;
import com.opslab.workflow.util.JacksonUtil;

public class f_ProcessGateWay02 extends ActivitiTest {

	@Test
	public void deploy() {
		Deployment deploy1 = repositoryService.createDeployment()
				.addClasspathResource("flow/c_gateway/GATEWAY02.bpmn")
				.addClasspathResource("flow/c_gateway/GATEWAY02.png").deploy();
		System.out.println("Deploy:" + JacksonUtil.toJSON(deploy1));
		System.out.println("部署ID:" + deploy1.getId());
		System.out.println("部署名称:" + deploy1.getName());
	}

	@Test
	public void startProcess() {
		String processKey = "GATEWAY02";
		ProcessInstance processInstance = runtimeService
				.startProcessInstanceByKey(processKey);
		System.out.println("流程ID:" + processInstance.getId());
	}

	@Test
	public void queryTask() {
		List<Task> list = taskService.createTaskQuery().taskAssignee("张三")
				.list();
		if (list != null && list.size() > 0) {
			for (Task task : list) {
				System.out.println("任务ID:" + task.getId());
				System.out.println("任务名称:" + task.getName());
				System.out.println(
						"任务的创建时间:" + DateUtil.DateTime(task.getCreateTime()));
				System.out.println("任务的办理人:" + task.getAssignee());
				System.out.println("流程实例ID：" + task.getProcessInstanceId());
				System.out.println("执行对象ID:" + task.getExecutionId());
				System.out.println("流程定义ID:" + task.getProcessDefinitionId());
			}
		}
	}

	@Test
	public void queryNextTask() {
		String currentActivitiId = workFlow.currentActivityId("30001");
		ProcessDefinitionEntity processDefinitionEntity = workFlow
				.getProcessDefinitionEntity("30001");

		List<ActivityImpl> activities = processDefinitionEntity.getActivities();
		if (activities != null && activities.size() > 0) {
			for (ActivityImpl a : activities) {
				if (currentActivitiId.equals(a.getId())) {
					System.out.println(
							"当前环节:" + a.getId() + ":" + a.getProperty("name"));
					List<PvmTransition> outgoingTransitions = a
							.getOutgoingTransitions();
					for (PvmTransition p : outgoingTransitions) {
						PvmActivity destination = p.getDestination();
						System.out.println("下一个环节:" + destination.getId() + ":"
								+ destination.getProperty("name"));
					}
				}
			}
		}
	}
}
