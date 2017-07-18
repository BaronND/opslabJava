package com.opslab.framework.base.action;

import com.opslab.framework.base.entity.Deptments;
import com.opslab.framework.base.entity.UserInfo;
import com.opslab.framework.base.service.DeptmentsService;
import com.opslab.framework.base.entity.view.UIResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/admin/dept")
public class DeptmentsAction {
    @Resource(name = "deptmentsService")
    private DeptmentsService service;


    @RequestMapping
    public String dept() {
        return "admin/dept-list";
    }

    /**
     * 返回所有部门信息
     */
    @RequestMapping("list")
    @ResponseBody
    public List<Deptments> list() {
        return service.deptList();
    }


    /**
     * 根据部门ID返回部门信息
     * 之所以返回list是为了前台得到统一格式的JSON数据
     */
    @RequestMapping("info/{deptId}")
    public String deptInfo(
            @PathVariable("deptId") String deptId,
            ModelMap model
    ) {
        Deptments deptments = service.getDeptByDeptId(deptId);
        Long countUser = service.countUser(deptId);

        model.put("countUser", countUser);
        model.put("dept", deptments);
        return "admin/deptInfo";
    }

    /**
     * 跳转到部门添加的页面上
     *
     * @param model
     * @return
     */
    @RequestMapping("add")
    public String add(@RequestParam String parentId, ModelMap model) {
        Deptments parentDeptment = service.getDeptByDeptId(parentId);
        model.addAttribute("parentID", parentId);
        model.addAttribute("parentName", parentDeptment.getDetpName());
        return "admin/deptAdd";
    }

    /**
     * 新增部门
     *
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("save")
    @ResponseBody
    public UIResult save(HttpServletRequest request) throws UnsupportedEncodingException {
        String parentId = request.getParameter("parentId");
        String deptName = request.getParameter("deptName");
        if (service.addDept(parentId, deptName)) {
            return new UIResult("success", "操作成功");
        }
        return new UIResult("error", "系统异常");
    }

    /**
     * 删除指定的部门
     */
    @RequestMapping("del")
    @ResponseBody
    public UIResult del(@RequestParam String deptId) {
        service.deleteById(deptId);
        return new UIResult("success", "操作成功");
    }

    /**
     * 获取指定部门下有效的用户信息
     */
    @RequestMapping("userlist/{deptId}")
    @ResponseBody
    public List<UserInfo> user(@PathVariable("deptId") String deptId,
                               @RequestParam int page,
                               @RequestParam int rows) {
        return service.getUsers(deptId, page, rows);
    }
}
