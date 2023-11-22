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

}
