package com.fastero.vo;


import java.io.Serializable;
import java.sql.Date;


public class UserVO implements Serializable{
	
	//'userId', 'userAccount', 'userPassword', 'userName', 'userPhone', 'userBuildTime', 'userStatus'
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
	private String userAccount;
	private String userPassword;
	private String userName;
	private String userPhone;
	private Date userBuildTime;
	private byte userStatus;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
	public Date getUserBuildTime() {
		return userBuildTime;
	}
	public void setUserBuildTime(Date userBuildTime) {
		this.userBuildTime = userBuildTime;
	}
	public byte getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(byte userStatus) {
		this.userStatus = userStatus;
	}
	

}
