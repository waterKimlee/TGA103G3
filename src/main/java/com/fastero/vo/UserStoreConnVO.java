package com.fastero.vo;

import java.sql.Date;

public class UserStoreConnVO {
	
	private Integer userId;
	private Integer storeId;
	private Integer status;
	private Date statusUpdateTime;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getStatusUpdateTime() {
		return statusUpdateTime;
	}
	public void setStatusUpdateTime(Date statusUpdateTime) {
		this.statusUpdateTime = statusUpdateTime;
	}
	
	
	
}
