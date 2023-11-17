package com.ShaoXia.dao;

import com.ShaoXia.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author shaoxiawjc
 * @ 2023/11/15
 * @ IntelliJ IDEA
 * @ ShopManger
 * @ com.ShaoXia.dao
 **/
public interface OrderMapper {
	/**
	 * 查询订单
	 * 可以查询全部订单，
	 * 相应id订单，
	 * 包含某件商品的订单
	 * 具体实现看map的key
	 * */
	List<Order> selectOrder(Map map);

	/**
	 * 增删改
	 * 其中更新方法（updateOrder）只修改price总价，
	 * 而总价之和关联表的quantity和product表的price绝定
	 * */
	int updateOrder(@Param("id") int id, @Param("update_time") Date updateTime);
	int deleteOder(@Param("id") int id);
	int insertOrder(Order order);

}
