package com.opslab.framework.base.service.impl;

import com.opslab.framework.base.dao.DBUtil;
import com.opslab.framework.base.entity.view.UiCode;
import com.opslab.framework.base.service.CodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 通用的编码相关的方法
 */
@Service("codeService")
public class CodeServiceImpl implements CodeService {
    @Resource(name="dbUtils")
    private DBUtil db;

    @Override
    public List<UiCode> codeMap(String codeType) {
        String sql ="select code_id id,code_name as text,order_Id orderId from ops_re_generalcode " +
                "t where t.code_type=? order by t.order_Id asc";
        return db.find(UiCode.class,sql,codeType);
    }
}
