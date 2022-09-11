package com.administrator.model;

import java.sql.Date;

public class AdministratorVO implements java.io.Serializable{
	
	private Integer administratorId;
	private String administratorAccount;
	private String administratorPassword;
	private String administratorName;
	private String administratorPhone;
	private Date administratorAccountBuildTime;
	private Integer administratorRight;
	
	
	public Integer getAdministratorId() {
		return administratorId;
	}
	public void setAdministratorId(Integer administratorId) {
		this.administratorId = administratorId;
	}
	public String getAdministratorAccount() {
		return administratorAccount;
	}
	public void setAdministratorAccount(String administratorAccount) {
		this.administratorAccount = administratorAccount;
	}
	public String getAdministratorPassword() {
		return administratorPassword;
	}
	public void setAdministratorPassword(String administratorPassword) {
		this.administratorPassword = administratorPassword;
	}
	public String getAdministratorName() {
		return administratorName;
	}
	public void setAdministratorName(String administratorName) {
		this.administratorName = administratorName;
	}
	public String getAdministratorPhone() {
		return administratorPhone;
	}
	public void setAdministratorPhone(String administratorPhone) {
		this.administratorPhone = administratorPhone;
	}
	public Date getAdministratorAccountBuildTime() {
		return administratorAccountBuildTime;
	}
	public void setAdministratorAccountBuildTime(Date administratorAccountBuildTime) {
		this.administratorAccountBuildTime = administratorAccountBuildTime;
	}
	public Integer getAdministratorRight() {
		return administratorRight;
	}
	public void setAdministratorRight(Integer administratorRight) {
		this.administratorRight = administratorRight;
	}
	
	@Override
	public String toString() {
		return "AdministratorVO [administratorId=" + administratorId + ", administratorAccount=" + administratorAccount
				+ ", administratorPassword=" + administratorPassword + ", administratorName=" + administratorName
				+ ", administratorPhone=" + administratorPhone + ", administratorAccountBuildTime="
				+ administratorAccountBuildTime + ", administratorRight=" + administratorRight + "]";
	}

}
