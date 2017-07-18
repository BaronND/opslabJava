package com.opslab.framework.base.action;

import com.opslab.framework.base.entity.view.UiPTree;
import com.opslab.framework.base.entity.view.UiTree;
import com.opslab.framework.base.service.CommonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 0opslab
 * @date on 2016/6/15 0015.
 */
@Controller
@RequestMapping("/")
public class DeptAction {
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
    @RequestMapping("/selectdept")
    public String selectDept(){
        return "common/selectDept";
    }
}
