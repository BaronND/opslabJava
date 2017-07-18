package com.opslab.business.action;

import com.opslab.business.BusinessConstant;
import com.opslab.business.service.ShuangSeQiuService;
import com.opslab.system.annotion.ActionMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 双色球
 */
@Controller
@RequestMapping("/se")
public class ShuangSeQiuAction {
    @Resource(name = "shuangSeQiuService")
    private ShuangSeQiuService service;


    @RequestMapping("random")
    @ResponseBody
    @ActionMethod(name = "按照平均比例随机一注双色球")
    public int[] random(HttpServletRequest request) {
        String type = request.getParameter("type");
        if ("defaultratio".equals(type)) {
            return service.random(BusinessConstant.RED_RATIO, BusinessConstant.BLUE_RATIO);
        }
        return service.random();
    }


    @RequestMapping("randomcount")
    @ResponseBody
    @ActionMethod(name = "按照平均比例随机N次返回各个数的比例")
    public Map<String, Map<Integer, Integer>> randomCount(
            @RequestParam("times") int time,
            @RequestParam("type") String type
    ) {
        if (time > 10000000 || time < 0) {
            return null;
        }
        if ("defaultratio".equals(type)) {
            return service.randomCount(BusinessConstant.RED_RATIO, BusinessConstant.BLUE_RATIO, time);
        }
        return service.randomCount(time);
    }

    @RequestMapping("realcount")
    @ResponseBody
    @ActionMethod(name = "历史各数值出现次数")
    public Map<String, Map<Integer, Integer>> realCount() {
        return service.realCount();
    }

}
