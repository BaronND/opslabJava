package com.opslab.workflow.workflow.test;

import com.opslab.workflow.ActivitiTest;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 0opslab
 * @date on 2016/6/19 0019.
 */
public class ProcessListenerTest extends ActivitiTest{

    @Test
    public void deploy(){
        workFlow.deployClasspathResource(new String[]{"flow/ProcessListener.bpmn"});
    }

    @Test
    public void testListener(){
        Map<String,Object> variables = new HashMap<>();
        variables.put("dealUser","李四");

        String bussinessKey = "ProcessListener";
        ProcessInstance processInstance =
                runtimeService.startProcessInstanceByKey(bussinessKey, variables);

        //在任务监听器上已经将任务重新分配给了hello3
        String processId = processInstance.getId();
        Task task =
                taskService.createTaskQuery().
                        processInstanceId(processId).taskAssignee("hello3")
                        .singleResult();

        //获取task上的变量
        String setInTaskCreate =
                (String) taskService.getVariable(task.getId(),"setInTaskCreate");
        System.out.println("任务上绑定的变量"+setInTaskCreate);


        List<String> currentActivityIds = workFlow.getCurrentActivityIds(processId);
        System.out.println("流程当前状态:"+ Arrays.toString(currentActivityIds.toArray()));

        //重新分配任务
        //task.setAssignee("李四");

        //完成任务
        taskService.complete(task.getId());

        //流程结束后查询流程变量
        List<HistoricVariableInstance> list = historyService.createHistoricVariableInstanceQuery()
                .processInstanceId(processId).list();
        for(HistoricVariableInstance  instance:list){
            String temp  = instance.getTaskId()+":"+
                    instance.getVariableName()+":"+instance.getValue();
            System.out.println(temp);
        }
    }

}
