package com.opslab.workflow.workflow.listener.ProcessListener;

import com.opslab.workflow.util.DateUtil;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 0opslab
 * @date on 2016/6/19 0019.
 *
 * 流程启动监听器
 */
public class ProcessStartExecutionListener implements ExecutionListener,Serializable {
    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {
        String processId = delegateExecution.getProcessInstanceId();
        String processDefId = delegateExecution.getProcessDefinitionId();
        delegateExecution.setVariable("ProcessStartTime", DateUtil.getDateTime(new Date()));
        System.out.println("流程启动:"+processDefId+"/"+processId);
    }
}
