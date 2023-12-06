package com.ShaoXia.service;

import com.ShaoXia.dao.OrderMapper;
import com.ShaoXia.dao.OrderProductMapper;
import com.ShaoXia.pojo.Order;
import com.ShaoXia.pojo.OrderProduct;
import com.ShaoXia.pojo.ResultOrderProduct;
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
	private OrderMapper orderMapper;
	private OrderProductMapper orderProductMapper;
	@Autowired
	public void setOrderMapper(OrderMapper orderMapper) {
		this.orderMapper = orderMapper;
	}
	@Autowired
	public void setOrderProductMapper(OrderProductMapper orderProductMapper) {
		this.orderProductMapper = orderProductMapper;
	}

	/**
	 * 查询所有的订单
	 * **/
	@Override
	public List<ResultOrderProduct> selectAllOrder() {
		return orderMapper.selectAllOrder();
	}

	/**
	 * 查询所有的商品订单关联
	 * **/
	@Override
	public List<OrderProduct> selectAllOrderProducts() {
		return orderProductMapper.selectAllOrderProducts();
	}

	/**
	 * 通过订单id查询其详细内容
	 * **/
	@Override
	public List<OrderProduct> selectOrderProductByOrderId(int orderId) {
		return orderProductMapper.selectOrderProductByOrderId(orderId);
	}

	/**
	 * 查询指定订单
	 * **/
	@Override
	public List<ResultOrderProduct> selectOrderById(int id) {
		return orderMapper.selectOrderById(id);
	}




	@Override
	@Transactional
	public int insertHollowOrder() {
		Order order = new Order();
		orderMapper.insertOrder(order);
		return order.getOrderId();
	}

	/**
	 * 插入一条订单
	 * 如果订单id存在，这相当于在次订单上增加商品
	 * 如果订单不存在，则自动添加订单
	 * **/
	@Override
	@Transactional
	public int insertOrder(OrderProduct orderProduct) {
		orderProductMapper.insertOrderProduct(orderProduct);
		orderMapper.updateOrder(orderProduct.getOrderId());
		return 1;
	}

	/**
	 * 删除订单，由于外键设置，会一并删除关联表相关id的所有内容
	 * **/
	@Override
	@Transactional
	public int deleteOrder(int id) {
		orderMapper.deleteOrder(id);
		return 1;
	}



	/**
	 * 更新订单
	 * 设置指定关联表id的订单，修改改订单号，商品号，商品数量
	 * **/
	@Override
	@Transactional
	public int updateOrder(OrderProduct orderProduct) {
		orderProductMapper.updateOrderProduct(orderProduct);
		orderMapper.updateOrder(orderProduct.getOrderId());
		return 1;
	}
}
