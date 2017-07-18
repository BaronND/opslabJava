package com.opslab.framework.base.action;


import com.opslab.framework.base.service.LoginService;
import com.opslab.util.Password;
import com.opslab.util.valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 0opslab
 * @date on 2016/6/18 0018.
 */
@Controller
@RequestMapping("/login")
public class LoginAction {

    @Resource(name = "loginService")
    private LoginService service;

    /**
     * 跳转的登录页面
     */
    @RequestMapping
    public String toLogin(HttpServletRequest request) {

        String user = request.getParameter("user");
        String passwd = request.getParameter("passwd");

        if (valid.valid(user, passwd) && service.login(user, Password.md5(passwd))) {
            request.getSession().setAttribute("user", user);
            return "redirect:/admin.do";
        }
        return "login";
    }


}
