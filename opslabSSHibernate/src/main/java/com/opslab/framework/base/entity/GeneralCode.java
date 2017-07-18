package com.opslab.framework.base.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <p>常用的字典</p>
 * 可以支持树形编码
 *
 * @date 2015-06-15.
 */
public class GeneralCode {
    //实体ID
	@JsonProperty("key")
    private String id;

    //编码ID
	@JsonProperty("id")
    private String codeId;

	//父id编码
	@JsonProperty("pId")
	private String partenId;

    //编码名称
	@JsonProperty("name")
    private String codeName;

    //编码类型
    private String codeType;

    //排序ID
    private String orderId;

    //创建时间
    private String createTime;

	//是否为树形编码
	private String tree;

    //是否有效
    private String valid;

	//完整的名字
	private String path;

    //备注
    private String memo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	public String getPartenId() {
		return partenId;
	}

	public void setPartenId(String partenId) {
		this.partenId = partenId;
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

	public String getTree() {
		return tree;
	}

	public void setTree(String tree) {
		this.tree = tree;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "GeneralCode{" +
				"codeId='" + codeId + '\'' +
				", codeType='" + codeType + '\'' +
				", codeName='" + codeName + '\'' +
				", partenId='" + partenId + '\'' +
				'}';
	}
}
