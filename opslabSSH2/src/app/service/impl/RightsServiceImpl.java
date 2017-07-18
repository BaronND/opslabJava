package app.service.impl;

import app.constant.config;
import app.dao.RightsDao;
import app.entries.EntryPage;
import app.entries.Rights;
import app.entries.UiTree;
import app.service.RightsService;
import app.service.sql.RightsSQL;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("rightsService")
public class RightsServiceImpl extends SupportServiceImpl<Rights> implements RightsService {

	@Resource(name="rightsDao")
	@Getter @Setter private RightsDao dao;
	

	@Override
	public EntryPage getQuery(int page,int size){
		String hql =RightsSQL.HQL_ALL_RIGHTS;
		EntryPage entryPage = dao.query(hql, page, size);
		return entryPage;
	}

	
	@Override
	public void save(Rights model) {
		int rightPos = 0;
		Long rightCode = 1L;
		if(model.getRightsId() == null){
			Rights tRights = dao.queryEntry(RightsSQL.HQL_MAX_RIGHTSCODE);
			Rights pRights = dao.getEntry(Integer.parseInt(model.getGroupId()));
			if(null != tRights){
				rightPos = tRights.getRightsGroup();
				if(tRights.getRightsCode() > (1L << 60)){
					rightPos += 1;
					rightCode = 1L;
				}else{
					rightCode = tRights.getRightsCode() <<1;
				}
				if(config.ROOT_OF_TREE.equals(pRights.getRootId())){
					Rights rRights = dao.queryEntry(RightsSQL.HQL_MAX_ROOTID);
					model.setRootId(rRights.getRootId()+"1");
					model.setGroupId("");
				}else{
					model.setRootId(pRights.getRootId());
					model.setGroupId(pRights.getRightsId().toString());
				}
			}
		}else{
			//修改(可以在功能表中添加字段以表示該功能是启用，此处不做任何操作，
			//此处的修改不包包括功能的权限组和权限码的修改)
		}
		model.setRightsGroup(rightPos);
		model.setRightsCode(rightCode);
		super.saveOrUpdate(model);
	}

	
	@Override
	public List<UiTree> getBranchList(){
		List<Rights> pList = dao.getEntryListByHQL(RightsSQL.HQL_BRANCH_RIGHTS);
		List<UiTree> list = UiTree.trimPList(Rights.Rights2UiTree(pList));
		return list;
	}
	
	@Override
	public List<UiTree> getRootList(){
		List<Rights> pList = dao.getEntryListByHQL(RightsSQL.HQL_MENU_LIST);
		List<UiTree> list = UiTree.trimPList(Rights.Rights2UiTree(pList));
		return list;
	}

	@Override
	public List<?> getMenuList() {
		List<Rights> pList = dao.getEntryListByHQL(RightsSQL.HQL_BRANCH_RIGHTS);
		List<Rights> cList = dao.getEntryListByHQL(RightsSQL.HQL_LEAF_RIGHTS);
		List<UiTree> list = UiTree.trimPList(Rights.Rights2UiTree(pList), Rights.Rights2UiTree(cList));
		return list;
	}

	@Override
	public List<?> getMenuList(String id) {
		List<Rights> pList = dao.getEntryListByHQL(RightsSQL.HQL_BRANCH_RIGHTS_TYPE,new Object[]{id});
		List<Rights> cList = dao.getEntryListByHQL(RightsSQL.HQL_LEAF_RIGHTS_TYPE,new Object[]{id});
		List<UiTree> list = UiTree.trimPList(Rights.Rights2UiTree(pList), Rights.Rights2UiTree(cList));
		return list;
	}

	@Override
	public List<Rights> getMenuListAll() {
		List<Rights> pList = dao.getEntryListByHQL(RightsSQL.HQL_BRANCH_RIGHTS);
		List<Rights> cList = dao.getEntryListByHQL(RightsSQL.HQL_LEAF_RIGHTS);
		List<Rights> list = Rights.packListForJson(pList,cList);
		return list;
	}


	@Override
	public Rights getRightsById(Integer id) {
		return dao.getEntry(id);
	}


}
