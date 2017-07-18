package com.opslab.workflow.component.common.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.opslab.workflow.component.common.service.CommonService;
import com.opslab.workflow.framework.entity.view.UiPTree;
import com.opslab.workflow.framework.entity.view.UiTree;


/**
 * @author 0opslab
 * @date on 2016/4/11 0011.
 * 提供一些通用数据查询的接口
 */
@Controller
@RequestMapping("/")
public class CommonAction {

    @Resource(name = "commonService")
    private CommonService service;



	/**
     * 返回简单格式的JSON数据
     * @return
     */
    @RequestMapping("/deptlist")
    @ResponseBody
    public List<UiTree> deptlistSimpeldate(){
        return service.getDeptList("");
    }

    /**
     * 返回父子包含关系的JSON数据
     * @return
     */
    @RequestMapping("/deptdata")
    @ResponseBody
    public List<UiPTree> detpListDate(){
        return service.getDeptListWithChild();
    }

    /**
     * 选择部门
     * @return
     */
    @RequestMapping("selectDept")
    public String selectDept(){
        return "common/selectDept";
    }
}
