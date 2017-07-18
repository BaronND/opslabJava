package com.opslab.workflow.component.common.service;

import java.util.List;

import com.opslab.workflow.framework.entity.view.UiPTree;
import com.opslab.workflow.framework.entity.view.UiTree;

/**
 * @author 0opslab
 * @date on 2016/4/11 0011.
 * 提供一些通用数据查询的接口
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


    boolean login(String userid,String passwd);

}
