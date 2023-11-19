package com.ShaoXia.service;

import com.ShaoXia.dao.OrderProductMapper;
import com.ShaoXia.pojo.OrderProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Service
public class OrderProductServiceImpl implements OrderProductService{
	private OrderProductMapper orderProductMapper;
	public void setOrderProductMapper(OrderProductMapper orderProductMapper) {
		this.orderProductMapper = orderProductMapper;
	}

	@Override
	public List<OrderProduct> selectOrderProducts(Map map) {
		return orderProductMapper.selectOrderProducts(map);
	}

	@Override
	@Transactional
	public int insertOrderProduct(List<OrderProduct> orderProductList) {
		int i = orderProductMapper.insertOrderProduct(orderProductList);
		return i;
	}

	@Override
	public int deleteOrderProduct(Map map) {
		int i = orderProductMapper.deleteOrderProduct(map);
		return i;
	}

	@Override
	public int updateOrderProduct(int order_id, int product_id, int quantity, Date update_time) {
		int i = orderProductMapper.updateOrderProduct(order_id,product_id,quantity,update_time);
		return i;
	}
}
