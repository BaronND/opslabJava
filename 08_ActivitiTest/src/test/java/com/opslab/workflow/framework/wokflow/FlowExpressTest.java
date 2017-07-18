package com.opslab.workflow.framework.wokflow;

import com.opslab.workflow.ActivitiTest;
import com.opslab.workflow.framework.wokflow.FlowBean.MyBean;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 0opslab
 * @date on 2016/6/19 0019.
 * 测试流程表达式
 */
public class FlowExpressTest extends ActivitiTest {

    @Test
    public void deploy(){
        workFlow.deployClasspathResource(new String[] {"flow/FlowExpress.bpmn"});
    }


    @Test

    public void testExpress() {

        //启动流程的变量
        Map<String, Object> variables = new HashMap<String, Object>();

        //创建myBean对象(流程表达式中需要)
        MyBean myBean = new MyBean();
        variables.put("myBean", myBean);

        String name = "流程变量name";
        variables.put("name", name);

        //设置流程启动人Id
        identityService.setAuthenticatedUserId("流程启动人ID");
        String businessKey = "流程KEY";

        //启动流程
        ProcessInstance processInstance =
                runtimeService.startProcessInstanceByKey("FlowExpress", businessKey, variables);

        String processId = processInstance.getId();
        System.out.println("流程启动成功:"+processId);
        //获取流程启动人
        System.out.println("获取流程启动人:"+runtimeService.getVariable(processId, "authenticatedUserIdForTest"));

        //获取表达式的值
        System.out.println("获取表达式的值:"+runtimeService.getVariable(processId, "returnValue"));

        //获取流程bean计算后的结果值
        System.out.println("获取流程bean计算后的结果值:"+runtimeService.getVariable(processId, "businessKey"));

        //获取task设在的变量
        Task task = taskService.createTaskQuery().processInstanceId(processId).singleResult();
        String setTaskVariable = (String) taskService.getVariable(task.getId(), "setTaskVariable");
        System.out.println("获取task设在的变量:"+setTaskVariable);

        workFlow.currentStatusPrice(processId);
    }
}
