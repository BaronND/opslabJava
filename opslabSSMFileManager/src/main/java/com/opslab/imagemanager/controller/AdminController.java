package com.opslab.imagemanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by neptune on 2017/4/8 0008.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping
    public String admin() {
        return "admin-index";
    }
}
