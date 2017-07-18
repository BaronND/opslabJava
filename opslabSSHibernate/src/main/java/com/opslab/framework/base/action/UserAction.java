package com.opslab.framework.base.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opslab.framework.base.entity.UserInfo;
import com.opslab.framework.base.util.ParameterUtil;
import com.opslab.framework.base.entity.view.UIResult;
import com.opslab.util.Password;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.opslab.framework.base.service.UserInfoService;

/**
 * @author 0opslab
 *         用户相关的action
 */
@Controller
@RequestMapping("/admin/user")
public class UserAction {
    @Resource(name = "userInfoService")
    private UserInfoService service;


    @RequestMapping
    public String userInfo(HttpServletRequest request,ModelMap model) {
        Map<String,Object> params = ParameterUtil.params(request);
        ParameterUtil.putModel(model,params);

        long count = service.count(params);
        model.addAttribute("userCount", count);
        return "admin/user-list";
    }

    @RequestMapping("count")
    @ResponseBody
    public long count(HttpServletRequest request) {
        Map<String,Object> params = ParameterUtil.params(request);
        return service.count(params);
    }


    @RequestMapping("list")
    @ResponseBody
    public List userList(
            HttpServletRequest request,
            @RequestParam("page") int page,
            @RequestParam("rows") int size
    ) {
        Map<String,Object> params = ParameterUtil.params(request);

        return service.list(params,page, size);
    }

    /**
     * 跳转到新增用户的界面上
     *
     * @return
     */
    @RequestMapping("add")
    public String addUser() {
        return "admin/userAdd";
    }

    /**
     * 保存用户
     */
    @RequestMapping("save")
    @ResponseBody
    public UIResult addSave(HttpServletRequest request, HttpServletResponse response) {
        String userCode = request.getParameter("userCode");
        String password = request.getParameter("password");
        String userName = request.getParameter("userName");
        String sex = request.getParameter("sex");
        String deptName = request.getParameter("deptName");

        UserInfo userInfo = new UserInfo(userCode, userName, deptName, Password.md5(password));
        service.save(userInfo);
        return new UIResult("success", "操作成功");
    }
}
