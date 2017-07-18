package com.opslab.workflow.workflow.listener.ProcessListener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

import java.io.Serializable;

/**
 * @author 0opslab
 * @date on 2016/6/19 0019.
 * 当任务分配时调用
 */
public class UserTaskAssgineeListener implements TaskListener,Serializable{
    @Override
    public void notify(DelegateTask delegateTask) {
        System.out.println("任务分配给:"+delegateTask.getAssignee()
            +"、此处可以实现短信，邮件，等方式的通知相应的处理人");
    }
}
