package app.dao.util;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.hql.internal.ast.QueryTranslatorImpl;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository("dataSetUtil")
public class DataSetUtil {
    @Resource(name = "hibernateTemplate")
    @Getter
    @Setter
    private HibernateTemplate hibernateTemplate;


    /**
     * @function:利用Hibernate的HQL分装一个自定义的List并返回前台UITree可以解析的JSON数据返回
     */
    public List<?> getList(String nameQunery) {
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        Query query = session.getNamedQuery(nameQunery);
        List<?> list = query.list();
        return list;
    }


}
