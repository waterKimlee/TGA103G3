package com.storetype.model;

import java.sql.Date;

public class StoreTypeVO {

	private Integer storeTypeId;
	private Integer storeId;
	private String storeType;
	private Date storeTypeUpdateTime;
	
	
	public Integer getStoreTypeId() {
		return storeTypeId;
	}
	public void setStoreTypeId(Integer storeTypeId) {
		this.storeTypeId = storeTypeId;
	}
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	public String getStoreType() {
		return storeType;
	}
	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}
	public Date getStoreTypeUpdateTime() {
		return storeTypeUpdateTime;
	}
	public void setStoreTypeUpdateTime(Date storeTypeUpdateTime) {
		this.storeTypeUpdateTime = storeTypeUpdateTime;
	}
	
}
