package com.fastero.vo;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
//
public class StoreVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer storeID;
	private String storename;
	private String storeaddress;
	private String longitude;
	private String latitude;
	private String storephone;
	private String storeemail;
	private String storeadminaccount;
	private String storeadminpassword;
	private String storeadminphone;
	private String storeadminaddress;
	private Blob storeimg;
	private String storeintroduction;
	private byte storeopenstatus;
	private Integer storeaccountstatus;
	private String storeadminname;
	private String storeadminID;
	private Date storebuildtime;
	private Date storeupdtetime;
	private Integer storecommentnumber;
	private Integer storetotalstar;
	private String storebusinesstime;
	
	public StoreVO() {
		
	}

	public StoreVO(Integer storeID, String storename, String storeaddress, String longitude, String latitude,
			String storephone, String storeemail, String storeadminaccount, String storeadminpassword,
			String storeadminphone, String storeadminaddress, Blob storeimg, String storeintroduction,
			byte storeopenstatus, Integer storeaccountstatus, String storeadminname, String storeadminID,
			Date storebuildtime, Date storeupdtetime, Integer storecommentnumber, Integer storetotalstar,
			String storebusinesstime) {
		super();
		this.storeID = storeID;
		this.storename = storename;
		this.storeaddress = storeaddress;
		this.longitude = longitude;
		this.latitude = latitude;
		this.storephone = storephone;
		this.storeemail = storeemail;
		this.storeadminaccount = storeadminaccount;
		this.storeadminpassword = storeadminpassword;
		this.storeadminphone = storeadminphone;
		this.storeadminaddress = storeadminaddress;
		this.storeimg = storeimg;
		this.storeintroduction = storeintroduction;
		this.storeopenstatus = storeopenstatus;
		this.storeaccountstatus = storeaccountstatus;
		this.storeadminname = storeadminname;
		this.storeadminID = storeadminID;
		this.storebuildtime = storebuildtime;
		this.storeupdtetime = storeupdtetime;
		this.storecommentnumber = storecommentnumber;
		this.storetotalstar = storetotalstar;
		this.storebusinesstime = storebusinesstime;
	}

	public Integer getStoreID() {
		return storeID;
	}

	public void setStoreID(Integer storeID) {
		this.storeID = storeID;
	}

	public String getStorename() {
		return storename;
	}

	public void setStorename(String storename) {
		this.storename = storename;
	}

	public String getStoreaddress() {
		return storeaddress;
	}

	public void setStoreaddress(String storeaddress) {
		this.storeaddress = storeaddress;
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

	public String getStorephone() {
		return storephone;
	}

	public void setStorephone(String storephone) {
		this.storephone = storephone;
	}

	public String getStoreemail() {
		return storeemail;
	}

	public void setStoreemail(String storeemail) {
		this.storeemail = storeemail;
	}

	public String getStoreadminaccount() {
		return storeadminaccount;
	}

	public void setStoreadminaccount(String storeadminaccount) {
		this.storeadminaccount = storeadminaccount;
	}

	public String getStoreadminpassword() {
		return storeadminpassword;
	}

	public void setStoreadminpassword(String storeadminpassword) {
		this.storeadminpassword = storeadminpassword;
	}

	public String getStoreadminphone() {
		return storeadminphone;
	}

	public void setStoreadminphone(String storeadminphone) {
		this.storeadminphone = storeadminphone;
	}

	public String getStoreadminaddress() {
		return storeadminaddress;
	}

	public void setStoreadminaddress(String storeadminaddress) {
		this.storeadminaddress = storeadminaddress;
	}

	public Blob getStoreimg() {
		return storeimg;
	}

	public void setStoreimg(Blob blob) {
		this.storeimg = blob;
	}

	public String getStoreintroduction() {
		return storeintroduction;
	}

	public void setStoreintroduction(String storeintroduction) {
		this.storeintroduction = storeintroduction;
	}

	public byte getStoreopenstatus() {
		return storeopenstatus;
	}

	public void setStoreopenstatus(byte storeopenstatus) {
		this.storeopenstatus = storeopenstatus;
	}

	public Integer getStoreaccountstatus() {
		return storeaccountstatus;
	}

	public void setStoreaccountstatus(Integer storeaccountstatus) {
		this.storeaccountstatus = storeaccountstatus;
	}

	public String getStoreadminname() {
		return storeadminname;
	}

	public void setStoreadminname(String storeadminname) {
		this.storeadminname = storeadminname;
	}

	public String getStoreadminID() {
		return storeadminID;
	}

	public void setStoreadminID(String storeadminID) {
		this.storeadminID = storeadminID;
	}

	public Date getStorebuildtime() {
		return storebuildtime;
	}

	public void setStorebuildtime(Date storebuildtime) {
		this.storebuildtime = storebuildtime;
	}

	public Date getStoreupdtetime() {
		return storeupdtetime;
	}

	public void setStoreupdtetime(Date storeupdtetime) {
		this.storeupdtetime = storeupdtetime;
	}

	public Integer getStorecommentnumber() {
		return storecommentnumber;
	}

	public void setStorecommentnumber(Integer storecommentnumber) {
		this.storecommentnumber = storecommentnumber;
	}

	public Integer getStoretotalstar() {
		return storetotalstar;
	}

	public void setStoretotalstar(Integer storetotalstar) {
		this.storetotalstar = storetotalstar;
	}

	public String getStorebusinesstime() {
		return storebusinesstime;
	}

	public void setStorebusinesstime(String storebusinesstime) {
		this.storebusinesstime = storebusinesstime;
	}
	

}
