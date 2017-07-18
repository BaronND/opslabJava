package app.struts.action;

import app.annotation.ActionClass;
import app.annotation.ActionMethod;
import app.annotation.ActionType;
import app.entries.EntryPage;
import app.entries.GeneralCode;
import app.service.GeneralCodeService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * <h6>Description:<h6>
 * <p></p>
 *
 * @date 2015-06-15.
 */
@Controller("generalCodeAction")
@ActionClass("常用编码Action")
public class GeneralCodeAction extends SupportAction<GeneralCode> {

    @Resource(name = "generalCodeService")
    @Getter @Setter private GeneralCodeService service;

    @ActionMethod(type= ActionType.BUSINESS,name="展现常用字典")
    public String exec_list(){
        EntryPage list = service.getPage(page, size);
        requestMap.put("entrypage", list);
        return SUCCESS;
    }

}
