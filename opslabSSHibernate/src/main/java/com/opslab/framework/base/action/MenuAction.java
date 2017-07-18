package com.opslab.framework.base.action;

import com.opslab.framework.base.entity.Menu;
import com.opslab.framework.base.entity.view.UIResult;
import com.opslab.framework.base.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 菜单管理
 */
@Controller
@RequestMapping("/admin/menu")
public class MenuAction {
    @Resource(name = "menuService")
    private MenuService service;

    @RequestMapping
    public String menu(){
        return "admin/menuList";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Menu> list(){
        return service.list();
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request, ModelMap model){
        String pId = request.getParameter("pid");
        model.put("pId",pId);
        return "admin/menuAdd";
    }

    @RequestMapping("/info/{id}")
    public String info(@PathVariable("id") String id, ModelMap model){
        Menu menu = service.get(id);
        model.put("menu",menu);
        return "admin/menuInfo";
    }

    @RequestMapping("/save")
    @ResponseBody
    public UIResult save(Menu from){
        service.save(from);
        return UIResult.success();
    }


    @RequestMapping("delete/{id}")
    @ResponseBody
    public UIResult delete(@PathVariable("id")  String id){
        if(id.contains(",")){
            String[] ids = id.split(",");
            for(int i=0;i<ids.length;i++){
                service.delete(ids[i]);
            }
        }else{
            service.delete(id);
        }
        return UIResult.success();
    }

    @RequestMapping("activate/{id}")
    @ResponseBody
    public UIResult activate(@PathVariable("id")  String id){
        if(id.contains(",")){
            String[] ids = id.split(",");
            for(int i=0;i<ids.length;i++){
                service.activate(ids[i]);
            }
        }else{
            service.activate(id);
        }
        return UIResult.success();
    }
}
