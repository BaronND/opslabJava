package com.opslab.crm.admin.service;

import com.opslab.crm.admin.APP;
import com.opslab.crm.admin.SuperServiceTest;
import com.opslab.crm.admin.domain.DepartmentInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 0opslab
 * @descript 请添加说明
 */
public class IDepartmentInfoServiceTest extends SuperServiceTest {
    @Autowired
    private IDepartmentInfoService service;

    @Test
    public void count() throws Exception {
        System.out.println(service.count());
    }

    @Test
    public void list() throws Exception {
        List<DepartmentInfo> list = service.list(null);
        print(list);
    }

    @Test
    public void updateStatus() throws Exception {

    }

    @Test
    public void save() throws Exception {
        String deptName = "青海省公司";
        DepartmentInfo departmentInfo = new DepartmentInfo(deptName,
                100001, APP.TREE_TYPE_BRANCH, APP.STATUS_VALID, deptName);
        service.save(departmentInfo);
    }

    @Test
    public void department() throws Exception {
        DepartmentInfo dept = service.department(100001);
        print(dept);
    }

}