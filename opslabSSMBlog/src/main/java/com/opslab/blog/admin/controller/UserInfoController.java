package com.opslab.blog.admin.controller;

import com.opslab.blog.admin.APP;
import com.opslab.blog.admin.annotation.ActionInfo;
import com.opslab.blog.admin.domain.UserInfo;
import com.opslab.blog.admin.service.UserInfoService;
import com.opslab.blog.util.JacksonUtil;
import com.opslab.blog.util.ParameterUtil;
import com.opslab.blog.util.RegUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 0opslab
 * @descript 用户操作
 */
@Controller
@RequestMapping("/admin/user")
public class UserInfoController {

    private static Logger logger = LogManager.getLogger(UserInfoController.class);

    @Autowired
    private UserInfoService service;

    @RequestMapping
    public String index(HttpServletRequest request,ModelMap model){
        Map<Object,Object> params = ParameterUtil.params(request);
        logger.debug("query params:"+ JacksonUtil.toJSON(params));
        ParameterUtil.putModel(model,params);

        String pageStr= request.getParameter("page");
        String rowStr=  request.getParameter("rows");

        int page = 1;
        int rows = APP.APP_PAGESIZE;

        if(pageStr != null && RegUtil.isNumeric(pageStr)){
            page = Integer.parseInt(pageStr);
        }
        if(rowStr != null && RegUtil.isNumeric(rowStr)){
            rows = Integer.parseInt(rowStr);
        }
        model.put("count",service.count(params));
        model.put("pageSize", rows);
        return "admin/UserInfoManager";
    }



    @RequestMapping("/list")
    @ResponseBody
    @ActionInfo("获取编码分类的所有编码值")
    public List<UserInfo> page(HttpServletRequest request){
        Map<Object,Object> params = ParameterUtil.params(request);
        logger.debug("query params:"+ JacksonUtil.toJSON(params));

        String pageStr= request.getParameter("page");
        String rowStr=  request.getParameter("rows");

        int page = 1;
        int rows = APP.APP_PAGESIZE;

        if(pageStr != null && RegUtil.isNumeric(pageStr)){
            page = Integer.parseInt(pageStr);
        }
        if(rowStr != null && RegUtil.isNumeric(rowStr)){
            rows = Integer.parseInt(rowStr);
        }
        return service.page(params,page,rows);
    }
}
