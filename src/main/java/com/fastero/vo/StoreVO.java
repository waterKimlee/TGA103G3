package com.fastero.vo;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
//
public class StoreVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer storeId;
	private String storeName;
	private String storeAddress;
	private String longitude;
	private String latitude;
	private String storePhone;
	private String storeEmail;
	private String storeAdminAccount;
	private String storeAdminPassword;
	private String storeAdminPhone;
	private String storeAdminAddress;
	private String storeImg;
	private String storeIntroduction;
	private byte storeOpenStatus;
	private Integer storeAccountStatus;
	private String storeAdminName;
	private String storeAdminId;
	private Date storeBuildTime;
	private Date storeUpdateTime;
	private Integer storeCommentNumber;
	private Integer storeTotalStar;
	private String storeBusinessTime;
	
	public StoreVO() {
		
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getStorePhone() {
		return storePhone;
	}

	public void setStorePhone(String storePhone) {
		this.storePhone = storePhone;
	}

	public String getStoreEmail() {
		return storeEmail;
	}

	public void setStoreEmail(String storeEmail) {
		this.storeEmail = storeEmail;
	}

	public String getStoreAdminAccount() {
		return storeAdminAccount;
	}

	public void setStoreAdminAccount(String storeAdminAccount) {
		this.storeAdminAccount = storeAdminAccount;
	}

	public String getStoreAdminPassword() {
		return storeAdminPassword;
	}

	public void setStoreAdminPassword(String storeAdminPassword) {
		this.storeAdminPassword = storeAdminPassword;
	}

	public String getStoreAdminPhone() {
		return storeAdminPhone;
	}

	public void setStoreAdminPhone(String storeAdminPhone) {
		this.storeAdminPhone = storeAdminPhone;
	}

	public String getStoreAdminAddress() {
		return storeAdminAddress;
	}

	public void setStoreAdminAddress(String storeAdminAddress) {
		this.storeAdminAddress = storeAdminAddress;
	}

	public String getStoreImg() {
		return storeImg;
	}

	public void setStoreImg(String storeImg) {
		this.storeImg = storeImg;
	}

	public String getStoreIntroduction() {
		return storeIntroduction;
	}

	public void setStoreIntroduction(String storeIntroduction) {
		this.storeIntroduction = storeIntroduction;
	}

	public byte getStoreOpenStatus() {
		return storeOpenStatus;
	}

	public void setStoreOpenStatus(byte storeOpenStatus) {
		this.storeOpenStatus = storeOpenStatus;
	}



	public Integer getStoreAccountStatus() {
		return storeAccountStatus;
	}

	public void setStoreAccountStatus(Integer storeAccountStatus) {
		this.storeAccountStatus = storeAccountStatus;
	}

	public String getStoreAdminName() {
		return storeAdminName;
	}

	public void setStoreAdminName(String storeAdminName) {
		this.storeAdminName = storeAdminName;
	}

	public String getStoreAdminId() {
		return storeAdminId;
	}

	public void setStoreAdminId(String storeAdminId) {
		this.storeAdminId = storeAdminId;
	}

	public Date getStoreBuildTime() {
		return storeBuildTime;
	}

	public void setStoreBuildTime(Date storeBuildTime) {
		this.storeBuildTime = storeBuildTime;
	}

	public Date getStoreUpdateTime() {
		return storeUpdateTime;
	}

	public void setStoreUpdateTime(Date storeUpdateTime) {
		this.storeUpdateTime = storeUpdateTime;
	}

	public Integer getStoreCommentNumber() {
		return storeCommentNumber;
	}

	public void setStoreCommentNumber(Integer storeCommentNumber) {
		this.storeCommentNumber = storeCommentNumber;
	}

	public Integer getStoreTotalStar() {
		return storeTotalStar;
	}

	public void setStoreTotalStar(Integer storeTotalStar) {
		this.storeTotalStar = storeTotalStar;
	}

	public String getStoreBusinessTime() {
		return storeBusinessTime;
	}

	public void setStoreBusinessTime(String storeBusinessTime) {
		this.storeBusinessTime = storeBusinessTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public StoreVO(Integer storeId, String storeName, String storeAddress, String longitude, String latitude,
			String storePhone, String storeEmail, String storeAdminAccount, String storeAdminPassword,
			String storeAdminPhone, String storeAdminAddress, String storeImg, String storeIntroduction,
			byte storeOpenStatus, Integer storeAccountAtatus, String storeAdminName, String storeAdminId,
			Date storeBuildTime, Date storeUpdateTime, Integer storeCommentNumber, Integer storeTotalStar,
			String storeBusinessTime) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.storeAddress = storeAddress;
		this.longitude = longitude;
		this.latitude = latitude;
		this.storePhone = storePhone;
		this.storeEmail = storeEmail;
		this.storeAdminAccount = storeAdminAccount;
		this.storeAdminPassword = storeAdminPassword;
		this.storeAdminPhone = storeAdminPhone;
		this.storeAdminAddress = storeAdminAddress;
		this.storeImg = storeImg;
		this.storeIntroduction = storeIntroduction;
		this.storeOpenStatus = storeOpenStatus;
		this.storeAccountStatus = storeAccountAtatus;
		this.storeAdminName = storeAdminName;
		this.storeAdminId = storeAdminId;
		this.storeBuildTime = storeBuildTime;
		this.storeUpdateTime = storeUpdateTime;
		this.storeCommentNumber = storeCommentNumber;
		this.storeTotalStar = storeTotalStar;
		this.storeBusinessTime = storeBusinessTime;
	}

	

}
