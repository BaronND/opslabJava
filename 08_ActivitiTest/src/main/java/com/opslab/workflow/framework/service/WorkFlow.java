package com.opslab.workflow.framework.service;

import com.google.common.base.Optional;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.runtime.Execution;

import java.util.List;

/**
 * @author 0opslab
 * @date on 2016/6/1 0001.
 * activiti相关的方法的操作
 */
public interface WorkFlow {
    /**
     * 部署流程
     * @param zipFile
     * @return
     */
    public void deployZip(String zipFile);

    /**
     * 部署流程
     * @param resources
     * @return
     */
    public void deployClasspathResource(String[] resources);

    /**
     * 判断流程是否结束
     * @param procInstId
     * @return
     */
    public boolean isEnd(String procInstId);

    /**
     * 根据流程id获取到流程当前环节
     * @param procInstId
     * @return
     */
    public String currentActivityId(String procInstId);

    /**
     * 获取执行实例
     * @param procInstId
     * @return
     */
    public ExecutionEntity getExecution(String procInstId);

    /**
     * 获取流程定义实体
     * @param procInstId
     * @return
     */
    public ProcessDefinitionEntity getProcessDefinitionEntity(String procInstId);

    /**
     * 根据流程实例ID获取到流程定义ID
     * @param procInstId
     * @return
     */
    public String getProcessDefinitionId(String procInstId);

    /**
     * 根据流程实例ID获取到流程定义KEY
     * @param procInstId
     * @return
     */
    public String getProcessDefinitionKey(String procInstId);

    /**
     * 根据流程实例ID获取流程的当前状态图
     * @param procInstId
     * @return
     */
    public String currentStatusPrice(String procInstId);

    /**
     * 获取指定流程实例ID对应的businessKey
     * @param procInstId
     * @return
     */
    public Optional<String> getProcessInstanceBusinessKey(String procInstId);

    /**
     * 获取当前流程正在执行的节点信息
     * @param procInstId
     * @return
     */
    public List<String> getCurrentActivityIds(String procInstId);
}
