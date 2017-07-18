package com.opslab.workflow.framework.wokflow;

import java.util.List;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

import com.opslab.DateUtil;
import com.opslab.workflow.ActivitiTest;
import com.opslab.workflow.util.JacksonUtil;

/**
 * @author 0opslab
 * @date on 2016/4/21 0021.
 */
public class a_HellworldTest extends ActivitiTest {

	/**
	 * 部署并启动流程
	 */
	@Test
	public void deployProcess() {
		// 部署流程对象
		Deployment deploy = repositoryService.createDeployment()
				.addClasspathResource("flow/HelloWorld.bpmn").deploy();

		System.out.println("Deploy:" + JacksonUtil.toJSON(deploy));
		System.out.println("部署ID:" + deploy.getId());
		System.out.println("部署名称:" + deploy.getName());

		// 启动流程
		String processKey = "helloworld";
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processKey);
		System.out.println("流程实例ID:" + processInstance.getId());
		System.out.println("流程定义ID:" + processInstance.getProcessDefinitionId());
		System.out.println("流程信息:" + JacksonUtil.toJSON(processInstance));
	}

	/**
	 * 查询任务
	 */
	@Test
	public void testProcess() {
		// 查询个人任务
		String assignee = "张三";
		List<Task> list = taskService// 与正在执行的任务管理相关的Service
				.createTaskQuery()// 创建任务查询对象
				.taskAssignee(assignee)// 指定个人任务查询，指定办理人
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

	/**
	 * 完成我的任务
	 */
	@Test
	public void completeMyPersonalTask() {
		// 任务ID
		String taskId = "62508";
		// 与正在执行的任务管理相关的Service
		processEngine.getTaskService().complete(taskId);
		System.out.println("完成任务：任务ID：" + taskId);
	}
}