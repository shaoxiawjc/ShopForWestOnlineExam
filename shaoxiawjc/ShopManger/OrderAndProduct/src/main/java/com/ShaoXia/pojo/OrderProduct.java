package com.ShaoXia.pojo;

import java.util.Date;

/**
 * @author shaoxiawjc
 * @ 2023/11/16
 * @ IntelliJ IDEA
 * @ ShopManger
 * @ com.ShaoXia.pojo
 **/
public class OrderProduct {
	private int orderId;
	private int productId;
	private int quantity;
	private Date createTime;
	private Date updateTime;

	@Override
	public String toString() {
		return "OrderProduct{" +
				"orderId=" + orderId +
				", productId=" + productId +
				", quantity=" + quantity +
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

	public OrderProduct(int orderId, int productId, int quantity) {
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public OrderProduct() {
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
