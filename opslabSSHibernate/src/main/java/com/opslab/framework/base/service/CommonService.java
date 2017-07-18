package com.opslab.framework.base.service;

import com.opslab.framework.base.entity.view.UiPTree;
import com.opslab.framework.base.entity.view.UiTree;

import java.util.List;

/**
 * @author 0opslab
 * @date on 2016/6/15 0015.
 */
public interface CommonService {
    /**
     * 查询部门列表数据
     * @Summary:当deptId为空时返回全部数据,否则返回子部门
     * @param deptId
     * @return
     */
    List<UiTree> getDeptList(String deptId);

    /**
     * 返回包含父子关系的部门列表
     * @return
     */
    List<UiPTree> getDeptListWithChild();


}
