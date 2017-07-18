package com.opslab.imagemanager.service.impl;

import com.google.common.collect.ImmutableMap;
import com.opslab.imagemanager.domain.UploadGroup;
import com.opslab.imagemanager.service.UploadGroupService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 上传用户组
 */
@Service
public class UploadGroupServiceImpl extends SuperServiceImpl implements UploadGroupService {
    private static String PACKAGE = "com.opslab.imagemanager.domain.UploadGroup.";

    @Override
    public UploadGroup imageGroup(int gid) {
        ImmutableMap<Object, Object> params =
                ImmutableMap.builder()
                        .put("id", gid)
                        .build();
        return session.selectOne(PACKAGE + "select", params);
    }

    @Override
    public List<UploadGroup> list() {
        return session.selectList(PACKAGE + "select", null);
    }
}
