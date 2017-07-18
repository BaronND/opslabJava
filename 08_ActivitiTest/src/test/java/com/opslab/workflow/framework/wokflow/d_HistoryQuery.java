package com.opslab.workflow.framework.wokflow;

import org.activiti.engine.history.HistoricProcessInstance;
import org.junit.Test;

import com.opslab.workflow.ActivitiTest;
import com.opslab.workflow.util.JacksonUtil;

public class d_HistoryQuery extends ActivitiTest{

	@Test
	public void queryHistory(){
		String processInstanceId="7501";
		HistoricProcessInstance processInstance = historyService.createHistoricProcessInstanceQuery()
			.processInstanceId(processInstanceId)
			//.list();
			.singleResult();
		System.out.println("流程ID:"+processInstance.getId());
		System.out.println("流程定义ID:"+
				processInstance.getProcessDefinitionId());

		System.out.println("流程信息:"+JacksonUtil.toJSON(processInstance));
	}
}
