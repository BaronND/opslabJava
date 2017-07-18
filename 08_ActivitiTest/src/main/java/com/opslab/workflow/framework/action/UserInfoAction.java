package com.opslab.workflow.framework.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opslab.workflow.framework.entity.business.UserInfo;
import com.opslab.workflow.framework.entity.view.UIResult;
import com.opslab.workflow.util.sec;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.opslab.workflow.framework.service.UserInfoService;

/**
 * @author 0opslab
 * 用户相关的action
 */
@Controller
@RequestMapping("/admin/user")
public class UserInfoAction {
    @Resource(name="userInfoService")
    
    private UserInfoService service;

    public UserInfoService getService() {
		return service;
	}


	public void setService(UserInfoService service) {
		this.service = service;
	}


	@RequestMapping(method = RequestMethod.GET)
    public String userInfo(){
        return "/admin/user/userlist";
    }


    @RequestMapping("list")
    @ResponseBody
    public List<Object> userList(){
        return service.list();
    }

    /**
     * 跳转到新增用户的界面上
     * @return
     */
    @RequestMapping("add")
    public String addUser(){
        return "/admin/user/userAdd";
    }

    /**
     * 保存用户
     */
    @RequestMapping("save")
    @ResponseBody
    public UIResult addSave(HttpServletRequest request, HttpServletResponse response){
        String userCode = request.getParameter("userCode");
        String password = request.getParameter("password");
        String userName = request.getParameter("userName");
        String sex = request.getParameter("sex");
        String deptName = request.getParameter("deptName");

        UserInfo userInfo = new UserInfo(userCode,userName,deptName, sec.md5(password));
        service.save(userInfo);
        return  new UIResult("success","操作成功");
    }
}
