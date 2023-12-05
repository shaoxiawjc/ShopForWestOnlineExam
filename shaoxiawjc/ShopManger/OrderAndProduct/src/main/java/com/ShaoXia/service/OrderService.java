package com.ShaoXia.service;

import com.ShaoXia.pojo.Order;
import com.ShaoXia.pojo.OrderProduct;
import com.ShaoXia.pojo.ResultOrderProduct;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

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
@Service
public interface OrderService {
	/**
	 * 查询所有的订单
	 * **/
	List<ResultOrderProduct> selectAllOrder();
	/**
	 * 查询关联订单
	 * **/
	List<OrderProduct> selectAllOrderProducts();

	/**
	 * 通过订单id查询
	 * **/
	List<OrderProduct> selectOrderProductByOrderId(int orderId);
	/***
	 * 通过id查询订单,同时打印相关信息
	 * */
	List<ResultOrderProduct> selectOrderById(int id);
	/***
	 * 增加一份订单
	 * */
	int insertOrder(OrderProduct orderProduct);
	/**
	 * 删除一份订单，由于关联表外键设置了Cascade会同时删除
	 * **/
	int deleteOrder(int id);
	/**
	 * 修改订单
	 * **/
	int updateOrder(OrderProduct orderProduct);


}
