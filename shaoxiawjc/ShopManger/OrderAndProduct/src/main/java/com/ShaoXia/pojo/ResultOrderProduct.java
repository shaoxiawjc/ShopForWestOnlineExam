package com.ShaoXia.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author shaoxiawjc
 * @ 2023/12/5
 * @ IntelliJ IDEA
 * @ ShopManger
 * @ com.ShaoXia.pojo
 **/
@Repository
@Data
@NoArgsConstructor
public class ResultOrderProduct {
	private int orderId;
	private int orderPrice;
	private List<Product> products;
	private List<OrderProduct> orderProducts;


}
