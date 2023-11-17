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
	private DataSourceTransactionManager transactionManager;
	private OrderProductMapper orderProductMapper;

	public void setOrderProductMapper(OrderProductMapper orderProductMapper) {
		this.orderProductMapper = orderProductMapper;
	}
	public void setProductMapper(ProductMapper productMapper) {
		this.productMapper = productMapper;
	}
	public void setTransactionManager(DataSourceTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
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
	public int insertProduct(Product product) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		int i = -1;
		try{
			i = productMapper.insertProduct(product);
			transactionManager.commit(status);
		}catch (Exception e){
			e.printStackTrace();
			transactionManager.rollback(status);
		}
		return i;
	}

	@Override
	public int deleteProduct(int id) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try{
			int i = productMapper.deleteProduct(id);
			transactionManager.commit(status);
			return i;
		}catch (Exception e){
			transactionManager.rollback(status);
		}
		return -1;
	}

	@Override
	public int updateProduct(Map map) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try{
			int i = productMapper.updateProduct(map);
			transactionManager.commit(status);
			return i;
		}catch (Exception e){
			transactionManager.rollback(status);
		}
		return -1;
	}





}
