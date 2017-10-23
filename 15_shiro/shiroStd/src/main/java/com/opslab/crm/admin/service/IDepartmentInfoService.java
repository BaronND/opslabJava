package com.opslab.crm.admin.service;

import com.opslab.crm.admin.annotation.ServiceMethod;
import com.opslab.crm.admin.domain.DepartmentInfo;

import java.util.List;
import java.util.Map;

/**
 * @author 0opslab
 * @descript 部门操作接口
 */
public interface IDepartmentInfoService {
    @ServiceMethod("获取部门总数")
    int count();

    @ServiceMethod("查询部门信息")
    List<DepartmentInfo> list(Map<Object,Object> params);

    @ServiceMethod("更新部门状态")
    int updateStatus(int deptId,String status);

    @ServiceMethod("新增部门")
    int save(DepartmentInfo dept);

    @ServiceMethod("查询部门信息")
    DepartmentInfo department(int deptId);



}
