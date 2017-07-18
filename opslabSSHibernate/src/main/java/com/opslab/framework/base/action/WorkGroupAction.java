package com.opslab.framework.base.action;

import com.opslab.framework.base.entity.WorkGroup;
import com.opslab.framework.base.service.WorkGroupService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户组相关的Action
 */

@Controller
@RequestMapping("/admin/workgroup")
public class WorkGroupAction {

    @Resource(name="workGroupService")
    private WorkGroupService service;

    /**
     * 打开用户工作组相关的管理页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping
    public String workGroup(HttpServletRequest request,ModelMap model){
        String isAll = request.getParameter("all");
        Long count = service.count(false);
        if("1".equals(isAll)){
            count = service.count(true);
        }
        model.put("count",count);
        return "/admin/workGroup-list";
    }

    /**
     * 统计用户组的数量
     * @param request
     *      all=1表示全部工作组
     *      all != 1 表示有效的工作组
     * @return
     */
    @RequestMapping("count")
    @ResponseBody
    public long count(HttpServletRequest request){
        String isAll = request.getParameter("all");
        Long count = service.count(false);
        if("1".equals(isAll)){
            count = service.count(true);
        }
        return count;
    }

    /**
     * 获取用户组数据
     * @param request
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public List<WorkGroup> list(HttpServletRequest request){
        String isAll = request.getParameter("all");
        if("1".equals(isAll)){
            return service.list(true);
        }
        return service.list(false);
    }

    @RequestMapping("info/{id}")
    public String info(@PathVariable("id") String id, ModelMap model){
        WorkGroup workGroup = service.get(id);
        Long userCount = service.countUser(id);
        model.put("group",workGroup);
        model.put("userCount",userCount);
        return "admin/workGroupInfo";
    }

}
