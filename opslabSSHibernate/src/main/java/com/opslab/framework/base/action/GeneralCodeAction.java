package com.opslab.framework.base.action;

import com.opslab.framework.base.entity.GeneralCode;
import com.opslab.framework.base.service.GeneralCodeService;
import com.opslab.framework.base.entity.view.UIResult;
import com.opslab.util.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Scanner;

/**
 * @author 0opslab
 * @date on 2016/6/25 0025.
 */
@Controller
@RequestMapping("/admin/code")
public class GeneralCodeAction {
    @Resource(name = "generalCodeService")
    private GeneralCodeService service;


    @RequestMapping
    public String code() {
        return "admin/generalCode-list";
    }

    /**
     * 获取编码类型树
     *
     * @return
     */
    @RequestMapping("codelist")
    @ResponseBody
    public List<GeneralCode> generalCodeList() {
        return service.getGeneralList();
    }

    @RequestMapping({"info/{codeType}"})
    public String codeTypeList(
            @PathVariable("codeType") String codeType,
            ModelMap model) {
        GeneralCode code = service.getCodeId(codeType);
        model.put("code",code);
        model.put("codeCount", service.codeCount(codeType));
        model.put("codeType", codeType);
        return "admin/generalCodeInfo";
    }

    @RequestMapping("list/{codeType}")
    @ResponseBody
    public List<GeneralCode> codeList(
            @PathVariable("codeType") String codeType,
            @RequestParam int page,
            @RequestParam int rows) {
        return service.codeTypeList(codeType.toUpperCase(), page, rows);
    }

    @RequestMapping("add/{codeType}")
    public String add(@PathVariable("codeType") String codeType, ModelMap model) {
        model.put("codeType", codeType);
        model.put("parentId",codeType);
        model.put("tree","COMMON");
        return "admin/generalCodeAdd";
    }

    @RequestMapping("addtype/{codeType}")
    public String addType(@PathVariable("codeType") String codeType, ModelMap model) {
        model.put("codeType", codeType);
        if("SYS_CODE".equals(codeType)){
            model.put("parentId","ROOT");
        }else{
            model.put("parentId",codeType);
        }
        model.put("tree","SYS_CODE");
        return "admin/generalCodeAdd";
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


    @RequestMapping("save")
    @ResponseBody
    public UIResult add(GeneralCode form){
        form.setCreateTime(DateUtil.currentDateTime());
        service.save(form);
        return UIResult.success();
    }

}
