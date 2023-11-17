package com.ShaoXia.dao;

import com.ShaoXia.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author shaoxiawjc
 * @ 2023/11/15
 * @ IntelliJ IDEA
 * @ ShopManger
 * @ com.ShaoXia.dao
 **/
public interface ProductMapper {
	List<Product> selectAllProduct();
	Product selectProductById(@Param("id") int id);

	int insertProduct(Product product);
	int deleteProduct(@Param("id") int id);
	int updateProduct(Map map);
}
