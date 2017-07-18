package com.opslab.blog.admin.controller;

import com.google.common.collect.ImmutableMap;
import com.opslab.blog.admin.APP;
import com.opslab.blog.admin.domain.Menu;
import com.opslab.blog.admin.service.MenuManagerService;
import com.opslab.blog.util.JacksonUtil;
import com.opslab.blog.util.RandomUtil;
import com.opslab.blog.admin.webentity.UIResult;
import com.opslab.blog.admin.webentity.UiTreeFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * 菜单管理
 */
@Controller
@RequestMapping("/admin/menu")
public class MenuManagerAction {

    private static Logger logger = LogManager.getLogger(CodeManagerAction.class);
    @Autowired
    private MenuManagerService service;

    @RequestMapping
    public String menu() {
        return "admin/MenuManagerList";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Menu> index() {
        ImmutableMap<Object, Object> params =
                ImmutableMap.builder()
                        .put("valid", APP.STATUS_VALID)
                        .build();
        logger.debug("菜单查询:"+ JacksonUtil.toJSON(params));
        return service.select(params);
    }


    @RequestMapping("/manlist")
    @ResponseBody
    public Collection<Menu> list() {
        List<Menu> menus = service.select(null);

        return UiTreeFactory.formatTree(menus);
    }





    @RequestMapping("save")
    @ResponseBody
    public UIResult save(Menu menu) {
        menu.setValid(APP.STATUS_VALID);
        menu.setTime(new Date());
        int save = service.save(menu);
        return UIResult.notZero(save,"添加成功","添加失败");
    }


    @RequestMapping("delete")
    @ResponseBody
    public UIResult delete(@RequestParam("id") String id) {
        int delete = service.delete(id);
        return UIResult.notZero(delete,"操作成功","操作失败");
    }

    @RequestMapping("activate/{id}")
    @ResponseBody
    public UIResult activate(@PathVariable("id") String[] id) {
        for (int i = 0; i < id.length; i++) {
            service.activate(id[i]);
        }
        return UIResult.success("操作成功");
    }
}
