package com.opslab.blog.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台管理系统
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping
    public String admin() {
        return "/admin/admin-index";
    }
}
