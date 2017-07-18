package com.opslab.workflow.component.common.action;

import com.opslab.workflow.component.common.service.CommonService;
import com.opslab.workflow.util.sec;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 0opslab
 * @date on 2016/6/18 0018.
 */
@Controller
@RequestMapping("/")
public class LoginAction {

    @Resource(name = "commonService")
    private CommonService service;

    /**
     * 跳转的登录页面
     * @return
     */
    @RequestMapping("/login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/userlogin")
    public String login(HttpServletRequest request, HttpServletResponse response){
        String userId = request.getParameter("userid");
        String passwd = request.getParameter("passwd");
        if(service.login(userId, sec.md5(passwd))){
            request.getSession().setAttribute("user",userId);
            return "redirect:/admin.do";
        }
        return "login";
    }


}
