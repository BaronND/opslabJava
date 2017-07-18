package app.dao.util;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.SessionFactory;
import org.hibernate.hql.internal.ast.QueryTranslatorImpl;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;


@Repository("hibernateUtil")
public class HibernateUtil {
    @Resource(name = "sessionFactory")
    @Getter
    @Setter
    private  SessionFactory sessionFactory;

    /**
     * 将hql语句转换为sql语句,无参数
     *
     * @param hql 要转换的hql语句
     * @return 可执行的sql语句, 当返回null, 可以通过getResultMsg()方法查看处理结果信息
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
     * @return 可执行的sql语句, 当返回null, 可以通过getResultMsg()方法查看处理结果信息
     */
    public  String transHqlToSql(String hql, List paramValues) {
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
}
