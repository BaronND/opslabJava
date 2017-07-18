package com.opslab.framework.base.action;

import com.opslab.framework.InitQuery;
import com.opslab.framework.base.entity.BusinessLog;
import com.opslab.framework.base.service.BusinessLogService;
import com.opslab.framework.base.util.ParameterUtil;
import com.opslab.util.valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 业务日志
 */
@Controller
@RequestMapping("/log/business")
public class BusinessLogAction {
    @Resource(name = "businessLogService")
    private BusinessLogService serivice;

    @RequestMapping
    public String business(HttpServletRequest request,ModelMap model) {
        Map<String,Object> params = ParameterUtil.params(request);
        ParameterUtil.putModel(model,params);

        if(!params.containsKey("startTime") || !valid.valid(params.get("startTime"))){
            params.put("startTime",InitQuery.logQueryStartTime());
            model.put("startTime",InitQuery.logQueryStartTime());
        }
        if(!params.containsKey("endTime") || !valid.valid(params.get("endTime"))){
            params.put("endTime",InitQuery.logQueryEndTime());
            model.put("endTime",InitQuery.logQueryEndTime());
        }

        model.put("count", serivice.count(params));
        return "/log/business-log";
    }

    @RequestMapping("list")
    @ResponseBody
    public List<BusinessLog> list(
            HttpServletRequest request,
            @RequestParam int page,
            @RequestParam int rows
    ) {
        Map<String,Object> params = ParameterUtil.params(request);

        return serivice.list(params,page, rows);
    }

    @RequestMapping("info/{id}")
    public String info(@PathVariable("id") String id,ModelMap model){
        BusinessLog businessLog = serivice.get(id);
        model.put("log",businessLog);
        return "/log/businessLogInfo";
    }
}
