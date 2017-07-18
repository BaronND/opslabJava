package com.opslab.workflow.framework.service.impl;

import com.google.common.base.Optional;
import com.opslab.workflow.framework.service.WorkFlow;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;
import org.springframework.util.FileCopyUtils;

/**
 * @author 0opslab
 * @date on 2016/6/1 0001.
 * Activiti相关方法的操作
 */

public class WorkFlowImpl implements WorkFlow {
    private static Logger logger = Logger.getLogger(WorkFlowImpl.class);

    private ProcessEngine processEngine;

    private RepositoryService repositoryService;

    private RuntimeService runtimeService;

    private TaskService taskService;

    private FormService formService;

    private HistoryService historyService;

    private ManagementService managementService;

    private IdentityService identityService;

    public ProcessEngine getProcessEngine() {
        return processEngine;
    }

    public void setProcessEngine(ProcessEngine processEngine) {
        this.processEngine = processEngine;
    }

    public RepositoryService getRepositoryService() {
        return repositoryService;
    }

    public void setRepositoryService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    public RuntimeService getRuntimeService() {
        return runtimeService;
    }

    public void setRuntimeService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public TaskService getTaskService() {
        return taskService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    public FormService getFormService() {
        return formService;
    }

    public void setFormService(FormService formService) {
        this.formService = formService;
    }

    public HistoryService getHistoryService() {
        return historyService;
    }

    public void setHistoryService(HistoryService historyService) {
        this.historyService = historyService;
    }

    public ManagementService getManagementService() {
        return managementService;
    }

    public void setManagementService(ManagementService managementService) {
        this.managementService = managementService;
    }

    public IdentityService getIdentityService() {
        return identityService;
    }

    public void setIdentityService(IdentityService identityService) {
        this.identityService = identityService;
    }


    @Override
    public void deployZip(String zipFile) {
        if((new File(zipFile)).exists()){
            InputStream inputStream = this.getClass().getClassLoader()
                    .getResourceAsStream(zipFile);
            Deployment deploy = repositoryService.createDeployment()
                    .addZipInputStream(new ZipInputStream(inputStream))
                    .deploy();
            logger.debug("deploy workflow:deptId"+deploy.getId()
                    +":deployName"+deploy.getName());
        }
    }

    @Override
    public void deployClasspathResource(String[] resources) {
        if(resources != null && resources.length > 0){
            DeploymentBuilder createDeployment = repositoryService.createDeployment();
            for(String str:resources){
                createDeployment.addClasspathResource(str);
            }
            Deployment deploy = createDeployment.deploy();
            logger.debug("deploy workflow:deptId"+deploy.getId()
                    +":deployName"+deploy.getName());
        }

    }

    @Override
    public boolean isEnd(String procInstId) {
        HistoricProcessInstance historicProcessInstance =
                historyService.createHistoricProcessInstanceQuery()
                        .processInstanceId(procInstId).singleResult();
        if (historicProcessInstance != null
                && historicProcessInstance.getStartTime() != null
                && historicProcessInstance.getEndTime() != null) {
            return true;
        }
        return false;
    }

    @Override
    public String currentActivityId(String procInstId) {
        ExecutionEntity execution = getExecution(procInstId);
        return execution.getActivityId();
    }

    @Override
    public ExecutionEntity getExecution(String procInstId) {
        ExecutionEntity execution = (ExecutionEntity) runtimeService
                .createProcessInstanceQuery().processInstanceId(procInstId)
                .singleResult();
        return execution;
    }

    @Override
    public ProcessDefinitionEntity getProcessDefinitionEntity(String procInstId) {
        String processDefinitionId = getProcessDefinitionId(procInstId);
        return (ProcessDefinitionEntity) repositoryService
                .getProcessDefinition(processDefinitionId);
    }

    @Override
    public String getProcessDefinitionId(String procInstId) {
        String processDefinitionId = historyService
                .createHistoricProcessInstanceQuery()
                .processInstanceId(procInstId).singleResult()
                .getProcessDefinitionId();
        return processDefinitionId;
    }

    public String getProcessDefinitionKey(String procInstId){
        String processDefinitionId  = getProcessDefinitionId(procInstId);
        String processDefinitionKey = repositoryService.createProcessDefinitionQuery()
                .processDefinitionId(processDefinitionId)
                .singleResult().getKey();
        return processDefinitionKey;
    }

    @Override
    public String currentStatusPrice(String procInstId) {

        ProcessInstance processInstance = runtimeService
                .createProcessInstanceQuery()
                .processInstanceId(procInstId)
                .singleResult();
        BpmnModel bpmnModel =
                repositoryService.getBpmnModel(processInstance.getProcessDefinitionId());


        List<Execution> executions = runtimeService.createExecutionQuery()
                .processInstanceId(processInstance.getId()).list();
        //正在活动的activity的id
        List<String> activeIds = new ArrayList<String>();
        for (Execution exe : executions) {
            List<String> list = runtimeService.getActiveActivityIds(exe.getId());
            activeIds.addAll(list);
        }
        //结束的activity的id
        List<HistoricActivityInstance> historicActivityInstances = historyService.createHistoricActivityInstanceQuery().finished().processInstanceId(processInstance.getId()).list();
        List<String> historyIds = new ArrayList<String>();
        for (HistoricActivityInstance historicActivityInstance : historicActivityInstances) {
            historyIds.add(historicActivityInstance.getActivityId());
        }
        historyIds.removeAll(activeIds);

        org.activiti.image.ProcessDiagramGenerator processDiagramGenerator
                = processEngine.getProcessEngineConfiguration().getProcessDiagramGenerator();


        InputStream in = processDiagramGenerator.generateDiagram(bpmnModel, "png", activeIds, historyIds);
        try {
            FileCopyUtils.copy(in, new FileOutputStream(new File(procInstId+".png")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<String> getProcessInstanceBusinessKey(String procInstId){
        Assert.hasText(procInstId, "流程实例ID不能为空");
        // 首先判断是否为正在运行的实例
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processInstanceId(procInstId).singleResult();
        if (processInstance != null) {
            return Optional.of(processInstance.getBusinessKey());
        }
        // 然后判断是否为已结束的实例
        HistoricProcessInstance historicProcessInstance = processEngine.getHistoryService()
                .createHistoricProcessInstanceQuery().processInstanceId(procInstId).singleResult();
        if (historicProcessInstance != null) {
            return Optional.of(historicProcessInstance.getBusinessKey());
        }
        return Optional.absent();
    }

    public List<String> getCurrentActivityIds(String procInstId){
        List<String> result= new ArrayList<>();
        List<Execution> list =
                runtimeService.createExecutionQuery().processInstanceId(procInstId).list();
        if(list != null && list.size() > 0){
            for(Execution execution:list){
                List<String> activeActivityIds = runtimeService.getActiveActivityIds(execution.getId());
                result.addAll(activeActivityIds);
            }
        }
        return result;
    }
}
