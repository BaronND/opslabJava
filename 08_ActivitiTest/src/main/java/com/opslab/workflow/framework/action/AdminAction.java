package com.opslab.workflow.framework.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 0opslab
 * @date on 2016/4/3 0003.
 * 后台管理
 */
@Controller
@RequestMapping("/admin")
public class AdminAction {
    //RequestMapping是将URL进行映射
    //其中value等于空表示直接响应/请求
    @RequestMapping
    public String admin() {
        return "admin/index";
    }
}

