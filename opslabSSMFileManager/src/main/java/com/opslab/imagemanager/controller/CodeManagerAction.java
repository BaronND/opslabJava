package com.opslab.imagemanager.controller;

import com.google.common.collect.ImmutableMap;
import com.opslab.imagemanager.APPManager;
import com.opslab.imagemanager.domain.GeneralCode;
import com.opslab.imagemanager.service.GeneralCodeService;
import com.opslab.imagemanager.webentity.UIResult;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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
    private static Logger logger = LogManager.getLogger(CodeManagerAction.class);


    @Autowired
    private GeneralCodeService codeService;


    @RequestMapping
    public String index(ModelMap model) {
        model.put("count", 0);
        return "admin/CodeManagerList";
    }

    @RequestMapping("codelist")
    @ResponseBody
    public List<GeneralCode> codeList() {
        List<GeneralCode> generalCodes = codeService.codeList();
        return generalCodes;
    }

    @RequestMapping("/typelist")
    @ResponseBody
    public List<GeneralCode> codeMap(@RequestParam String type) {
        List<GeneralCode> generalCodes = codeService.codeType(type.toUpperCase(), APPManager.STATUS_VALID);
        return generalCodes;
    }

    /**
     * 停用编码
     *
     * @param key
     * @return
     */
    @RequestMapping("/typedelete")
    @ResponseBody
    public UIResult deleteType(@RequestParam int key) {
        //增加一些判断比如目录不能停用，只能停用普通编码
//        int update = codeService.updateValid(key, APPManager.STATUS_VALID);
//        if(update == 1){
//            return UIResult.success("操作成功");
//        }
//        return UIResult.error("操作失败");
        return UIResult.error("暂不支持编码分类删除");
    }


    @RequestMapping("/delete")
    @ResponseBody
    public UIResult delete(@RequestParam int key) {
        GeneralCode generalCode = codeService.codeByKey(key);
        if (generalCode == null) {
            return UIResult.error("相关记录不存在");
        }
        if ("".equals(generalCode.getCodeType())) {

        }
        return UIResult.error("只支持编码制，不支持删除编码分类");
    }


    @RequestMapping({"typeinfo"})
    @ResponseBody
    public Map<Object, Object> codeTypeList(@RequestParam String type) {
        String codeType = type.toUpperCase();
        GeneralCode generalCode = codeService.codeById(codeType);
        int count = codeService.codeCountByType(codeType, "1");
        ImmutableMap<Object, Object> result = ImmutableMap.builder().
                put("code", generalCode)
                .put("count", count)
                .build();
        return result;
    }
}
