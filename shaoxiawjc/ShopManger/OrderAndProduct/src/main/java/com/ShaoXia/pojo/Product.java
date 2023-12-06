package com.ShaoXia.pojo;

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
public class Product {
	private int productId;
	private String productName;
	private BigDecimal productPrice;

	public Product(String productName, BigDecimal productPrice) {
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public Product(int productId, String productName, BigDecimal productPrice) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}


}
