package com.opslab.workflow.workflow.listener.ProcessListener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.Expression;

/**
 * @author 0opslab
 * @date on 2016/6/19 0019.
 *
 * 当创建用户任务时调用
 */
public class UserCreateListener  implements org.activiti.engine.delegate.TaskListener{
    //下面俩个变量activiti根据bpmn文件的配置自动注入
    private Expression dealUser;
    private Expression task;

    @Override
    public void notify(DelegateTask delegateTask) {
        task.getValue(delegateTask);
        delegateTask.setVariable("setInTaskCreate",delegateTask.getEventName()+","
            + dealUser.getValue(delegateTask));

        //重新分配人为某人
        delegateTask.setAssignee("hello3");
    }
}
