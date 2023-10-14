package com.wjc;

import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Date;
import java.util.Properties;

/**
 * @author wjc28
 * @Date 2023/10/14
 */

public class Tools {
	private static String driver = null;
	private static String url = null;
	private static String username = null;
	private static String password = null;

	/* 配置并加载驱动 */
	static {
		try {
			InputStream in = Tools.class.getClassLoader().getResourceAsStream("db.properties");
			Properties properties = new Properties();
			properties.load(in);
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			password = properties.getProperty("password");

			Class.forName(driver);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	/* 获取连接 */
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// ========================================================================= //

	/* 增,创建订单（对应错误CreateExceptionForOrdersPrice） */
	public static void addOrder(Connection connection, int productId, Date orderTime, BigDecimal orderPrice) throws SQLException, CreateExceptionForOrdersPrice {
		String sql = "insert into orders (productid,ordertime,orderprice) values (?,?,?)";
		PreparedStatement preparedStatement = null;
		String compareSql = "select `productprice` from products where productid = ?";
		// 用于比较订单价格是否小于商品价格
		PreparedStatement compareSt = null;
		ResultSet resultSet = null;
		try {
			// 预编译
			compareSt = connection.prepareStatement(compareSql);
			compareSt.setInt(1, productId);
			resultSet = compareSt.executeQuery();
			if (resultSet.next()) {
				if ((resultSet.getBigDecimal("productprice")).compareTo(orderPrice) >= 0) {
					throw new CreateExceptionForOrdersPrice(orderPrice);
				}
			}

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, productId);
			preparedStatement.setDate(2, new java.sql.Date(orderTime.getTime()));
			preparedStatement.setBigDecimal(3, orderPrice);

			int i = preparedStatement.executeUpdate();
			if (i == 0) {
				System.out.println("订单创建失败");
			} else {
				System.out.println("订单创建成功");
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		// 释放内存
		finally {
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (compareSt != null) {
				compareSt.close();
			}
		}
	}
	// ======================================= //

	/* 删除订单（对应异常DeleteExceptionForOrders） */
	public static void deleteOrder(Connection connection, int orderId) throws SQLException, DeleteExceptionForOrders {
		PreparedStatement preparedStatement = null;
		String sql = "delete from orders where orderid = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, orderId);
			int i = preparedStatement.executeUpdate();
			if (i == 0) {
				throw new DeleteExceptionForOrders();
			} else {
				System.out.println("订单删除成功");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		}
	}

	/* 改，修改订单信息 （对应错误UpdateExceptionForOrders）*/
	public static void updateOrder(Connection connection, int orderId, int productId, Date orderTime, BigDecimal orderPrice) throws SQLException, UpdateExceptionForOrders {
		PreparedStatement preparedStatement = null;
		String sql = "update orders set productid = ?,ordertime = ?,orderprice = ? where orderid = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, productId);
			preparedStatement.setDate(2, new java.sql.Date(orderTime.getTime()));
			preparedStatement.setBigDecimal(3, orderPrice);
			preparedStatement.setInt(4, orderId);
			int i = preparedStatement.executeUpdate();
			if (i == 0) {
				throw new UpdateExceptionForOrders();
			} else {
				System.out.println("修改成功");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		}
	}

	// ==================================================== //
	/* 查，查询订单（对应异常SelectExceptionForOrders */
	public static void selectOrder(Connection connection, int orderId) throws SQLException, SelectExceptionForOrders {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "SELECT `orderid`,`productname`,`ordertime`,`productprice`,`orderprice` " + "FROM `orders` ods " + "INNER JOIN `products` pds " + "ON ods.`productid` = pds.`productid` " + "WHERE `orderid` = ? ";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, orderId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null && resultSet.next()) {
				System.out.println("订单的id为 ： " + resultSet.getInt("orderid"));
				System.out.println("商品的名字为 ： " + resultSet.getString("productname"));
				System.out.println("下单的日期为 ： " + resultSet.getDate("ordertime"));
				System.out.println("商品的价格为 ： " + resultSet.getBigDecimal("productprice"));
				System.out.println("订单的价格为 ： " + resultSet.getBigDecimal("orderprice"));
			} else {
				throw new SelectExceptionForOrders();
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		}
	}



	/* 增加商品(对应异常CreateExceptionForProduct) */
	public static void addProduct(Connection connection, String productName, BigDecimal productPrice) throws SQLException, CreateExceptionForProduct {
		if (productPrice.compareTo(new BigDecimal("0")) < 0) {
			throw new CreateExceptionForProduct(productPrice);
		}
		PreparedStatement preparedStatement = null;
		String sql = "insert into products(productname,productprice) values (?,?)";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, productName);
			preparedStatement.setBigDecimal(2, productPrice);
			int i = preparedStatement.executeUpdate();
			if (i != 0) {
				System.out.println("商品添加成功");
			} else {
				System.out.println("商品添加失败");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		}

	}

	/* 删除商品（我的想法是如果订单中含有该商品，则一并删除）（对应异常DeleteExceptionForProducts）*/
	public static void deleteProduct(Connection connection, int productId) throws SQLException, DeleteExceptionForProducts {
		PreparedStatement preparedStatementForSelect = null;
		PreparedStatement preparedStatementForDeleteRelativeOrders = null;
		PreparedStatement preparedStatementForDeleteProducts = null;
		ResultSet resultSet = null;
		// PreparedStatement 一次只能执行一条语句
		String sqlForSelectIsRelative = "select `productid` from orders where productid = ?";
		String sqlForDeleteSpecificOrder = "delete from orders where productid = ?;";
		String sqlForDeleteSpecificProducts = "delete from products where productid = ?;";
		try {
			preparedStatementForDeleteRelativeOrders = connection.prepareStatement(sqlForDeleteSpecificOrder);
			preparedStatementForDeleteProducts = connection.prepareStatement(sqlForDeleteSpecificProducts);
			preparedStatementForSelect = connection.prepareStatement(sqlForSelectIsRelative);

			// 查询是否有含有指定商品的相关订单
			preparedStatementForSelect.setInt(1, productId);
			resultSet = preparedStatementForSelect.executeQuery();
			while (resultSet.next()) {
				System.out.println("订单编号为 " + resultSet.getInt("orderid") + " 的订单含有相关商品，将被一并删除");
			}

			preparedStatementForDeleteRelativeOrders.setInt(1, productId);
			preparedStatementForDeleteProducts.setInt(1, productId);
			int i = preparedStatementForDeleteProducts.executeUpdate();
			if (i != 0) {
				System.out.println("删除成功");
			} else {
				throw new DeleteExceptionForProducts();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatementForDeleteProducts != null) {
				preparedStatementForDeleteProducts.close();
			}
			if (preparedStatementForDeleteRelativeOrders != null) {
				preparedStatementForDeleteRelativeOrders.close();
			}
			if (preparedStatementForSelect != null) {
				preparedStatementForSelect.close();
			}
		}

	}

	/* 修改商品信息 （对应异常UpdateExceptionForProduct）*/
	public static void updateProduct(Connection connection, int productId, String productName, BigDecimal productPrice) throws SQLException, UpdateExceptionForProduct {
		PreparedStatement preparedStatement = null;
		String sql = "update products set productname = ?,productprice = ? where productid = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, productName);
			preparedStatement.setBigDecimal(2, productPrice);
			preparedStatement.setInt(3, productId);
			int i = preparedStatement.executeUpdate();
			if (i == 0) {
				throw new UpdateExceptionForProduct();
			} else {
				System.out.println("修改成功");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		}
	}

	/* 查询商品信息(对应异常SelectExceptionForProduct) */
	public static void selectProducts(Connection connection, String productName) throws SQLException, SelectExceptionForProduct {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "SELECT `productid` ,`productname`, `productprice` FROM `products` WHERE `productname` = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, productName);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null && resultSet.next()) {
				System.out.println("该商品的id是：" + resultSet.getInt("productid"));
				System.out.println("该商品的名字是：" + resultSet.getString("productname"));
				System.out.println("该商品的价格是" + resultSet.getBigDecimal("productprice"));
			} else {
				throw new SelectExceptionForProduct();
			}


		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		}

	}

	/* 清空处理，仅仅用于测试 */
	public static void truncateTables(Connection connection) throws SQLException {
		PreparedStatement preparedStatementForTruncateOrders = null;
		PreparedStatement preparedStatementForTruncateProducts = null;
		String sqlTruncateOrders = "truncate `orders`";
		String sqlTruncateProducts = "truncate ` products`";

		try {
			preparedStatementForTruncateOrders = connection.prepareStatement(sqlTruncateOrders);
			preparedStatementForTruncateProducts = connection.prepareStatement(sqlTruncateProducts);
			System.out.println("表格全部清空（truncate）");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (preparedStatementForTruncateOrders != null) {
				preparedStatementForTruncateOrders.close();
			}
			if (preparedStatementForTruncateProducts != null) {
				preparedStatementForTruncateProducts.close();
			}
		}
	}
}
