package com.opslab.imagemanager.service.impl;

import com.opslab.imagemanager.domain.UploadInfo;
import com.opslab.imagemanager.service.UploadInfoService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 实现
 */
@Service
public class UploadInfoServiceImpl extends SuperServiceImpl implements UploadInfoService{
    private static String PACKAGE_NAME = "com.opslab.imagemanager.domain.UploadInfo.";
    @Override
    public int save(UploadInfo info) {
        return session.update(PACKAGE_NAME+"insert",info);
    }


    @Override
    public int count(Map<Object, Object> params) {
        return session.selectOne(PACKAGE_NAME+"count",params);
    }

    @Override
    public List<UploadInfo> page(Map<Object, Object> params, int page, int size) {
        RowBounds rows = new RowBounds((page -1 ) * size, size);
        return session.selectList(PACKAGE_NAME+"page",params,rows);
    }
}
