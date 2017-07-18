package com.opslab.framework.base.service.impl;

import com.opslab.framework.base.entity.GeneralCode;
import com.opslab.framework.base.service.GeneralCodeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 0opslab
 * @date on 2016/6/25 0025.
 */
@Service("generalCodeService")
public class GeneralCodeServiceImpl extends SupportServiceImpl<GeneralCode, String> implements GeneralCodeService {


    @Override
    public List<GeneralCode> getGeneralList() {
        String hql = "from GeneralCode g where  g.tree='SYS_CODE'  and g.codeId <>'ROOT' order by g.orderId";
        return db.query(hql);
    }

    @Override
    public Long codeCount(String codeType) {
        String hql = "select count(*) from GeneralCode c where c.codeType=?";
        return db.count(hql,codeType);
    }


    @Override
    public List<GeneralCode> codeTypeList(String codeType) {
        String hql = "from GeneralCode g where g.codeType=?" +
                " and g.tree <> 'SYSTREE'";
        return db.query(hql, codeType);
    }

    @Override
    public List<GeneralCode> codeTypeList(String codeType, int page, int rows) {
        String hql = "from GeneralCode g where g.codeType=?" +
                " and g.tree <> 'SYSTREE' order by g.orderId asc";
        return db.queryPage(hql,page,rows,codeType);
    }

    @Override
    public GeneralCode getCodeId(String codeId){
        String hql = "from GeneralCode g where g.codeId=?";
        return (GeneralCode) db.queryFirst(hql,codeId);
    }

    @Override
    public void delete(String id) {
        String hql = "update GeneralCode t set t.valid='0' where t.id=?";
        db.execute(hql,id);
    }

    @Override
    public void activate(String id) {
        String hql = "update GeneralCode t set t.valid='1' where t.id=?";
        db.execute(hql,id);
    }

}
