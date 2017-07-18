package com.opslab.framework.cache;

import com.opslab.framework.base.annotation.ServiceMethod;

/**
 * 定义系统常用缓存的接口
 */
public interface CommonCache {
    @ServiceMethod("获取部门名称")
    String deptName(String detpId);

    @ServiceMethod("获取编码名称")
    String codeName(String codeType,String codeId);

    @ServiceMethod("获取用户信息")
    String userName(String userId);
}
