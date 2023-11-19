package com.ShaoXia.service;

import com.ShaoXia.dao.OrderProductMapper;
import com.ShaoXia.dao.ProductMapper;
import com.ShaoXia.pojo.Product;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

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
public class ProductServiceImpl implements ProductService{
	private ProductMapper productMapper;
	public void setProductMapper(ProductMapper productMapper) {
		this.productMapper = productMapper;
	}

	@Override
	public List<Product> selectAllProduct() {
		return productMapper.selectAllProduct();
	}

	@Override
	public Product selectProductById(int id) {
		return productMapper.selectProductById(id);
	}

	@Override
	@Transactional
	public int insertProduct(Product product) {
		int i = -1;
		try{
			i = productMapper.insertProduct(product);
		}catch (Exception e){
			e.printStackTrace();
		}
		return i;
	}

	@Override
	@Transactional
	public int deleteProduct(int id) {
		try{
			int i = productMapper.deleteProduct(id);
			return i;
		}catch (Exception e){
		}
		return -1;
	}

	@Override
	@Transactional
	public int updateProduct(Map map) {
		try{
			int i = productMapper.updateProduct(map);
			return i;
		}catch (Exception e){
		}
		return -1;
	}





}
