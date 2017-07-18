package com.opslab.framework.base.service;

import java.util.List;

import com.opslab.framework.base.annotation.ServiceMethod;
import com.opslab.framework.base.entity.Deptments;
import com.opslab.framework.base.entity.UserInfo;

/**
* 业务方法接口
*/
public interface DeptmentsService extends SupportService<Deptments,String> {
    /**
     * 获取部门列表JSON数据
     * @return
     */
    @ServiceMethod("获取部门列表")
    List<Deptments> deptList();

    /**
     * 获取部门信息
     * @param detpId
     * @return
     */
    @ServiceMethod("获取指定部门信息")
    Deptments getDeptByDeptId(String detpId);

    /**
     * 添加部门信息
     * @param parentId 上级部门ID
     * @param deptName 部门名称
     * @return
     */
    @ServiceMethod("添加部门")
    boolean addDept(String parentId, String deptName);


    /**
     * 获取指定部门的人员列表
     * @param detpId
     * @return
     */
    @ServiceMethod("获取部门下的人员信息")
    List<UserInfo> getUsers(String detpId,int page,int size);

    /**
     * 统计部门的用户数量
     * @param deptId
     * @return
     */
    @ServiceMethod("统计部门人员数量")
    Long countUser(String deptId);
}

