package com.opslab.imagemanager.service.impl;

import com.google.common.collect.ImmutableMap;
import com.opslab.imagemanager.domain.GeneralCode;
import com.opslab.imagemanager.service.GeneralCodeService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 0opslab
 * @descript 编码管理操作接口实现
 */
@Service
public class GeneralCodeServiceImpl extends SuperServiceImpl implements GeneralCodeService{

    private  static Logger logger = LogManager.getLogger(GeneralCodeServiceImpl.class);

    private static String PACKAGE_NAME = "com.opslab.imagemanager.domain.GeneralCode.";

    @Override
    public List<GeneralCode> codeType(String type, String valid) {
        ImmutableMap<Object, Object> params =
                ImmutableMap.builder()
                        .put("codeType", type)
                        .put("valid",valid)
                        .build();
        return session.selectList(PACKAGE_NAME+"select",params);
    }

    @Override
    public List<GeneralCode> codeTypeAll(String type) {
        ImmutableMap<Object, Object> params =
                ImmutableMap.builder()
                        .put("codeType", type)
                        .build();
        return session.selectList(PACKAGE_NAME+"select",params);
    }

    @Override
    public List<GeneralCode> codeList() {
        ImmutableMap<Object, Object> params =
                ImmutableMap.builder()
                        .put("codeType", "SYS_CODE")
                        .put("valid","1")
                        .build();
        return session.selectList(PACKAGE_NAME+"select",params);
    }

    @Override
    public GeneralCode codeById(String codeId) {
        ImmutableMap<Object, Object> params =
                ImmutableMap.builder()
                        .put("codeId", codeId)
                        .build();
        return session.selectOne(PACKAGE_NAME+"select",params);
    }

    @Override
    public GeneralCode codeByKey(int key) {
        ImmutableMap<Object, Object> params =
                ImmutableMap.builder()
                        .put("id", key)
                        .build();
        return session.selectOne(PACKAGE_NAME+"select",params);
    }


    @Override
    public int codeCountByType(String codeType,String valid) {
        ImmutableMap<Object, Object> params =
                ImmutableMap.builder()
                        .put("codeType", codeType)
                        .put("valid",valid)
                        .build();
        return session.selectOne(PACKAGE_NAME+"count",params);
    }

    @Override
    public int updateValid(int key,String valid) {
        ImmutableMap<Object, Object> params =
                ImmutableMap.builder()
                        .put("id", key)
                        .put("valid",valid)
                        .build();
        return session.update(PACKAGE_NAME+"updateValid",params);
    }
}
