package com.opslab.imagemanager.service;

import com.opslab.imagemanager.domain.GeneralCode;

import java.util.List;

/**
 * @author 0opslab
 * @descript 编码管野操作接口
 */
public interface GeneralCodeService {
    /**
     * 根据编码类型返回一组编码
     * @param type
     * @param valid
     * @return
     */
    List<GeneralCode> codeType(String type, String valid);

    /**
     * 根据编码类型返回一组编码包括状态已经失效的
     * @param type
     * @return
     */
    List<GeneralCode> codeTypeAll(String type);

    /**
     * 查询编码类型
     * @return
     */
    List<GeneralCode> codeList();

    /**
     * 根据codeid编码获取编码
     * @param codeId
     * @return
     */
    GeneralCode codeById(String codeId);

    /**
     * 根据主键key获取相应的编码
     * @param key
     * @return
     */
    GeneralCode codeByKey(int key);

    /**
     * 根据codeType获取编码类型
     * @param codeType
     * @return
     */
    int codeCountByType(String codeType,String valid);

    /**
     * 根据编码id更新编码的状态
     * @param key
     * @param valid
     */
    int updateValid(int key,String valid);
}
