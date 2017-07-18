package com.opslab.workflow.framework.service;

import java.util.List;

import com.opslab.workflow.framework.entity.business.Deptments;
import com.opslab.workflow.framework.entity.business.UserInfo;

/**
* 业务方法接口
*/
public interface DeptmentsService extends SupportService<Deptments,String> {
    /**
     * 获取部门列表JSON数据
     * @return
     */
    List<Deptments> deptList();

    /**
     * 获取部门信息
     * @param detpId
     * @return
     */
    Deptments getDeptByDeptId(String detpId);

    /**
     * 添加部门信息
     * @param parentId 上级部门ID
     * @param deptName 部门名称
     * @return
     */
    boolean addDept(String parentId, String deptName);


    /**
     * 获取指定部门的人员列表
     * @param detpId
     * @return
     */
    List<UserInfo> getUsers(String detpId);
}

