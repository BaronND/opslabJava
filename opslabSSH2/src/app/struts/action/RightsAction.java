package app.struts.action;

import app.annotation.ActionMethod;
import app.annotation.ActionType;
import app.entries.EntryPage;
import app.entries.Rights;
import app.service.RightsService;
import app.util.sec;
import lombok.Getter;
import lombok.Setter;
import net.sf.json.JSONArray;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller("rightsAction")
@Scope("prototype")
public class RightsAction extends SupportAction<Rights> {

	@Resource(name="rightsService")
	@Getter @Setter private RightsService service;
	
	@ActionMethod(type=ActionType.BUSINESS,name="新增权限")
	public String exec_add(){
		service.save(this.model);
		return SUCCESS;
	}
	
	
	@ActionMethod(type=ActionType.BUSINESS,name="列出权限列表")
	public String exec_list(){
		EntryPage entryPage = service.getQuery(this.page,this.size);
		requestMap.put("entrypage", entryPage);
		return "list_page";
	}
	
	@ActionMethod(type=ActionType.BUSINESS,name="列出所有的根权限")
	public String exec_listroot(){
		List<?> list = service.getRootList(); 
		JSONArray jsonArray = JSONArray.fromObject( list );
		printJSON(jsonArray);
		return null; 
	}

	@ActionMethod(type=ActionType.BUSINESS,name="权限ajax分页查询")
	public String exec_listpage(){
		EntryPage entryPage = service.getQuery(this.page,this.size);
		List<?> list = entryPage.getList(); 
		JSONArray jsonArray = JSONArray.fromObject( list );
		printJSON(jsonArray);
		return null; 
	}

	@ActionMethod(type=ActionType.BUSINESS,name="ajax返回树形菜单数据集")
	public String exec_listmenuall(){
		List<?> list = service.getMenuListAll();
		JSONArray jsonArray = JSONArray.fromObject( list );
		printJSON(jsonArray);
		return null;
	}
	
	@ActionMethod(type=ActionType.BUSINESS,name="ajax权限类型")
	public String exec_listtype(){
		List<?> list = new ArrayList<>();
		if(sec.isSec(this.id)){
			list =service.getMenuList(id);
		}
		JSONArray jsonArray = JSONArray.fromObject( list );	
		printJSON(jsonArray);
		return null;
	}

	@ActionMethod(type=ActionType.BUSINESS,name="返回菜单")
	public String exec_listmenu(){
		List<?> list =  service.getMenuList();
		JSONArray jsonArray = JSONArray.fromObject( list );	
		printJSON(jsonArray);
		return null;
	}
	
	
	@ActionMethod(type=ActionType.BUSINESS,name="ajax返回权限目录结构")
	public String exec_listbranch(){
		List<?> list = service.getBranchList();
		JSONArray jsonArray = JSONArray.fromObject( list );
		printJSON(jsonArray);
		return null;
	}
}
