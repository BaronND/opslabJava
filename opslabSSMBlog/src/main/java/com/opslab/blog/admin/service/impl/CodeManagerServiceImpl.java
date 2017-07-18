package com.opslab.blog.admin.service.impl;

import com.google.common.collect.ImmutableMap;
import com.opslab.blog.admin.APP;
import com.opslab.blog.admin.domain.GeneralCode;
import com.opslab.blog.util.JacksonUtil;
import com.opslab.blog.util.PackageUtil;
import com.opslab.blog.admin.service.CodeManagerService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 0opslab
 * @descript 编码管理操作接口实现
 */
@Service
public class CodeManagerServiceImpl extends SuperServiceImpl implements CodeManagerService {

    private static Logger logger = LogManager.getLogger(CodeManagerServiceImpl.class);


    private static String MAPPER_SELECT = PackageUtil.mapperPackage(GeneralCode.class) + "select";

    private static String MAPPER_UPDATEVALID = PackageUtil.mapperPackage(GeneralCode.class) + "updateValid";

    private static String MAPPER_COUNT = PackageUtil.mapperPackage(GeneralCode.class) + "count";

    private static String MAPPER_INSERT = PackageUtil.mapperPackage(GeneralCode.class)+"insert";

    @Override
    public List<GeneralCode> codeType(String type, String valid) {
        ImmutableMap<Object, Object> params =
                ImmutableMap.builder()
                        .put("codeType", type)
                        .put("valid", valid)
                        .put("treeType",APP.TREE_TYPE_LEAF)
                        .build();
        logger.debug(MAPPER_SELECT + "=>" + JacksonUtil.toJSON(params));
        return session.selectList(MAPPER_SELECT, params);
    }



    @Override
    public List<GeneralCode> codeList() {
        ImmutableMap<Object, Object> params =
                ImmutableMap.builder()
                        .put("treeType", APP.TREE_TYPE_BRANCH)
                        .put("valid", APP.STATUS_VALID)
                        .build();
        logger.debug(MAPPER_SELECT + "=>" + JacksonUtil.toJSON(params));
        return session.selectList(MAPPER_SELECT, params);
    }

    @Override
    public GeneralCode codeById(String codeId) {
        ImmutableMap<Object, Object> params =
                ImmutableMap.builder()
                        .put("codeId", codeId)
                        .build();
        logger.debug(MAPPER_SELECT + "=>" + JacksonUtil.toJSON(params));
        return session.selectOne(MAPPER_SELECT, params);
    }

    @Override
    public GeneralCode codeByKey(int key) {
        ImmutableMap<Object, Object> params =
                ImmutableMap.builder()
                        .put("keyId", key)
                        .build();
        logger.debug(MAPPER_SELECT + "=>" + JacksonUtil.toJSON(params));
        return session.selectOne(MAPPER_SELECT, params);
    }


    @Override
    public int codeCountByType(String codeType, String valid) {
        ImmutableMap<Object, Object> params =
                ImmutableMap.builder()
                        .put("codeType", codeType)
                        .put("valid", valid)
                        .build();
        logger.debug(MAPPER_COUNT + "=>" + JacksonUtil.toJSON(params));
        return session.selectOne(MAPPER_COUNT, params);
    }

    @Override
    public int updateValid(int key, String valid) {
        ImmutableMap<Object, Object> params =
                ImmutableMap.builder()
                        .put("keyId", key)
                        .put("valid", valid)
                        .build();
        logger.info(MAPPER_UPDATEVALID+"=>"+JacksonUtil.toJSON(params));
        return session.update(MAPPER_UPDATEVALID, params);
    }

    @Override
    public int save(GeneralCode code) {
        logger.info(MAPPER_INSERT+"=>"+JacksonUtil.toJSON(code));
        return session.insert(MAPPER_INSERT,code);
    }

    @Override
    public GeneralCode oneCode(Map<Object, Object> params) {
        logger.info(MAPPER_SELECT+"=>"+JacksonUtil.toJSON(params));
        return session.selectOne(MAPPER_SELECT, params);
    }
}
