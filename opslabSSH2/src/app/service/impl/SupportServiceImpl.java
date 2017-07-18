package app.service.impl;

import app.dao.SupportDao;
import app.entries.EntryPage;
import app.service.SupportService;
import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class SupportServiceImpl<T> implements SupportService<T> {

    public Logger log = Logger.getLogger(this.getClass());

    // 构造时初始（获取泛型）
    private Class<T> clazz;

    public SupportServiceImpl() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class<T>) type.getActualTypeArguments()[0];
    }

    @Autowired @Getter @Setter private SupportDao<T> supportDao;


    @Override
    public void save(T t) {
        supportDao.saveEntry(t);
    }

    @Override
    public void update(T t) {
        supportDao.updateEntry(t);
    }

    @Override
    public void saveOrUpdate(T t) {
        supportDao.saveOrUpdateEntry(t);
    }

    @Override
    public int batchByHQL(String hql, Object... objects) {
        return supportDao.batchEntryByHQL(
                hql,
                objects);
    }

    @Override
    public void delete(T t) {
        supportDao.deleteEntryById(t);
    }

    @Override
    public T load(Integer id) {
        return (T) supportDao.loadEntry(id);
    }

    @Override
    public T load(String id) {
        return (T) supportDao.loadEntry(Integer.valueOf(id));
    }

    @Override
    public T get(Integer id) {
        return (T) supportDao.getEntry(id);
    }

    @Override
    public T get(String id){
            return (T) supportDao.getEntry(Integer.valueOf(id));
    }
    @Override
    public List<T> getListByHQL(String hql, Object... objects) {
        return supportDao.getEntryListByHQL(
                hql,
                objects);
    }

    @Override
    public List<T> getListBySQL(String sql, Object... objects) {
        return supportDao.getEntryListBySQL(
                sql,
                objects);
    }

    @Override
    public List<T> findByHQL(String hql, Object... objects) {
        return supportDao.findEntityByHQL(
                hql,
                objects);
    }

    @Override
    public EntryPage query(final String hql, int page, final int size) {
        return supportDao.query(hql, page,size);
    }

    @Override
    public EntryPage getPage(int page, int size) {
        String hql = "from " + clazz + " where 1=1";
        return supportDao.query(hql, page, size);
    }

}
