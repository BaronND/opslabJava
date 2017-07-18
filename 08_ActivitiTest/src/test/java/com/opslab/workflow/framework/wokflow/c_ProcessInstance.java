package com.opslab.workflow.framework.wokflow;

import java.util.List;

import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

import com.opslab.workflow.ActivitiTest;
import com.opslab.workflow.util.JacksonUtil;

public class c_ProcessInstance extends ActivitiTest{
	/**
	 * 启动流程
	 */
	@Test
	public void startProcessInstance(){
		String processKey = "helloworld";
		ProcessInstance processInstance = 
				runtimeService.startProcessInstanceByKey(processKey);
		System.out.println("流程ID:"+processInstance.getId());
		System.out.println("流程定义ID:"+
				processInstance.getProcessDefinitionId());
		System.out.println("流程定义Key:"+
				processInstance.getProcessDefinitionKey());
		System.out.println("流程信息:"+JacksonUtil.toJSON(processInstance));
	}
	
	
	/**
	 * 查询个人任务
	 * 查询的数据库的表act_ru_task
	 */
	@Test
	public void queryTask(){
		String userInfo = "张三";
		List<Task> list = taskService.createTaskQuery()
				/*查询条件*/
				.taskAssignee(userInfo)
//				.taskCandidateUser(candidateUser)//组任务的办理人查询
//				.processDefinitionId(processDefinitionId)//使用流程定义ID查询
//				.processInstanceId(processInstanceId)//使用流程实例ID查询
//				.executionId(executionId)//使用执行对象ID查询
				
				/*排序*/
				.orderByTaskCreateTime().asc()//使用创建时间的升序排列
				/*查询结果*/
//				.singleResult()//返回惟一结果集
//				.count()//返回结果集的数量
//				.listPage(firstResult, maxResults);//分页查询
				.list();
		
		if(list != null && list.size() > 0){
			for(Task t:list){
				System.out.println("任务ID:"+t.getId());
				System.out.println("任务名称:"+t.getName());
				System.out.println("任务的创建时间:"+t.getCreateTime());
				System.out.println("任务的办理人:"+t.getAssignee());
				System.out.println("流程实例ID："+t.getProcessInstanceId());
				System.out.println("执行对象ID:"+t.getExecutionId());
				System.out.println("流程定义ID:"+t.getProcessDefinitionId());
				System.out.println("##################");
			}
		}
	}
	
	/**
	 * 完成任务
	 */
	@Test
	public void completeTask(){
		String taskId ="2508";
		taskService.complete(taskId);
		System.out.println("完成任务：任务ID："+taskId);
	}
	
	@Test
	public void queryTaskStatus(){
		String taskId="2508";
		ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
			.processInstanceId(taskId)
			.singleResult();
		
		if(processInstance == null){
			System.out.println("任务已经完成");
		}else{
			System.out.println("任务还未完成");
		}
	}

}
