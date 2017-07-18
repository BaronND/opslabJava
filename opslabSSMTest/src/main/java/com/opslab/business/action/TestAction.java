
package com.opslab.business.action;

import com.opslab.system.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


/**
 * action注释
 */
@Controller
@RequestMapping("/test")
public class TestAction {
    @Resource(name = "userInfoService")
    private UserInfoService service;

    @ResponseBody
    @RequestMapping("/test/{id}")
    public Object userInof(@PathVariable("id") String id) {
        return null;
    }
}
