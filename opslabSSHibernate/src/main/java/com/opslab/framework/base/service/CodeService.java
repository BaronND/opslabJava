package com.opslab.framework.base.service;

import com.opslab.framework.base.annotation.ServiceMethod;
import com.opslab.framework.base.entity.view.UiCode;

import java.util.List;

/**
 * 通用的编码相关的方法
 */
public interface CodeService {

    @ServiceMethod("获取编码类型")
    List<UiCode> codeMap(String codeType);
}
