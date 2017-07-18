package com.opslab.framework.base.action;

import com.opslab.framework.base.entity.GeneralCode;
import com.opslab.framework.base.service.GeneralCodeService;
import com.opslab.framework.base.entity.view.UiCode;
import com.opslab.framework.base.service.CodeService;
import com.opslab.framework.base.service.CommonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 0opslab
 * @date on 2016/6/15 0015.
 */
@Controller
@RequestMapping("/")
public class CodeAction {


    @Resource(name = "codeService")
    private CodeService codeService;

    @RequestMapping("codemap/{codeType}")
    @ResponseBody
    public List<UiCode> codeMap(@PathVariable("codeType")String codeType){
        return codeService.codeMap(codeType.toUpperCase());
    }
}
