package app.struts.action;

import app.annotation.ActionClass;
import app.annotation.ActionMethod;
import app.annotation.ActionType;
import app.entries.BusinessLog;
import app.entries.EntryPage;
import app.service.BusinessLogService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller("businessLogAction")
@ActionClass("业务日志Action")
public class BusinessLogAction extends SupportAction<BusinessLog>{

	@Resource(name="businessLogService")
	@Getter @Setter private BusinessLogService service;
	
	@ActionMethod(type=ActionType.BUSINESS,name="展现业务日志")
	public String exec_list(){
		EntryPage list = service.getPage(page, size);
		requestMap.put("entrypage", list);
		return SUCCESS;
	}
	
	@ActionMethod(type=ActionType.BUSINESS,name="ajax返回业务日志")
	public String exec_ajaxlist(){
		EntryPage list = service.getPage(page, size);
		printJSON(list.getList());
		return null;
	}
}
