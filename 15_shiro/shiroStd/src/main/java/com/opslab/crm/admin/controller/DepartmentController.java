package com.opslab.crm.admin.controller;


import com.google.common.collect.ImmutableMap;
import com.opslab.crm.admin.APP;
import com.opslab.crm.admin.annotation.ActionInfo;
import com.opslab.crm.admin.domain.DepartmentInfo;
import com.opslab.crm.admin.domain.UserInfo;
import com.opslab.crm.admin.service.IDepartmentInfoService;
import com.opslab.crm.admin.service.IUserInfoService;
import com.opslab.crm.common.entity.UIResult;
import com.opslab.crm.common.entity.UiTree;
import com.opslab.crm.common.entity.UiTreeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 0opslab
 * @descript 部门管理web层API
 */
@Controller
@RequestMapping("/admin/dept")
public class DepartmentController extends SuperController{

    @Autowired
    private IDepartmentInfoService service;

    @Autowired
    private IUserInfoService userInfoService;

    @RequestMapping
    public String index(ModelMap model){
        return "admin/DepartmentManager";
    }

    @RequestMapping("list")
    @ResponseBody
    @ActionInfo("获取部门信息列表")
    public UIResult list() {
        return UIResult.success(APP.success,service.list(null));
    }

    @RequestMapping("list-child")
    @ResponseBody
    @ActionInfo("获取有效部门信息列表[父子关系]")
    public List<UiTree> listChild() {
        List<UiTree> result = new ArrayList<>();

        ImmutableMap<Object, Object> params =
                ImmutableMap.builder()
                        .put("status", APP.STATUS_VALID)
                        .build();
        List<DepartmentInfo> list = service.list(params);
        if(list == null || list.size() == 0){
            return result;
        }

        for(DepartmentInfo dept:list){
            result.add(new UiTree(dept.getDeptId(),dept.getParentId(),dept.getName(),dept.getTreeType()));
        }
        return UiTreeFactory.format(result);
    }


    @RequestMapping("info")
    @ResponseBody
    @ActionInfo("获取部门信息列表")
    public UIResult info(@RequestParam int deptId) {
        ImmutableMap<Object, Object> data =
                ImmutableMap.builder()
                        .put("dept", service.department(deptId))
                        .put("userCount", 10)
                        .build();
        return UIResult.success(APP.success,data);
    }



    @RequestMapping("add")
    @ResponseBody
    @ActionInfo("新增部门")
    public UIResult add(@RequestParam int parentId,@RequestParam String name,@RequestParam String memo) {
        DepartmentInfo departmentInfo = new DepartmentInfo(name, parentId, APP.TREE_TYPE_BRANCH, APP.STATUS_VALID, memo);
        int save = service.save(departmentInfo);
        return UIResult.notZero(save,"添加成功","添加失败");
    }


    @RequestMapping("userlist")
    @ResponseBody
    @ActionInfo("获取部门员工信息")
    public List<UserInfo> deptUserList(HttpServletRequest request, @RequestParam int deptId){
        int page = page(request);
        int rows = rows(request);
        ImmutableMap<Object, Object> params =
                ImmutableMap.builder()
                        .put("deptId", deptId)
                        .build();
        return userInfoService.page(params, page, rows);
    }
}
