package com.opslab.workflow.framework.service;

import com.opslab.workflow.SpringTest;
import com.opslab.workflow.util.JacksonUtil;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.junit.Test;

import java.util.List;

import static com.opslab.workflow.framework.entity.util.ProcessEntityUtil.processDefList;

/**
 * @author 0opslab
 * @date on 2016/6/18 0018.
 */
public class ActivitiServiceTest extends SpringTest {
    private RepositoryService repositoryService;

    @Override
    public void before() {
        super.before();
        repositoryService = (RepositoryService) Context.getBean("repositoryService");
    }
    
    @Test
    public void testProcessDeftinion(){
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery()
                .orderByProcessDefinitionKey()
                .asc()
                .latestVersion()
                .listPage(1, 20);
        String json  = JacksonUtil.toJSON(processDefList(list));
        System.out.println(json);
    }
}
