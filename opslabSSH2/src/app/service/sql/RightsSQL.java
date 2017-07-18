package app.service.sql;

import app.constant.config;

public class RightsSQL {
	
	//查询所有
	public static final String HQL_ALL_RIGHTS=
				"from Rights t where t.isValid ='1'";
	
	//查询最顶层的权限类别
	public static final String HQL_ROOT_BRANCH=
				"from Rights t where t.rootId is not null and t.groupId is null";

	
	//查询所有管理权限结构
	public static final String HQL_BRANCH_RIGHTS =
				"from Rights t where t.isBranch = '1'";
	
	//查询所有有效的权限实体
	public static final String HQL_LEAF_RIGHTS =
				"from Rights t where t.isBranch != '1'";
	
	//查询某一类管理权限结构
	public static final String HQL_BRANCH_RIGHTS_TYPE =
				"from Rights t where t.isBranch = '1' and t.rootId = ?";
	
	//查询所有有效的权限实体
	public static final String HQL_LEAF_RIGHTS_TYPE =
				"from Rights t where t.isBranch != '1' and t.rootId = ?";

	//查询最大的权限码
	public static final String HQL_MAX_RIGHTSCODE =
				"from Rights t  order by t.rightsGroup desc,t.rightsCode desc";
	
	// 查询菜单结果集
	public static final String HQL_MENU_LIST = 
			  	"from Rights t where  t.rightsId !='"+config.ROOT_OF_TREE+"' and t.rootId is not null and t.groupId ='"+config.ROOT_OF_TREE+"'";
	
	//根据业务主键ID获取业务实体
	public static final String HQL_QUERY_ENTRY_WITDID =
				"FROM Rights t where t.rightsId = ?";
	
	//查询rootId最大的实体
	public static final String HQL_MAX_ROOTID =
				"FROM Rights t where t.isBranch ='1' order by t.rootId desc";

}
