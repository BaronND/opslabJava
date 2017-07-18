package com.opslab.blog.admin.service;

import com.opslab.blog.admin.domain.UploadInfo;

import java.util.List;
import java.util.Map;

/**
 * 上传记录
 */
public interface UploadInfoService {
    /**
     * 保存上传记录
     * @param info
     * @return
     */
    int save(UploadInfo info);

    /**
     * 查询上传记录
     * @param params
     * @return
     */
    int count(Map<Object,Object> params);

    /**
     * 查询上传记录
     * @param params
     * @param page
     * @param size
     * @return
     */
    List<UploadInfo> page(Map<Object,Object> params, int page, int size);
}
