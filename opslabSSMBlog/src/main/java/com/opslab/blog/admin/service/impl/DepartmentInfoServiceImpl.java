package com.opslab.blog.admin.service.impl;

import com.google.common.collect.ImmutableMap;
import com.opslab.blog.admin.domain.DepartmentInfo;
import com.opslab.blog.admin.domain.UserInfo;
import com.opslab.blog.admin.service.DepartmentInfoService;
import com.opslab.blog.util.JacksonUtil;
import com.opslab.blog.util.PackageUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 0opslab
 * @descript 请添加说明
 */
@Service
public class DepartmentInfoServiceImpl extends SuperServiceImpl  implements DepartmentInfoService {
    private static Logger logger = LogManager.getLogger(DepartmentInfoServiceImpl.class);


    private static String MAPPER_SELECT = PackageUtil.mapperPackage(DepartmentInfo.class) + "select";

    private static String MAPPER_UPDATEVALID = PackageUtil.mapperPackage(DepartmentInfo.class) + "updateValid";

    private static String MAPPER_COUNT = PackageUtil.mapperPackage(DepartmentInfo.class) + "count";

    private static String MAPPER_INSERT = PackageUtil.mapperPackage(DepartmentInfo.class)+"insert";


    @Override
    public int count() {
        logger.debug("count department");
        return session.selectOne(MAPPER_COUNT);
    }

    @Override
    public List<DepartmentInfo> list(Map<Object, Object> params) {
        logger.debug(MAPPER_SELECT+"=>"+JacksonUtil.toJSON(params));
        return session.selectList(MAPPER_SELECT,params);
    }

    @Override
    public int updateStatus(int deptId, String status) {
        ImmutableMap<Object, Object> params =
                ImmutableMap.builder()
                        .put("deptId", deptId)
                        .put("status", status)
                        .build();
        logger.info("update deptarment status =>"+JacksonUtil.toJSON(params));
        return session.update(MAPPER_UPDATEVALID,params);
    }

    @Override
    public int save(DepartmentInfo dept) {
        List<DepartmentInfo> list = list(ImmutableMap.builder()
                .put("name", dept.getName())
                .build());
        if(list.size() > 0){
            logger.error("department is exists: "+dept.getName());
            return 0;
        }
        logger.info("add department =>"+JacksonUtil.toJSON(dept));
        return session.insert(MAPPER_INSERT,dept);
    }

    @Override
    public DepartmentInfo department(int deptId) {
        ImmutableMap<Object, Object> params =
                ImmutableMap.builder()
                        .put("deptId", deptId)
                        .build();
        logger.debug("load deptarment"+JacksonUtil.toJSON(params));
        return session.selectOne(MAPPER_SELECT,params);
    }


}
