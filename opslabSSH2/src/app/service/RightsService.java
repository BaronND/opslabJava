package app.service;

import java.util.List;

import app.annotation.ServiceMethod;
import app.annotation.ServiceType;
import app.entries.EntryPage;
import app.entries.Rights;
import app.entries.UiTree;

public interface RightsService extends SupportService<Rights>{
	
	@Override
	@ServiceMethod(type=ServiceType.BUSINESS,name="权限保存")
	public void save(Rights model);
	
	@ServiceMethod(type=ServiceType.BUSINESS,name="权限分页")
	public EntryPage getQuery(int page,int size);
	
	@ServiceMethod(type=ServiceType.BUSINESS,name="获取权限列表 ")
	public List<?> getMenuList();
	
	@ServiceMethod(type=ServiceType.BUSINESS,name="获取某根权限列表 ")
	public List<?> getMenuList(String id);
	
	@ServiceMethod(type=ServiceType.BUSINESS,name="获取安全权限用于权限页面管理")
	public List<Rights> getMenuListAll();
	
	@ServiceMethod(type=ServiceType.BUSINESS,name="获取权限的目录结构 ")
	public List<?> getBranchList();
	
	@ServiceMethod(type=ServiceType.BUSINESS,name="获取权限的类别 ")
	public List<UiTree> getRootList();
	
	@ServiceMethod(type=ServiceType.BUSINESS,name="根据主键获取业务实体")
	public Rights getRightsById(Integer id);
}
