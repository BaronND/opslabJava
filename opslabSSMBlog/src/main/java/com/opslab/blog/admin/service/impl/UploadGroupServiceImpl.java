package com.opslab.blog.admin.service.impl;

import com.google.common.collect.ImmutableMap;
import com.opslab.blog.admin.domain.UploadGroup;
import com.opslab.blog.admin.service.UploadGroupService;
import com.opslab.blog.util.JacksonUtil;
import com.opslab.blog.util.PackageUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 上传用户组
 */
@Service
public class UploadGroupServiceImpl extends SuperServiceImpl implements UploadGroupService {

    private static Logger logger = LogManager.getLogger(UploadGroupServiceImpl.class);


    private static String MAPPER_SELECT = PackageUtil.mapperPackage(UploadGroup.class) + "select";

    @Override
    public UploadGroup imageGroup(int gid) {
        ImmutableMap<Object, Object> params =
                ImmutableMap.builder()
                        .put("id", gid)
                        .build();
        logger.debug(MAPPER_SELECT + "=>" + JacksonUtil.toJSON(params));
        return session.selectOne(MAPPER_SELECT, params);
    }

    @Override
    public List<UploadGroup> list() {
        logger.debug(MAPPER_SELECT + "=>" + JacksonUtil.toJSON(null));
        return session.selectList(MAPPER_SELECT, null);
    }
}
