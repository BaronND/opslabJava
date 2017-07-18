package com.opslab.workflow.framework.dao.util;

import org.junit.Test;

import com.opslab.RegUtil;

/**
 * @author 0opslab
 */
public class HibernateUtilTest {

    @Test
    public void testToCount() throws Exception {
        String hql1 ="select mate \n" +
                "from Cat as cat \n" +
                "    inner join cat.mate as mate";
        System.out.println(HibernateUtil.toCount(hql1));

        String hql2 ="from Cat";
        System.out.println(HibernateUtil.toCount(hql2));

        String hql3 ="select distinct r from Recommendation r ";
        System.out.println(RegUtil.isMatche(hql3, "\\s+distinct\\s+"));
        System.out.println(HibernateUtil.toCount(hql3));

        String hql4 ="select distinct r from Recommendation r where r.id in " +
                "(select distinct id from CommonGenerate t where t. code='xxx')";
        System.out.println(HibernateUtil.toCount(hql4));
    }
}