package com.wjc;

import java.math.BigDecimal;

/**
 * @author wjc28
 * @Date 2023/10/14
 *
 * @注释 处理创建商品时价格异常
 */
public class CreateExceptionForProduct extends  Exception{
	private BigDecimal productPrice;

	public CreateExceptionForProduct(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "输入有误，商品价格不能为负";
	}
}
