package com.opslab.workflow.framework.action;

import com.opslab.workflow.framework.entity.business.ProcessDef;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

import static com.opslab.workflow.framework.entity.util.ProcessEntityUtil.processDefList;

/**
 * 查询流程引起相关的信息
 * @author 0opslab
 * @date on 2016/6/5 0005.
 */
@Controller
@RequestMapping("/workflow")
public class WorkFlowAction {

    @Resource(name="repositoryService")
    private RepositoryService repositoryService;

    public RepositoryService getRepositoryService() {
        return repositoryService;
    }

    public void setRepositoryService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    /**
     * 跳转到流程定义的页面
     * @return
     */
    @RequestMapping("processdef")
    public String processDefinitPage(ModelMap model){
        long count = repositoryService.createProcessDefinitionQuery()
                .latestVersion()
                .count();
        model.addAttribute("count",count);
        return "admin/workflow/processDefinitionList";
    }
    /**
     * 查询流程定义相关的信息
     * 只查询流程的最后一个版本
     * @return
     */
    @RequestMapping({"processlist/{page}/{pagesize}"})
    @ResponseBody
    public List<ProcessDef> getProcessDefinitionLsit(
            @PathVariable("page") int page,
            @PathVariable("pagesize") int pagesize
    ){
        List<ProcessDefinition> list =
                repositoryService.createProcessDefinitionQuery()
                        .orderByProcessDefinitionKey()
                        .asc()
                        .listPage(page,pagesize);
        return processDefList(list);
    }

    /**
     * 根据流程定义ID禁用流程定义
     * @param processDefinitionId
     */
    @RequestMapping("disableProcessDefinition")
    public void disableProcessDefinition(
            @RequestParam("id") String processDefinitionId) {
        repositoryService.suspendProcessDefinitionById(processDefinitionId);
    }

    /**
     * 根据流程定义ID激活流程定义
     * @param processDefinitionId
     */
    @RequestMapping("activityProcessDefinition")
    public void activityProcessDefinition(
            @RequestParam("id") String processDefinitionId
    ){
        repositoryService.activateProcessDefinitionById(processDefinitionId);
    }
}
