package com.opslab.blog.admin.service.impl;

import com.opslab.blog.util.JacksonUtil;
import com.opslab.blog.util.PackageUtil;
import com.opslab.blog.admin.domain.UploadInfo;
import com.opslab.blog.admin.service.UploadInfoService;
import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 实现
 */
@Service
public class UploadInfoServiceImpl extends SuperServiceImpl implements UploadInfoService {

    private static Logger logger = LogManager.getLogger(UploadInfoServiceImpl.class);

    private static String MAPPER_SELECT = PackageUtil.mapperPackage(UploadInfo.class) + "select";

    private static String MAPPER_INSERT = PackageUtil.mapperPackage(UploadInfo.class) + "insert";

    private static String MAPPER_COUNT = PackageUtil.mapperPackage(UploadInfo.class) + "count";


    @Override
    public int save(UploadInfo info) {
        logger.debug(MAPPER_INSERT + "=>" + JacksonUtil.toJSON(null));
        return session.update(MAPPER_INSERT, info);
    }


    @Override
    public int count(Map<Object, Object> params) {
        logger.debug(MAPPER_COUNT + "=>" + JacksonUtil.toJSON(params));
        return session.selectOne(MAPPER_COUNT, params);
    }

    @Override
    public List<UploadInfo> page(Map<Object, Object> params, int page, int size) {
        RowBounds rows = new RowBounds((page - 1) * size, size);
        logger.debug(MAPPER_SELECT + "=>" + JacksonUtil.toJSON(params) + "=>" + JacksonUtil.toJSON(rows));
        return session.selectList(MAPPER_SELECT, params, rows);
    }
}
