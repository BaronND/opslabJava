package com.opslab.workflow.framework.wokflow;

import com.opslab.workflow.ActivitiTest;
import com.opslab.workflow.util.JacksonUtil;
import org.activiti.engine.repository.ProcessDefinition;
import org.junit.Test;

import java.util.List;

/**
 * @author 0opslab
 * @date on 2016/6/5 0005.
 */
public class QueryProcessDefinition extends ActivitiTest{

    /**
     * 查询所有部署的流程信息
     */
    @Test
    public void queryProcessDefinitiontoJSON(){
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery()
                .orderByProcessDefinitionVersion().desc()
                .list();
        System.out.println(list.size());
        System.out.println(JacksonUtil.toJSON(list));
    }
}
