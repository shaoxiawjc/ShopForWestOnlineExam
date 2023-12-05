package com.ShaoXia.dao;

import com.ShaoXia.pojo.Order;
import com.ShaoXia.pojo.OrderProduct;
import com.ShaoXia.pojo.ResultOrderProduct;
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
	 * 查询所有订单
	 * */
	List<ResultOrderProduct> selectAllOrder();
	List<ResultOrderProduct> selectOrderById(@Param("id") int id);


	/**
	 * 增删改
	 * 其中更新方法（updateOrder）修改商品的数量，通过sum函数修改总价
	 * 如果想要删除订单的某个商品，我觉得把数量设置为0就好了（
	 * */
	int insertOrder();

	int updateOrder(@Param("order_id") int order_id);

	int deleteOrder(@Param("id") int id);

}
