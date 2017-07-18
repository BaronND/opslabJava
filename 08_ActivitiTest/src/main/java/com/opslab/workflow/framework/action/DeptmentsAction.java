package com.opslab.workflow.framework.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.opslab.workflow.framework.entity.business.Deptments;
import com.opslab.workflow.framework.entity.business.UserInfo;
import com.opslab.workflow.framework.entity.view.UIResult;
import com.opslab.workflow.framework.entity.view.UiTree;
import com.opslab.workflow.framework.service.DeptmentsService;

@Controller
@RequestMapping("/admin/dept")
public class DeptmentsAction {
    @Resource(name = "deptmentsService")
    private DeptmentsService service;



    public DeptmentsService getService() {
		return service;
	}

	public void setService(DeptmentsService service) {
		this.service = service;
	}

	@RequestMapping
    public String list() {
        return "admin/dept/deptlist";
    }

    /**
     * 返回所有部门信息的简单的json数据
     *
     * @return
     */
    @RequestMapping("json")
    @ResponseBody
    public List<UiTree> UIList() {
        List<UiTree> re = new ArrayList<>();
        for (Deptments d : service.deptList()) {
            re.add(d.toUiTree());
        }
        return re;
    }


    /**
     * 根据部门ID返回部门信息
     * 之所以返回list是为了前台得到统一格式的JSON数据
     */
    @RequestMapping("info")
    @ResponseBody
    public List<Deptments> deptList(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<Deptments> deptmentses = new ArrayList<>();
        deptmentses.add(service.getDeptByDeptId(request.getParameter("id")));
        return deptmentses;
    }

    /**
     * 跳转到部门添加的页面上
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("add")
    public String add(ModelMap model, HttpServletRequest request) {
        String parentId = request.getParameter("parentId");
        Deptments parentDeptment = service.getDeptByDeptId(parentId);
        model.addAttribute("parentID", parentId);
        model.addAttribute("parentName", parentDeptment.getDetpName());
        return "admin/dept/deptAdd";
    }

    /**
     * 新增部门
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("save")
    @ResponseBody
    public UIResult save(HttpServletRequest request) throws UnsupportedEncodingException {
        String parentId = request.getParameter("parentId");
        String deptName = request.getParameter("deptName");
        if(service.addDept(parentId,deptName)){
            return new UIResult("success","操作成功");
        }
        return new UIResult("error","系统异常");
    }

    /**
     * 删除指定的部门
     * @param request
     * @return
     */
    @RequestMapping("del")
    @ResponseBody
    public UIResult del(HttpServletRequest request){
        String deptId = request.getParameter("deptId");
        service.deleteById(deptId);
        return new UIResult("success","操作成功");
    }

    /**
     * 获取指定部门下有效的用户信息
     * @param request
     * @return
     */
    @RequestMapping("userlist")
    @ResponseBody
    public List<UserInfo> user(HttpServletRequest request){
        String deptId = request.getParameter("deptId");
        return service.getUsers(deptId);
    }
}
