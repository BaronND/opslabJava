package com.opslab.framework.base.service.impl;

import com.opslab.framework.base.dao.DBUtil;
import com.opslab.framework.base.entity.util.PTreeUtil;
import org.springframework.stereotype.Service;

import com.opslab.framework.base.service.CommonService;
import com.opslab.framework.base.entity.UserInfo;
import com.opslab.framework.base.entity.view.UiPTree;
import com.opslab.framework.base.entity.view.UiTree;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 0opslab
 * @date on 2016/4/21 0021.
 */
@Service("commonService")
public class CommonServiceImpl implements CommonService {
    @Resource(name="dbUtils")
    private DBUtil db;

    /**
     * 查询部门列表数据
     * @Summary:当deptId为空时返回全部数据,否则返回子部门
     * @param deptId
     * @return
     */
    public List<UiTree> getDeptList(String deptId){
        String sql ="SELECT deptId id,detpName name,parentId pId FROM ops_re_deptments t" +
                " where t.valid='1'";
        return db.find(UiTree.class,sql);
    }

    /**
     * 返回包含父子关系的部门列表
     * @return
     */
    public List<UiPTree> getDeptListWithChild(){
        List<UiPTree> praentDeptList = getPraentDeptList();
        List<UiPTree> childDeptList = getChildDeptList();
        return PTreeUtil.packListForJson(praentDeptList,childDeptList);
    }



    /**
     * 获取所有的父节点
     * @return
     */
    private List<UiPTree> getPraentDeptList(){
        //注意exists的巧妙用法
        String sql ="SELECT  t.deptId id,t.detpName NAME,t.parentId pId FROM ops_re_deptments t " +
                "WHERE t.valid='1' AND t.deptId   EXISTS " +
                " (SELECT  parentId  FROM  ops_re_deptments  WHERE valid = '1' AND parentId=t.deptId)";
        return db.find(UiPTree.class,sql);
    }

    /**
     * 获取所有的子节点
     * @return
     */
    private List<UiPTree> getChildDeptList(){
        //注意 NOT exists的巧妙用法
        String sql ="SELECT  t.deptId id,t.detpName NAME,t.parentId pId FROM ops_re_deptments t " +
                "WHERE t.valid='1' AND t.deptId NOT  EXISTS " +
                " (SELECT  parentId  FROM  ops_re_deptments  WHERE valid = '1' AND parentId=t.deptId)";
        return db.find(UiPTree.class,sql);
    }


}
