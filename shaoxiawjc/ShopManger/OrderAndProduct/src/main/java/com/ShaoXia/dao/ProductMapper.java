package com.ShaoXia.dao;

import com.ShaoXia.pojo.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
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
public interface ProductMapper {
	List<Product> selectAllProduct();
	Product selectProductById(@Param("id") int id);

	int insertProduct(@Param("productName") String productName,
					  @Param("productPrice") BigDecimal productPrice);
	int deleteProduct(@Param("id") int id);
	int updateProduct(Map map);
}
