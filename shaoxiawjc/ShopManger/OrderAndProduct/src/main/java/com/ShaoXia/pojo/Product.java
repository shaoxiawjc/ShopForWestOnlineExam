package com.ShaoXia.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author shaoxiawjc
 * @ 2023/11/15
 * @ IntelliJ IDEA
 * @ ShopManger
 * @ com.ShaoXia.pojo
 **/
public class Product {
	private int productId;
	private String productName;
	private BigDecimal productPrice;
	private Date createTime;
	private Date updateTime;

	public Product(int productId, String productName, BigDecimal productPrice, Date createTime, Date updateTime) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public Product(int productId, String productName, BigDecimal productPrice, Date createTime) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Product{" +
				"productId=" + productId +
				", productName='" + productName + '\'' +
				", productPrice=" + productPrice +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				'}';
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Product() {
	}



	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
}
