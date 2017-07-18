package com.opslab.workflow.framework.service;

import java.util.List;

import com.opslab.workflow.util.JacksonUtil;
import org.junit.Test;

import com.opslab.workflow.SpringTest;
import com.opslab.workflow.framework.entity.Page;
import com.opslab.workflow.framework.entity.business.Rights;

/**
 * @author 0opslab
 */
public class RightsServiceTest extends SpringTest{
    private RightsService service;

    @Override
    public void before() {
        super.before();
        service = (RightsService) Context.getBean("rightsService");
    }

    @Test
    public void testSave() throws Exception {
        Rights rights = new Rights();
        rights.setRightsId(111);
        rights.setRightsCode(0001L);
        rights.setRightsGroup(1);
        rights.setRightsName("teet");
        service.save(rights);
    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testSaveOrUpdate() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testDeleteById() throws Exception {

    }

    @Test
    public void testDeleteAll() throws Exception {

    }

    @Test
    public void testLoad() throws Exception {

    }

    @Test
    public void testGet() throws Exception {

    }

    @Test
    public void testCount() throws Exception {

    }

    @Test
    public void testCountCommon() throws Exception {
        String hql ="from Rights t";
        System.out.println(service.countCommon(hql));
    }

    @Test
    public void testQuery() throws Exception {

    }

    @Test
    public void testQueryFirst() throws Exception {

    }

    @Test
    public void testQueryLast() throws Exception {
        String hql = "from Rights";
        List<Rights> rightsList = service.query(hql);
        System.out.println(JacksonUtil.toJSON(rightsList));
    }

    @Test
    public void testPage() throws Exception {
        String hql = "from Rights";
        Page page = service.page(hql, 1, 30);
        System.out.println(JacksonUtil.toJSON(page));
    }
}