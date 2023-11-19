import com.ShaoXia.pojo.OrderProduct;
import com.ShaoXia.pojo.Product;
import com.ShaoXia.service.OrderProductService;
import com.ShaoXia.service.OrderService;
import com.ShaoXia.service.ProductService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author shaoxiawjc
 * @ 2023/11/17
 * @ IntelliJ IDEA
 * @ ShopManger
 * @ PACKAGE_NAME
 **/
public class MyTest {

	@Test
	public void testProductService(){
		ApplicationContext context =
				new ClassPathXmlApplicationContext("spring-service.xml");

		ProductService productService = context.getBean(ProductService.class);
		OrderService orderService = context.getBean(OrderService.class);
		OrderProductService orderProductService = context.getBean(OrderProductService.class);

		// 增加一个商品
//		System.out.println(service.insertProduct(new Product(3, "高等数学讲义", new BigDecimal("50.00"), new Date())));
//		System.out.println(service.insertProduct(new Product(4, "线性代数讲义", new BigDecimal("50.00"), new Date())));
//		System.out.println(service.insertProduct(new Product(5, "英语46级", new BigDecimal("60.00"), new Date())));
//		System.out.println(service.insertProduct(new Product(6, "天选4", new BigDecimal("7299.00"), new Date())));
//		System.out.println(service.insertProduct(new Product(7, "java从入门到入土", new BigDecimal("100.00"), new Date())));
//		System.out.println(service.insertProduct(new Product(8, "孙笑川直肠倒模", new BigDecimal("10000.00"), new Date())));
		// 删除一个商品
		// System.out.println(service.deleteProduct(2));

		// 修改一个商品
//		Map map = new HashMap();
//		map.put("product_id",1);
//		map.put("product_name","俩颗原石");
//		map.put("product_price",new BigDecimal("1.00"));
//		map.put("update_time",new Date());
//		System.out.println(service.updateProduct(map));
//
		// 查询所有商品
//		List<Product> products = service.selectAllProduct();
//		for (Product product : products) {
//			System.out.println(product);
//		}
		// 查询指定商品
//		System.out.println(productService.selectProductById(2));
//		System.out.println(productService.selectProductById(3));
//		System.out.println(productService.selectProductById(4));
//		System.out.println(productService.selectProductById(5));

		// 查询订单
//		Map map1 = new HashMap();
//		System.out.println(orderService.selectOrder(map1));
//		System.out.println(orderProductService.selectOrderProducts(map1));
//
//		Map map2 = new HashMap();
//		map2.put("product_id",2);
//		System.out.println(orderService.selectOrder(map2));
//		System.out.println(orderProductService.selectOrderProducts(map2));
//
//		Map map3 = new HashMap();
//		map3.put("product_id",2);
//		map3.put("order_id",1);
//		System.out.println(orderService.selectOrder(map3));
//		System.out.println(orderProductService.selectOrderProducts(map3));


		// 增加订单
//		System.out.println(orderService.insertHollowOrder(6, new Date()));
//		List<OrderProduct> orderProductList = new ArrayList();
//		orderProductList.add(new OrderProduct(6,1,20,new Date(),null));
//		orderProductList.add(new OrderProduct(6,2,201,new Date(),null));
//		orderProductList.add(new OrderProduct(6,3,200,new Date(),null));
//		System.out.println(orderProductService.insertOrderProduct(orderProductList));
//		orderService.updateOrder(6,new Date());

		// 删除订单
//		System.out.println(orderService.deleteOrder(6));

		// 修改订单
		System.out.println(orderProductService.updateOrderProduct(5, 1, 20, new Date()));
		orderService.updateOrder(5,new Date());


	}


	}
