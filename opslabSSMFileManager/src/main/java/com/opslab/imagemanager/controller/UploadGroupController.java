package com.opslab.imagemanager.controller;

import com.opslab.imagemanager.domain.UploadGroup;
import com.opslab.imagemanager.listener.init.InitImageGroup;
import com.opslab.imagemanager.service.UploadGroupService;
import com.opslab.imagemanager.webentity.UIResult;
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

    @RequestMapping(value = "/reload")
    @ResponseBody
    public UIResult reload(){
        InitImageGroup.init(service);
        return UIResult.success("success reloading ");
    }
}
