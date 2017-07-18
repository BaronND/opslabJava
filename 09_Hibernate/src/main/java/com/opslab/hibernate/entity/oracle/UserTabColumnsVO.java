package com.opslab.hibernate.entity.oracle;

public class UserTabColumnsVO {
	private String tableName;
	
	private String columnName;
	
	private String dataType;
	
	private String dataLength;
	
	private String nullAble;
	
	private String columnId;
	
	public UserTabColumnsVO(){}
	
	

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getDataLength() {
		return dataLength;
	}

	public void setDataLength(String dataLength) {
		this.dataLength = dataLength;
	}

	public String getNullAble() {
		return nullAble;
	}

	public void setNullAble(String nullAble) {
		this.nullAble = nullAble;
	}

	public String getColumnId() {
		return columnId;
	}

	public void setColumnId(String columnId) {
		this.columnId = columnId;
	}

	@Override
	public String toString() {
		return "UserTabColumnsVO [tableName=" + tableName + ", columnName=" + columnName + ", dataType=" + dataType + ", dataLength=" + dataLength + ", nullAble=" + nullAble + ", columnId=" + columnId + "]";
	}
	
}
