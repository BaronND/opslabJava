package com.opslab.blog.admin.service;

import com.opslab.blog.admin.domain.UploadGroup;

import java.util.List;

/**
 * 查询ImageGroup的业务层
 */
public interface UploadGroupService {
    /**
     * 根据gid查询图片上传配置组
     * @param gid
     * @return
     */
    UploadGroup imageGroup(int gid);

    /**
     * 查询全部的图像配置组
     * @return
     */
    List<UploadGroup> list();
}
