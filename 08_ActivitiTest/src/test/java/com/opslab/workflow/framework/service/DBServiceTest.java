package com.opslab.workflow.framework.service;

import java.util.List;
import java.util.Map;

import com.opslab.workflow.util.JacksonUtil;
import org.junit.Test;

import com.opslab.workflow.SpringTest;
import com.opslab.workflow.framework.dao.util.SQLType;
import com.opslab.workflow.framework.entity.TestBean;

/**
 * 测试dbservice
 */
public class DBServiceTest extends SpringTest {
    private DBService dbService;

    @Override
    public void before() {
        super.before();
        dbService = (DBService) Context.getBean("dbService");
    }

    @Test
    public void testSelectCount() throws Exception {
        String hql ="select count(*) from tbl_hbm_rigths";
        int count = dbService.count(hql, SQLType.COUNT_SQL);
        System.out.println("sql count:"+String.valueOf(count));

        String paramsSql ="select count(*) from tbl_hbm_rigths t where t.rigths_code =?";
        count = dbService.count(paramsSql,SQLType.COUNT_SQL,"1");
        System.out.println("sql count:"+String.valueOf(count));

        paramsSql ="select count(*) from tbl_hbm_rigths t where t.rigths_code =?" +
                " and t.rigths_group =? ";
        count = dbService.count(paramsSql,SQLType.COUNT_SQL,"1","2");
        System.out.println("sql count:"+String.valueOf(count));

        String sql ="SELECT t.`address`,t.`group_id` FROM tbl_hbm_rigths t";
        System.out.println(dbService.count(sql,SQLType.SQL));

        //带参数的SQL测试
        sql ="SELECT * FROM tbl_hbm_rigths t WHERE t.group_id=?  order by group_id  desc";
        System.out.println(dbService.count(sql,SQLType.SQL,"1"));
    }

    @Test
    public void testUpdate(){
        //insert语句尽量还是使用参数化的方式
        String insert ="insert into test(id,name,address,year) values(?,?,?,?)";
        dbService.update(insert,1,"test1","sky",new java.util.Date());

    }

    @Test
    public void testBatchUpdate(){
        //批量更新
        //insert语句尽量还是使用参数化的方式
        String insert ="insert into test(id,name,address,year) values(?,?,?,?)";
        Object[][] params =new Object[][]{
                {1,"test1","sea",new java.util.Date()},
                {2,"test2","sea",new java.util.Date()},
                {3,"test3","sea",new java.util.Date()},
                {4,"test4","sea",new java.util.Date()}
        };
        dbService.batchUpdate(insert,params);
    }


    @Test
    public void testListMap(){
        String select ="select * from test";
        List<Map<String, Object>> maps = dbService.find(select);
        System.out.println(JacksonUtil.toJSON(maps));
    }

    @Test
    public void  testListBean(){
        String select ="select * from test";
        List<TestBean> beanList = dbService.find(TestBean.class, select);
        System.out.println(JacksonUtil.toJSON(beanList));
    }

    @Test
    public void testListColumn(){
        String select ="select address from test";
        List<String> address = dbService.findColumn(String.class, select, "address");
        System.out.println(JacksonUtil.toJSON(address));
    }

    @Test
    public void testListArray(){
        String select = "select * from test";
        List<Object[]> arrayList = dbService.findArrayList(select);
        System.out.println(JacksonUtil.toJSON(arrayList));
    }

}