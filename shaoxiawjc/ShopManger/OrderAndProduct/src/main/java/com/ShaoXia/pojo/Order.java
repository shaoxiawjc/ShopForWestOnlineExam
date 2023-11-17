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
public class Order {
	private int orderId;
	private BigDecimal orderPrice;
	private Date createTime;
	private Date updateTime;

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

	public Order() {
	}


	@Override
	public String toString() {
		return "Order{" +
				"orderId=" + orderId +
				", orderPrice=" + orderPrice +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				'}';
	}

	public Order(int orderId, BigDecimal orderPrice) {
		this.orderId = orderId;
		this.orderPrice = orderPrice;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public BigDecimal getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}
}
