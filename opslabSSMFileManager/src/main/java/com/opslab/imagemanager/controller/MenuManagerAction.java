package com.opslab.imagemanager.controller;

import com.google.common.collect.ImmutableMap;
import com.opslab.imagemanager.domain.Menu;
import com.opslab.imagemanager.service.MenuManagerService;
import com.opslab.imagemanager.webentity.UIResult;
import com.opslab.imagemanager.webentity.UiTreeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单管理
 */
@Controller
@RequestMapping("/admin/menu")
public class MenuManagerAction {

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
                        .put("valid", "1")
                        .build();
        return service.select(params);
    }


    @RequestMapping("/manlist")
    @ResponseBody
    public Collection<Menu> list() {
        List<Menu> menus = service.select(null);
        return UiTreeFactory.formatTree(menus);
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request, ModelMap model) {
        String pId = request.getParameter("pid");
        model.put("pId", pId);
        return "admin/menuAdd";
    }

    @RequestMapping("/info/{id}")
    public String info(@PathVariable("id") String id, ModelMap model) {
        ImmutableMap<Object, Object> params =
                ImmutableMap.builder()
                        .put("id", id)
                        .build();
        List<Menu> menus = service.page(params, 0, 1);
        if (menus != null && menus.size() > 0) {
            model.put("menu", menus.get(0));
        }
        return "admin/menuInfo";
    }

    @RequestMapping("/save")
    @ResponseBody
    public UIResult save(Menu from) {
        service.save(from);
        return UIResult.success("success");
    }


    @RequestMapping("delete/{id}")
    @ResponseBody
    public UIResult delete(@PathVariable("id") String[] id) {
        for (int i = 0; i < id.length; i++) {
            service.delete(id[i]);
        }
        return UIResult.success("success");
    }

    @RequestMapping("activate/{id}")
    @ResponseBody
    public UIResult activate(@PathVariable("id") String[] id) {
        for (int i = 0; i < id.length; i++) {
            service.activate(id[i]);
        }
        return UIResult.success("success");
    }
}
