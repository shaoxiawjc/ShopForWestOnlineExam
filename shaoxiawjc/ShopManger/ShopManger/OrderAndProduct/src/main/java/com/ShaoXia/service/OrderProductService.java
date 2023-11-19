package com.ShaoXia.service;

import com.ShaoXia.pojo.OrderProduct;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author shaoxiawjc
 * @ 2023/11/19
 * @ IntelliJ IDEA
 * @ ShopManger
 * @ com.ShaoXia.service
 **/
public interface OrderProductService {
	List<OrderProduct> selectOrderProducts(Map map);


	int insertOrderProduct(List<OrderProduct> orderProductList);

	int deleteOrderProduct(Map map);

	int updateOrderProduct(int order_id,
							int product_id,
						    int quantity,
							Date update_time);
}
