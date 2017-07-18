package com.opslab.framework.base.action;

import com.opslab.framework.base.entity.Role;
import com.opslab.framework.base.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/admin/role")
public class RoleAction {

    @Resource(name="roleService")
    private RoleService service;

    /**
     * 默认跳转到用户角色管理页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping
    public String role(HttpServletRequest request,ModelMap model){
        String isAll = request.getParameter("all");
        Long count = service.count(false);
        if("1".equals(isAll)){
            count = service.count(true);
        }
        model.put("count",count);
        return "/admin/role-list";
    }

    /**
     * 获取用户角色列表
     * @param request
     * @return
     */
    @RequestMapping("count")
    @ResponseBody
    public Long count(HttpServletRequest request){
        String isAll = request.getParameter("all");
        Long count = service.count(false);
        if("1".equals(isAll)){
            count = service.count(true);
        }
        return count;
    }




    /**
     * 获取用户角色列表
     * @param request
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public List<Role> list(HttpServletRequest request){
        String isAll = request.getParameter("isAll");
        if("1".equals(isAll)){
            return service.list(true);
        }
        return service.list(false);
    }

    /**
     * 获取指定角色的信息
     */
    @RequestMapping("/info/{roleId}")
    public String useInfo(
            ModelMap model,
            @PathVariable("roleId") String roleId){
        Role role = service.get(roleId);
        if(role != null){
            model.put("role",role);
            model.put("userCount",service.count(roleId));
            return "/admin/roleInfo";
        }
        throw new RuntimeException("no data");

    }

    /**
     * 跳转到指定的角色的用户列表
     * @param roleId
     * @return
     */
    @RequestMapping("/userlist/{roleId}")
    @ResponseBody
    public List userList(
            @PathVariable("roleId") String roleId,
            @RequestParam("page") int page,
            @RequestParam("rows") int size){

        List<Object> objects = service.userSet(roleId, page, size);
        return objects;
    }
    /**
     * 获取指定角色下的用户
     * @param page
     * @param pagesize
     * @return
     */
    @RequestMapping("/users/{roleId}")
    @ResponseBody
    public List<Object> listUser(
            @PathVariable("roleId") String roleId,
            @RequestParam("page") int page,
            @RequestParam("rows") int pagesize
    ){
        return service.userSet(roleId,page,pagesize);
    }

}
