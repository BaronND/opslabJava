package com.opslab.workflow.framework.entity.util;

import com.opslab.workflow.framework.entity.business.ProcessDef;
import org.activiti.engine.repository.ProcessDefinition;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 0opslab
 * @date on 2016/6/8 0008.
 */
public class ProcessEntityUtil {

    /**
     * 将activiti中ProcessDefinition转换为可json话的javabean
     * @param processDefinition
     * @return
     */
    public static ProcessDef processDef(ProcessDefinition processDefinition){
        ProcessDef entity = new ProcessDef();
        entity.setId(processDefinition.getId());
        entity.setCategory(processDefinition.getCategory());
        entity.setDeploymentId(processDefinition.getDeploymentId());
        entity.setDescription(processDefinition.getDescription());
        entity.setKey(processDefinition.getKey());
        entity.setName(processDefinition.getName());
        entity.setVersion(String.valueOf(processDefinition.getVersion()));
        entity.setDiagramResourceName(processDefinition.getDiagramResourceName());
        entity.setResourceName(processDefinition.getResourceName());
        entity.setHasStartFormKey(String.valueOf(processDefinition.hasStartFormKey()));
        entity.setSuspensionState(String.valueOf(processDefinition.isSuspended()));
        return entity;
    }

    public static List<ProcessDef> processDefList(List<ProcessDefinition> list){
        List<ProcessDef> result = new ArrayList<>();
        if(list != null && list.size() > 0){
            for(ProcessDefinition p:list){
                result.add(processDef(p));
            }
        }
        return result;
    }
}
