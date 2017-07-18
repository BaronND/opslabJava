package com.opslab.workflow.framework.wokflow.FlowBean;

import com.opslab.workflow.util.JacksonUtil;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;

import java.io.Serializable;
import java.util.Set;

/**
 * @author 0opslab
 * @date on 2016/6/19 0019.
 */
public class MyBean implements Serializable {
    public void print(){
        System.out.println("print content");
    }

    public String print(String name){
        System.out.println("print name:"+name);
        return  "new name:"+name;
    }

    public void invokeTask(DelegateTask task){
        task.setVariable("setTaskVariable","在Bean中添加task变量"+task.getName());
        Set<String> variableNames = task.getVariableNames();
        System.out.println("task-variableNames:"+JacksonUtil.toJSON(variableNames));
    }

    public String printBusinessKey(DelegateExecution execution){
        Set<String> variableNames = execution.getVariableNames();
        System.out.println("execution-variableNames"+JacksonUtil.toJSON(variableNames));
        return execution.getProcessBusinessKey();
    }
}
