package com.opslab.hibernate.entity.extend.joined;

/**
 * @description  商品的基本特征
 */
public class goods {
	private Integer goodsId;
	
	private String  goodsName;
	
	private String  goodsFunction;

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsFunction() {
		return goodsFunction;
	}

	public void setGoodsFunction(String goodsFunction) {
		this.goodsFunction = goodsFunction;
	}
}
