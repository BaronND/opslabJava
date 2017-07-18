package com.opslab.workflow.framework.wokflow;

import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.junit.Test;

import com.opslab.valid;
import com.opslab.workflow.ActivitiTest;

/**
 * 测试流程定义
 * 
 * @author Administrator
 *
 */
public class b_ProcessDefinition extends ActivitiTest {

	/**
	 * 通过classpath下的资源文件部署流程
	 */
	@Test
	public void deployProcessDefinition_classpath() {

		Deployment deploy = repositoryService.createDeployment()
				.addClasspathResource("flow/HelloWorld.bpmn")
				.addClasspathResource("flow/HelloWorld.png")
				.deploy();

		System.out.println("部署ID：" + deploy.getId());
		System.out.println("部署名称：" + deploy.getName());
	}

	/**
	 * 部署zip文件
	 */
	@Test
	public void deployProcessDefinition_zip() {
		InputStream inputStream = this.getClass().getClassLoader()
				.getResourceAsStream("flow/flow.zip");
		Deployment deploy = repositoryService.createDeployment()
				.addZipInputStream(new ZipInputStream(inputStream)).deploy();

		System.out.println("部署ID：" + deploy.getId());
		System.out.println("部署名称：" + deploy.getName());
	}

	/**
	 * 查询流程定义的信息 查询的数据库的表act_re_procdef
	 */
	@Test
	public void queryProcessDefinition() {
		List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery()
				// .deploymentId("105001") //使用部署对象ID查询
				// .processDefinitionId("105001")//使用流程定义ID查询
				.processDefinitionKey("helloworld")// 使用流程定义的key查询

				/** 排序 */
				.orderByProcessDefinitionVersion().asc()// 按照版本的升序排列
				// .orderByProcessDefinitionName().desc()//按照流程定义的名称降序排列

				/** 返回的结果集 */
				.list();// 返回一个集合列表，封装流程定义
		// .singleResult();//返回惟一结果集
		// .count();//返回结果集数量
		// .listPage(firstResult, maxResults);//分页查询
		if (valid.valid(list)) {
			for (ProcessDefinition prdef : list) {
				// 流程定义的key+版本+随机生成数
				System.out.println("流程定义ID:" + prdef.getId());
				// 对应helloworld.bpmn文件中的name属性值
				System.out.println("流程定义的名称:" + prdef.getName());
				// 对应helloworld.bpmn文件中的id属性值
				System.out.println("流程定义的key:" + prdef.getKey());
				// 当流程定义的key值相同的相同下，版本升级，默认1
				System.out.println("流程定义的版本:" + prdef.getVersion());
				System.out.println("资源名称bpmn文件:" + prdef.getResourceName());
				System.out.println("资源名称png文件:" + prdef.getDiagramResourceName());
				System.out.println("部署对象ID：" + prdef.getDeploymentId());
				System.out.println("#########################################################");
			}
		}
	}
}
