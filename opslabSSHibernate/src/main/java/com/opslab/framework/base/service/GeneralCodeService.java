package com.opslab.framework.base.service;

import com.opslab.framework.base.annotation.ServiceMethod;
import com.opslab.framework.base.entity.GeneralCode;

import java.util.List;

/**
 * @author 0opslab
 * @date on 2016/6/25 0025.
 */
public interface GeneralCodeService extends SupportService<GeneralCode, String> {


    @ServiceMethod("获取编码类型列表")
    List<GeneralCode> getGeneralList();


    @ServiceMethod("统计编码个数")
    Long codeCount(String codeType);


    @ServiceMethod("获取编码值列表")
    List<GeneralCode> codeTypeList(String codeType);


    @ServiceMethod("获取编码值列表")
    List<GeneralCode> codeTypeList(String codeType, int page, int rows);


    @ServiceMethod("获取编码实体")
    GeneralCode getCodeId(String codeId);

    @ServiceMethod("删除编码")
    void delete(String id);


    @ServiceMethod("启用编码")
    void activate(String id);

}
