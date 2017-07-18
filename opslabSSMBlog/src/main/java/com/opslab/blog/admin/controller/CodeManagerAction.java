package com.opslab.blog.admin.controller;

import com.google.common.collect.ImmutableMap;
import com.opslab.blog.admin.APP;
import com.opslab.blog.admin.annotation.ActionInfo;
import com.opslab.blog.admin.domain.GeneralCode;
import com.opslab.blog.admin.service.CodeManagerService;
import com.opslab.blog.util.DateUtil;
import com.opslab.blog.admin.webentity.UIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


/**
 * @author 0opslab
 * @Descript 系统编码管理
 */
@Controller
@RequestMapping("/admin/code")
public class CodeManagerAction {

    @Autowired
    private CodeManagerService codeService;


    @RequestMapping
    public String index(ModelMap model) {
        model.put("count", 0);
        return "admin/CodeManagerList";
    }


    @RequestMapping("typelist")
    @ResponseBody
    @ActionInfo("获取编码分类列表")
    public UIResult codeList() {
        return UIResult.success(APP.success,codeService.codeList());
    }

    @RequestMapping("/typecodelist")
    @ResponseBody
    @ActionInfo("获取编码分类的所有编码值")
    public List<GeneralCode> codeMap(@RequestParam String type) {
        return codeService.codeType(type.toUpperCase(), APP.STATUS_VALID);
    }


    @RequestMapping("/typedelete")
    @ResponseBody
    @ActionInfo("删除编码分类")
    public UIResult deleteType(@RequestParam int key) {
        GeneralCode generalCode = codeService.codeByKey(key);
        if (generalCode == null) {
            return UIResult.error("相关记录不存在");
        }
        if(APP.STATUS_INVALID.equals(generalCode.getValid())){
            return UIResult.error("相关记录不存在");
        }
        if (APP.TREE_TYPE_BRANCH.equals(generalCode.getTreeType())
                || APP.TREE_TYPE_ROOT.equals(generalCode.getTreeType())) {

            List<GeneralCode> list= codeService.codeType(generalCode.getCodeId(),APP.STATUS_VALID);
            if(list.size() > 0){
                return UIResult.error("分类存在编码值无法删除");
            }
            int updateValid = codeService.updateValid(key, APP.STATUS_INVALID);
            return UIResult.notZero(updateValid,"删除成功","删除失败");
        }else{
            return UIResult.error("相关记录不是编码分类");
        }
    }

    @RequestMapping({"typeinfo"})
    @ResponseBody
    @ActionInfo("获取编码分类信息")
    public Map<Object, Object> typeInfo(@RequestParam String type) {
        ImmutableMap<Object, Object> params = ImmutableMap.builder().
                put("codeId", type.toUpperCase())
                .put("treeType", APP.TREE_TYPE_BRANCH)
                .build();

        GeneralCode generalCode = codeService.oneCode(params);
        int count = codeService.codeCountByType(type.toUpperCase(), APP.STATUS_VALID);
        ImmutableMap<Object, Object> result = ImmutableMap.builder().
                put("code", generalCode)
                .put("count", count)
                .build();
        return result;
    }


    @RequestMapping("/typeadd")
    @ResponseBody
    @ActionInfo("添加编码分类")
    public UIResult typeAdd(@RequestParam String parentId,@RequestParam String name,@RequestParam String codeType
            ,@RequestParam String memo) {
        GeneralCode generalCode = new GeneralCode(codeType, parentId, name, parentId, 1, DateUtil.currentDateTime(),
                APP.TREE_TYPE_BRANCH, APP.STATUS_VALID, memo);

        int save = codeService.save(generalCode);
        return UIResult.notZero(save,"添加成功","添加失败");
    }

    @RequestMapping("/typeeidt")
    @ResponseBody
    @ActionInfo("更新编码分类")
    public UIResult typeEdit(@RequestParam String parentId,@RequestParam String name,@RequestParam String codeType
            ,@RequestParam String memo) {
        GeneralCode generalCode = new GeneralCode(codeType, parentId, name, parentId, 1, DateUtil.currentDateTime(),
                APP.TREE_TYPE_BRANCH, APP.STATUS_VALID, memo);

        int save = codeService.save(generalCode);
        return UIResult.notZero(save,"更新成功","更新失败");
    }



    @RequestMapping("/codedelete")
    @ResponseBody
    @ActionInfo("删除编码值")
    public UIResult codedelete(@RequestParam int key) {
        GeneralCode generalCode = codeService.codeByKey(key);
        if (generalCode == null) {
            return UIResult.error("相关记录不存在");
        }
        if (APP.TREE_TYPE_LEAF.equals(generalCode.getCodeType())) {
            int updateValid = codeService.updateValid(key, APP.STATUS_INVALID);
            return UIResult.notZero(updateValid,"删除成功","删除失败");
        }else{
            return UIResult.error("只支持删除编码，不支持删除编码分类");
        }
    }

    @RequestMapping("/codeadd")
    @ResponseBody
    @ActionInfo("增加编码值")
    public UIResult codeAdd(@RequestParam String parentId,@RequestParam String name,@RequestParam String codeId,
            @RequestParam int orderId,@RequestParam  String memo ) {

        GeneralCode generalCode = new GeneralCode(codeId, "", name, parentId, orderId, DateUtil.currentDateTime(),
                APP.TREE_TYPE_LEAF, APP.STATUS_VALID, memo);

        int save = codeService.save(generalCode);
        return UIResult.notZero(save,"添加成功","添加失败");
    }

    @RequestMapping("/codeinfo")
    @ResponseBody
    @ActionInfo("增加编码值")
    public UIResult codeInfo(@RequestParam int key) {
        GeneralCode generalCode = codeService.codeByKey(key);
        if (generalCode == null) {
            return UIResult.error("相关记录不存在");
        }
        return  UIResult.success(APP.success,generalCode);
    }

    @RequestMapping("/codeeidt")
    @ResponseBody
    @ActionInfo("更新编码值信息")
    public UIResult codeEdit(@RequestParam int key) {
        GeneralCode generalCode = codeService.codeByKey(key);
        if (generalCode == null) {
            return UIResult.error("相关记录不存在");
        }
        return  UIResult.success(APP.success,generalCode);
    }

}
