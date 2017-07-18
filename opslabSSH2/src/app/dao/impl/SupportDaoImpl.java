package app.dao.impl;

import app.dao.SupportDao;
import app.dao.util.HibernateUtil;
import app.entries.EntryPage;
import app.exception.DataAccessException;
import evilp0s.ValidUtil;
import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * ***************************************************************
 *
 * @summary: 用于完成DAO操作的抽象基类，主要用于继承
 * ****************************************************************
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public abstract class SupportDaoImpl<T> implements SupportDao<T> {

    @Resource(name = "hibernateTemplate")
    @Getter
    @Setter
    private HibernateTemplate hibernateTemplate;

    @Resource(name = "hibernateUtil")
    @Getter
    @Setter
    private HibernateUtil hibernateUtil;

    private Logger log = Logger.getLogger(this.getClass());


    // 构造时初始（获取泛型）
    private Class<T> clazz;

    public SupportDaoImpl() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class<T>) type.getActualTypeArguments()[0];
    }

    public void saveEntry(T t) throws DataAccessException {
        try {
            hibernateTemplate.save(t);
        } catch (org.springframework.dao.DataAccessException ex) {
            log.error("实体保存异常:" + ex.getMessage(), ex);
            throw new DataAccessException("实体保存异常:" + ex.getMessage(), ex);
        }
    }

    public void updateEntry(T t) {
        try {
            hibernateTemplate.update(t);
        } catch (org.springframework.dao.DataAccessException ex) {
            throw new DataAccessException("实体更新异常" + ex.getMessage(), ex);
        }
    }

    public void saveOrUpdateEntry(T t) {
        try {
            hibernateTemplate.saveOrUpdate(t);
        } catch (org.springframework.dao.DataAccessException ex) {
            throw new DataAccessException("实体保存或更新异常" + ex.getMessage(), ex);
        }
    }

    public int batchByHQL(String hql, Object... objects) {
        List<T> list = new ArrayList<>();
        try {
            list = (List<T>) hibernateTemplate.find(hql, objects);
        } catch (org.springframework.dao.DataAccessException ex) {
            throw new DataAccessException("实体查询异常HQL->" + hql, ex);
        }
        return list.size();
    }

    public void deleteEntryById(T t) {
        try {
            hibernateTemplate.delete(t);
        } catch (org.springframework.dao.DataAccessException ex) {
            throw new DataAccessException("删除实体异常->", ex);
        }
    }

    public T loadEntry(Integer id) {
        try {
            return hibernateTemplate.load(clazz, id);
        } catch (org.springframework.dao.DataAccessException ex) {
            throw new DataAccessException("加载实体异常", ex);
        }
    }

    public T getEntry(Integer id) {
        try {
            return hibernateTemplate.get(clazz, id);
        } catch (org.springframework.dao.DataAccessException ex) {
            throw new DataAccessException("加载实体异常", ex);
        }
    }

    public List<T> getEntryListByHQL(String hql, Object... objects) {
        List<T> list = new ArrayList<>();
        try {
            list = (List<T>) hibernateTemplate.find(hql, objects);
        } catch (org.springframework.dao.DataAccessException ex) {
            throw new DataAccessException("加载实体异常->HQL" + hql, ex);
        }
        return list;
    }

    public List<T> getEntryListBySQL(String sql, Object... objects) {
        List<T> list = new ArrayList<>();
        try {
            // 如果没有开启事务管理，在线程中不允许获取session
            SQLQuery q = hibernateTemplate.getSessionFactory().getCurrentSession().createSQLQuery(sql);
            // 添加实体类
            if (clazz != null) {
                q.addEntity(clazz);
            }
            for (int i = 0; i < objects.length; i++) {
                q.setParameter(i, objects[i]);
            }
            list = q.list();
        } catch (HibernateException ex) {
            throw new DataAccessException("数据加载异常SQL->" + sql);
        }
        return list;
    }

    @Override
    public List<T> findEntityByHQL(String hql, Object[] objects) {
        try {
            return (List<T>) hibernateTemplate.find(hql, objects);
        } catch (org.springframework.dao.DataAccessException ex) {
            throw new DataAccessException("数据加载异常SQL->" + hql);
        }
    }

    @Override
    public int batchEntryByHQL(String hql, Object... objects) {
        List<T> list = (List<T>) hibernateTemplate.find(hql, objects);
        return list.size();
    }

    /**
     * page默认值为1. 从第一页开始 size默认值为100,每页100条记录
     */
    public EntryPage query(final String hql, int page, final int size) {
        final EntryPage pageInfo = new EntryPage();
        pageInfo.setPageSize(size);
        pageInfo.setCurrentPage(page);
        pageInfo.init();
        try {
            pageInfo.setAllRow(count(hql));
            List<Object> list = (List<Object>) getHibernateTemplate().execute(new HibernateCallback() {
                public Object doInHibernate(Session session) throws HibernateException {
                    Query query = session.createQuery(hql);
                    query.setFirstResult(pageInfo.getOffset());
                    query.setMaxResults(size);
                    List list = query.list();
                    return list;
                }
            });
            pageInfo.setList(list);
        } catch (org.springframework.dao.DataAccessException ex) {
            throw new DataAccessException("分页查询异常(" + page + "," + size + ")->hql" + hql, ex);
        }
        pageInfo.init();
        return pageInfo;
    }

    @Override
    public T queryEntry(final String hql) {
        List<Object> list = (List<Object>) getHibernateTemplate().execute(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(hql);
                query.setFirstResult(0);
                query.setMaxResults(1);
                List list = query.list();
                return list;
            }
        });
        return (T) list.get(0);
    }

    @Override
    /**
     * 此处使用HQL的特性 将HQL语句拼接成SELECT COUNT(*) FROM的形式
     * 因此只支持select不支持delete
     */
    public int count(String hql) throws DataAccessException {
        final String sql = "select count(0) from (" + hibernateUtil.transHqlToSql(hql) + ") t";
        int count;
        try {
            count = (int) getHibernateTemplate().execute(new HibernateCallback() {
                public Object doInHibernate(Session session) throws HibernateException {
                    Query query = session.createSQLQuery(sql);
                    return ((Number) query.uniqueResult()).intValue();
                }
            });
        } catch (RuntimeException ex) {
            throw new DataAccessException("统计异常->HQL" + sql, ex);
        }
        return count;
    }

    @Override
    public int count(String hql, Object... objects) throws DataAccessException {
        int count = 0;
        String temp_hql = "select count(1) from(" + hql + ")";
        try {
            List list = hibernateTemplate.find(temp_hql, objects);
            if (ValidUtil.isValid(list)) {
                count = Integer.valueOf((String) list.get(0));
            }
        } catch (RuntimeException ex) {
            throw new DataAccessException("统计异常->HQL" + temp_hql, ex);
        }
        return count;
    }
}
