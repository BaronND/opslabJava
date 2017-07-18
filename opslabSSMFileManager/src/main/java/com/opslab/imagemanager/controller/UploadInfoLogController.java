package com.opslab.imagemanager.controller;

import com.google.common.collect.ImmutableMap;
import com.opslab.imagemanager.InitQuery;
import com.opslab.imagemanager.domain.UploadInfo;
import com.opslab.imagemanager.service.UploadInfoService;
import com.opslab.imagemanager.util.JacksonUtil;
import com.opslab.imagemanager.util.ParameterUtil;
import com.opslab.imagemanager.util.Valid;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 查询上传记录信息
 */
@Controller
@RequestMapping("/uploadlog")
public class UploadInfoLogController {
    private static Logger logger = LogManager.getLogger(UploadInfoLogController.class);

    @Autowired
    private UploadInfoService service;

    @RequestMapping("index")
    public String index(HttpServletRequest request,ModelMap model) {
        Map<Object,Object> params = ParameterUtil.params(request);
        logger.debug("query params:"+ JacksonUtil.toJSON(params));
        ParameterUtil.putModel(model,params);

        if(!params.containsKey("starttime") || !Valid.valid(params.get("starttime"))){
            params.put("starttime", InitQuery.queryStartTime());
            model.put("starttime",InitQuery.queryStartTime());
        }
        if(!params.containsKey("endTime") || !Valid.valid(params.get("endtime"))){
            params.put("endtime",InitQuery.queryEndTime());
            model.put("endtime",InitQuery.queryEndTime());
        }

        model.put("count", service.count(params));
        return "/admin/BusinessLogList";
    }

    @RequestMapping("page")
    @ResponseBody
    public List<UploadInfo> page(HttpServletRequest request, @RequestParam int page, @RequestParam int rows) {
        Map<Object, Object> params = ParameterUtil.params(request);
        logger.debug("query:"+JacksonUtil.toJSON(page));
        return service.page(params, page, rows);
    }


}
