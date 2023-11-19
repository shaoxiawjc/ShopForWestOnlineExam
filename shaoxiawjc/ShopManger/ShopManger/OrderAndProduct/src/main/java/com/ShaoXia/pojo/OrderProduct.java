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
@AllArgsConstructor
public class OrderProduct {
	private int orderId;
	private int productId;
	private int quantity;
	private Date createTime;
	private Date updateTime;

}
