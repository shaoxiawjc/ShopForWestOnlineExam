package com.ShaoXia.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author shaoxiawjc
 * @ 2023/11/15
 * @ IntelliJ IDEA
 * @ ShopManger
 * @ com.ShaoXia.pojo
 **/
@Data
@NoArgsConstructor
public class Order {
	private int orderId;
	private BigDecimal orderPrice;

	public Order(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}

	public Order(int orderId, BigDecimal orderPrice) {
		this.orderId = orderId;
		this.orderPrice = orderPrice;
	}
}
