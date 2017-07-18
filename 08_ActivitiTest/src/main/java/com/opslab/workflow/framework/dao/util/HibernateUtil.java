package com.opslab.workflow.framework.dao.util;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.internal.ast.QueryTranslatorImpl;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.stereotype.Repository;

import com.opslab.RegUtil;


@Repository("hibernateUtil")
@SuppressWarnings({"unused","rawtypes"})
public class HibernateUtil {
    @Resource(name = "sessionFactory")
    private  SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	private Session session() {
        return sessionFactory.getCurrentSession();
    }


    /**
     * 将hql语句转换为sql语句,无参数
     *
     * @param hql 要转换的hql语句
     * @return 可执行的sql语句
     */
    public  String transHqlToSql(String hql) {
        // 当hql为null或空时,直接返回null
        if (hql == null || hql.equals("")) {
            return "";
        }
        // 获取当前session
        // 得到session工厂实现类
        SessionFactoryImpl sfi = (SessionFactoryImpl) sessionFactory;
        // 得到Query转换器实现类
        QueryTranslatorImpl queryTranslator = new QueryTranslatorImpl(hql, hql, Collections.EMPTY_MAP, sfi);
        queryTranslator.compile(Collections.EMPTY_MAP, false);
        // 得到sql
        String sql = queryTranslator.getSQLString();
        return sql;
    }

    /**
     * 将hql语句转换为sql语句,不需要格式化参数的情况
     *
     * @param hql         要转换的hql语句
     * @param paramValues hql参数值列表,注意与参数的顺序一致
     * @return 可执行的sql语句,
     */
    public  String transHqlToSql(String hql,  List paramValues) {
        // 要返回的sql语句
        String sql = transHqlToSql(hql);
        // 当为null或空时,返回null
        if (sql == null || sql.equals("")) {
            return null;
        }
        // 赋参数值
        if (paramValues != null && paramValues.size() > 0) {
            for (int i = 0; i < paramValues.size(); i++) {
                sql = sql.replaceFirst("\\?", "\\'" + paramValues.get(i).toString() + "\\'");
            }
        }
        return sql;
    }

    /**
     * 将普通查询类型的HQL语句转换为Count语句
     * @param hql
     * @return
     */
    public static String toCount(String hql) throws IOException{
        //将任何SELECT类型的HQL语句中的select xx FROM 或者 FROM 直接替换成 SELECT COUNT(*)即可
        //实现将普通的查询类型的HQL转换为统计的HQL语句 注意是第一个FROM
        hql = hql.replaceAll("\\r|\\n", "");

        Pattern pattern = Pattern.compile("(^from\\s+)|(\\s+from\\s+)",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hql);
        if (matcher.find()) {
            String from = matcher.group();
            if(from.toLowerCase().contains("from")){
                int index = hql.indexOf("from");
                String head = hql.substring(0,index);
                if(RegUtil.countSubStrReg(head,"\\s+(?i)distinct\\s+") >0){
                    //含有distinct必定含有select
                    return "select count("+hql.substring(6,index)+") "+
                            hql.substring(index,hql.length());
                }else{
                    return "select count(*) "+ hql.substring(index,hql.length());
                }

            }
            System.out.println(from);
        }
        throw new IOException("解析HQL语句失败");
    }
}
