package com.opslab.workflow.framework.entity.business;

/**
 * <h6>Description:<h6>
 * <p>常用的字典</p>
 *
 * @date 2015-06-15.
 */
public class GeneralCode {
    //实体ID
    private Integer id;

    //编码ID
    private String codeId;

    //编码名称
    private String codeName;

    //编码类型
    private String codeType;

    //排序ID
    private String orderId;

    //创建时间
    private String createTime;

    //是否有效
    private String valid;

    //备注
    private String memo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
    
}
