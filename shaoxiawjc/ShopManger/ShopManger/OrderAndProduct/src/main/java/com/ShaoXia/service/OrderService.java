package com.ShaoXia.service;

import com.ShaoXia.pojo.Order;
import com.ShaoXia.pojo.OrderProduct;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author shaoxiawjc
 * @ 2023/11/16
 * @ IntelliJ IDEA
 * @ ShopManger
 * @ com.ShaoXia.service
 **/
public interface OrderService {

	List<Order> selectOrder(Map map);

	int updateOrder(int order_id,
					Date update_time);
	int deleteOrder(int id);


	int insertHollowOrder(int order_id,Date create_time);
	int insertOrder(int order_id,Date create_time);
}
