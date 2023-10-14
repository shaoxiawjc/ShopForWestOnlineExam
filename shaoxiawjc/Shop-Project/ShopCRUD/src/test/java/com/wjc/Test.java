package com.wjc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;


/**
 * @author wjc28
 * @Date 2023/10/14
 * */
public class Test {
	public static void main(String[] args) throws SQLException, CreateExceptionForOrdersPrice, DeleteExceptionForOrders, CreateExceptionForProduct, SelectExceptionForOrders, UpdateExceptionForOrders, DeleteExceptionForProducts, SelectExceptionForProduct, UpdateExceptionForProduct {
		Connection connection = Tools.getConnection();

		try {
			// 清空 (调试用)
			Tools.truncateTables(connection);


			// 先添加商品
			Tools.addProduct(connection, "拜登写真", new BigDecimal("100.00"));
			Tools.addProduct(connection, "镇店之宝", new BigDecimal("99999.99"));
			Tools.addProduct(connection, "帝皇侠变身器", new BigDecimal("10000.00"));
			Tools.addProduct(connection, "炎龙侠变身器", new BigDecimal("10000.00"));
			Tools.addProduct(connection, "风鹰侠变身器", new BigDecimal("10000.00"));
			Tools.addProduct(connection, "黑犀侠变身器", new BigDecimal("10000.00"));
			Tools.addProduct(connection, "雪獒侠变身器", new BigDecimal("10000.00"));
			Tools.addProduct(connection, "地虎侠变身器", new BigDecimal("1.00"));
			// 价格异常测试（商品价格为负）
			Tools.addProduct(connection, "shit", new BigDecimal("-666"));


			// 添加订单
			Tools.addOrder(connection, 1, new java.sql.Date(new Date().getTime()), new BigDecimal("200.00"));
			Tools.addOrder(connection, 1, new java.sql.Date(new Date().getTime()), new BigDecimal("500.00"));
			Tools.addOrder(connection, 3, new java.sql.Date(new Date().getTime()), new BigDecimal("60000.00"));
			// 价格异常测试(商品价格大于订单价格)
			Tools.addOrder(connection, 2, new java.sql.Date(new Date().getTime()), new BigDecimal("1"));


			// 查询订单，商品
			Tools.selectOrder(connection, 2);
			// 订单编号异常测试
			Tools.selectOrder(connection, 100);
			Tools.selectProducts(connection, "镇店之宝");
			//商品名字异常测试
			Tools.selectProducts(connection, "电动");


			// 删除订单，商品
			// 订单号不存在测试
			Tools.deleteOrder(connection, 16);
			// 商品号不存在测试
			Tools.deleteProduct(connection, 18);


			// 修改
			Tools.updateOrder(connection, 3, 1, new java.sql.Date(new Date().getTime()), new BigDecimal("10000.00"));
			Tools.updateProduct(connection, 3, "修罗铠甲变身器", new BigDecimal("999999"));


			// sql运行错误
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} // 创建订单价格错误
		catch (CreateExceptionForOrdersPrice createExceptionForOrdersPrice) {
			System.out.println(createExceptionForOrdersPrice.toString());
		}  // 创建商品价格错误
		catch (CreateExceptionForProduct createExceptionForProduct) {
			System.out.println(createExceptionForProduct.toString());
		}  // 删除订单时订单编号不存在错误
		catch (DeleteExceptionForOrders deleteExceptionForOrders) {
			System.out.println(deleteExceptionForOrders.toString());
		} // 查询订单错误
		catch (SelectExceptionForOrders selectException) {
			System.out.println(selectException.toString());
		} // 修改订单错误
		catch (UpdateExceptionForOrders updateExceptionForOrders) {
			System.out.println(updateExceptionForOrders.toString());
		} // 删除商品失败
		catch (DeleteExceptionForProducts deleteExceptionForProducts) {
			System.out.println(deleteExceptionForProducts.toString());
		} // 查询商品错误
		catch (SelectExceptionForProduct selectExceptionForProduct) {
			System.out.println(selectExceptionForProduct.toString());
		} // 修改商品错误
		catch (UpdateExceptionForProduct updateExceptionForProduct) {
			System.out.println(updateExceptionForProduct.toString());
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

}
