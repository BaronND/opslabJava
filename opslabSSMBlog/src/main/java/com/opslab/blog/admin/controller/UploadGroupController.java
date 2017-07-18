package com.opslab.blog.admin.controller;

import com.opslab.blog.admin.webentity.UIResult;
import com.opslab.blog.admin.domain.UploadGroup;
import com.opslab.blog.admin.listener.init.InitImage;
import com.opslab.blog.admin.service.UploadGroupService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 图片组管理
 */
@Controller
@RequestMapping("/admin/uploadgroup")
public class UploadGroupController {
    private static Logger logger = LogManager.getLogger(UploadGroupController.class);

    @Autowired
    private UploadGroupService service;

    @RequestMapping(value = "/get/{id}")
    @ResponseBody
    public UploadGroup getById(@PathVariable("id") int id){
        return service.imageGroup(id);
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public List<UploadGroup> list(){
        return service.list();
    }


}
