package com.opslab.hibernate.entity.oracle;

/**
 * @description 映射Oracle user_tables系统视图 
 *
 */
public class UserTablesVO {
	private String tableName;
	
	private String tableSpaceName;
	
	private String status;
	
	private String logging;
	
	
	public UserTablesVO(){}
	
	
	public UserTablesVO(String tableName, String tableSpaceName) {
		this.tableName = tableName;
		this.tableSpaceName = tableSpaceName;
	}


	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableSpaceName() {
		return tableSpaceName;
	}

	public void setTableSpaceName(String tableSpaceName) {
		this.tableSpaceName = tableSpaceName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLogging() {
		return logging;
	}

	public void setLogging(String logging) {
		this.logging = logging;
	}

	@Override
	public String toString() {
		return "UserTablesVO [tableName=" + tableName + ", tableSpaceName=" + tableSpaceName + ", status=" + status + ", logging=" + logging + "]";
	}
}
