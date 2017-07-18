package app.struts.action;

import app.annotation.ActionMethod;
import app.annotation.ActionType;
import app.entries.EntryPage;
import app.entries.${entries};
import app.service.${entries}Service;
import app.util.sec;
import lombok.Getter;
import lombok.Setter;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller("${entriesAction}")
@Scope("prototype")
public class ${entries}Action extends SupportAction<${entries}> {

    @Resource(name="${entriesService}")
    @Getter @Setter private ${entries}Service service;

    @ActionMethod(type=ActionType.BUSINESS,name="新增")
    public String exec_add(){
    service.save(this.model);
    return SUCCESS;
    }



}
