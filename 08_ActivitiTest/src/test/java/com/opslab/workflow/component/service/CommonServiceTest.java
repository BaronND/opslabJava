package com.opslab.workflow.component.service;

import java.util.List;

import org.junit.Test;

import com.opslab.workflow.SpringTest;
import com.opslab.workflow.component.common.service.CommonService;
import com.opslab.workflow.framework.entity.view.UiPTree;
	
/**
 * @author 0opslab
 * @date on 2016/4/21 0021.
 */
public class CommonServiceTest extends SpringTest {
    @Test
    public void testgetDeptListWithChild(){
        CommonService commonService = (CommonService) Context.getBean("commonService");
        List<UiPTree> deptListWithChild = commonService.getDeptListWithChild();
        System.out.println(deptListWithChild);
    }

}