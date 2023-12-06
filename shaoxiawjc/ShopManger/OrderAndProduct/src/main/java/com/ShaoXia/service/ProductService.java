package com.ShaoXia.service;

import com.ShaoXia.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
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
public interface ProductService {
	List<Product> selectAllProduct();
	Product selectProductById(@Param("id") int id);

	int insertProduct(String productName,
					  BigDecimal productPrice);
	int deleteProduct(@Param("id") int id);
	int updateProduct(Map map);
}
