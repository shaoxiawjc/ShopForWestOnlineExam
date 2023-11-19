package com.ShaoXia.dao;

import com.ShaoXia.pojo.OrderProduct;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
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
@Repository
public interface OrderProductMapper {
	List<OrderProduct> selectOrderProducts(Map map);


	int insertOrderProduct(@Param("orderProductList") List<OrderProduct> orderProductList);

	int deleteOrderProduct(Map map);

	int updateOrderProduct( @Param("order_id") int order_id,
							@Param("product_id") int product_id,
							@Param("quantity") int quantity,
							@Param("update_time") Date update_time);
}
