package com.ShaoXia.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author shaoxiawjc
 * @ 2023/11/16
 * @ IntelliJ IDEA
 * @ ShopManger
 * @ com.ShaoXia.dao
 * 这里就没有查询了
 * 只有增加(订单id，商品id)，
 * 修改
 **/
public interface OrderProductMapper {
	int insertOrderProduct(Map map);
	int updateOrderProduct(Map map, @Param("order_id") int id);
}
