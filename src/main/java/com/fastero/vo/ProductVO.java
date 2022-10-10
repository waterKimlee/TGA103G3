package com.fastero.vo;



import java.sql.Date;

public class ProductVO {
	private Integer productId;
	private Integer storeId;
	private String productName;
	private String productIntroduction;
	private Integer productPrice;
	private Integer productStatus;
	private byte[] productImage;
	private Integer productWaitTime;
	private Date productBuildTime;
	private Date productUpdateTime;
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductIntroduction() {
		return productIntroduction;
	}
	public void setProductIntroduction(String productIntroduction) {
		this.productIntroduction = productIntroduction;
	}
	public Integer getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(Integer productStatus) {
		this.productStatus = productStatus;
	}
	public byte[] getProductImage() {
		return productImage;
	}
	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}
	public Integer getProductWaitTime() {
		return productWaitTime;
	}
	public void setProductWaitTime(Integer productWaitTime) {
		this.productWaitTime = productWaitTime;
	}
	public Date getProductBuildTime() {
		return productBuildTime;
	}
	public void setProductBuildTime(Date productBuildTime) {
		this.productBuildTime = productBuildTime;
	}
	public Date getProductUpdateTime() {
		return productUpdateTime;
	}
	public void setProductUpdateTime(Date productUpdateTime) {
		this.productUpdateTime = productUpdateTime;
	}
	
	
}
