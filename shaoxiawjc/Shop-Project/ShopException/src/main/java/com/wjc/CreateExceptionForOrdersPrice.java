package com.wjc;

import java.math.BigDecimal;

/**
 * @author wjc28
 * @Date 2023/10/14
 */
public class CreateExceptionForOrdersPrice extends Exception{
	private BigDecimal orderPrice;


	public CreateExceptionForOrdersPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}

	@Override
	public String toString() {
		return "订单的价格为 "+orderPrice+" 出现异常，价格小于商品价格";
	}
}
