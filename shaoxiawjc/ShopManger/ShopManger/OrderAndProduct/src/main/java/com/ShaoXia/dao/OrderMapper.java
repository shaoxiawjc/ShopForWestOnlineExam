package com.ShaoXia.dao;

import com.ShaoXia.pojo.Order;
import com.ShaoXia.pojo.OrderProduct;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
@Repository
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
	 * 其中更新方法（updateOrder）修改商品的数量，通过sum函数修改总价
	 * 如果想要删除订单的某个商品，我觉得把数量设置为0就好了（
	 * */

	int updateOrder(@Param("order_id") int order_id,
					@Param("update_time") Date update_time);


	int deleteOrder(@Param("id") int id);

	int insertHollowOrder(@Param("order_id") int order_id,@Param("create_time") Date create_time);
	int insertOrder(@Param("order_id") int order_id,
					@Param("create_time")Date create_time);

}
