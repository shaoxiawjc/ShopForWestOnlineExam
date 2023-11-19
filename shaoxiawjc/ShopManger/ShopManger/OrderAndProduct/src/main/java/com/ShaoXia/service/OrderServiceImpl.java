package com.ShaoXia.service;

import com.ShaoXia.dao.OrderMapper;
import com.ShaoXia.dao.OrderProductMapper;
import com.ShaoXia.pojo.Order;
import com.ShaoXia.pojo.OrderProduct;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

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
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderMapper orderMapper;
	public void setOrderMapper(OrderMapper orderMapper) {
		this.orderMapper = orderMapper;
	}

	@Override
	public List<Order> selectOrder(Map map) {
		return orderMapper.selectOrder(map);
	}

	@Override
	@Transactional
	public int updateOrder(int order_id,
						    Date update_time) {
		int i = -1;
		i = orderMapper.updateOrder(order_id,update_time);
		return i;
	}

	@Override
	@Transactional
	public int deleteOrder(int id) {
		int i = -1;
		i = orderMapper.deleteOrder(id);
		return i;
	}

	@Override
	public int insertHollowOrder(int order_id,Date create_time) {
		int i = -1;
		i = orderMapper.insertHollowOrder(order_id,create_time);
		return i;
	}


	@Override
	@Transactional
	public int insertOrder(int order_id,
						   Date create_time) {
		int i = -1;
		i = orderMapper.insertOrder(order_id,create_time);
		return i;
	}
}
