package com.ShaoXia.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author shaoxiawjc
 * @ 2023/11/16
 * @ IntelliJ IDEA
 * @ ShopManger
 * @ com.ShaoXia.pojo
 **/
@Data
@NoArgsConstructor
public class OrderProduct {
	private int id;
	private int orderId;
	private int productId;
	private int quantity;

	public OrderProduct(int id, int orderId, int productId, int quantity) {
		this.id = id;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public OrderProduct(int orderId, int productId, int quantity) {
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
	}
}
