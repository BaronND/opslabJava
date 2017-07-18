package com.opslab.blog.admin.controller;

import com.opslab.blog.admin.APP;
import com.opslab.blog.util.RegUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * 通用的controller类
 */
public class SuperController {


    /**
     * 尝试获取分页的参数，如果不存在默认为第一页
     * @param request
     * @return
     */
    public int page(HttpServletRequest request){
        String pageStr = request.getParameter("page");
        int page = 1;
        if(RegUtil.isNumeric(pageStr)){
            page = Integer.parseInt(pageStr);
        }
        return page;
    }


    /**
     * 尝试获取分页的参数，如果不存在默认APP.APP_PAGESIZE
     * @param request
     * @return
     */
    public int rows(HttpServletRequest request){
        String rowsStr = request.getParameter("rows");
        int rows = APP.APP_PAGESIZE;
        if(RegUtil.isNumeric(rowsStr)){
            rows = Integer.parseInt(rowsStr);
        }
        return rows;
    }
}
