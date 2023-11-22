import com.ShaoXia.dao.OrderMapper;
import com.ShaoXia.dao.OrderProductMapper;
import com.ShaoXia.pojo.OrderProduct;
import com.ShaoXia.service.OrderService;
import com.ShaoXia.service.OrderServiceImpl;
import com.ShaoXia.service.ProductService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
	public void test(){
		ApplicationContext context =
				new ClassPathXmlApplicationContext("spring-service.xml");

		ProductService service = context.getBean(ProductService.class);
		// 增加一个商品
//		System.out.println(service.insertProduct(new Product(3, "高等数学讲义", new BigDecimal("50.00"), new Date())));
//		System.out.println(service.insertProduct(new Product(4, "线性代数讲义", new BigDecimal("50.00"), new Date())));
//		System.out.println(service.insertProduct(new Product(5, "英语46级", new BigDecimal("60.00"), new Date())));
//		System.out.println(service.insertProduct(new Product(6, "天选4", new BigDecimal("7299.00"), new Date())));
//		System.out.println(service.insertProduct(new Product(7, "java从入门到入土", new BigDecimal("100.00"), new Date())));
//		System.out.println(service.insertProduct(new Product(8, "孙笑川直肠倒模", new BigDecimal("10000.00"), new Date())));


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


		// -------------------------- //

//		OrderMapper orderMapper = context.getBean(OrderMapper.class);
//		OrderProductMapper orderProductMapper = context.getBean(OrderProductMapper.class);
		OrderServiceImpl orderService = context.getBean(OrderServiceImpl.class);

		// 测试dao层
//		orderMapper.deleteOrder(1);
//		orderMapper.deleteOrder(2);
//		orderMapper.deleteOrder(3);
//		orderMapper.deleteOrder(4);
//		orderMapper.deleteOrder(5);
//		System.out.println(orderMapper.selectAllOrder());
//		System.out.println(orderMapper.selectOrderById(1));
//		System.out.println("-------------------------------------");
//		System.out.println(orderProductMapper.selectAllOrderProducts());
//		System.out.println("----------------------------------------------");
//		System.out.println(orderMapper.insertOrder());
//		orderProductMapper.insertOrderProduct(new OrderProduct(9,2,3));
//		System.out.println(orderProductMapper.selectAllOrderProducts());
//		orderMapper.updateOrder(9);
//		System.out.println(orderMapper.selectAllOrder());
//		orderProductMapper.updateOrderProduct(new OrderProduct(1,9,3,1));
//		orderMapper.updateOrder(9);
//		System.out.println(orderMapper.selectAllOrder());

		// 测试order的service层
		// 测试增加订单
//		orderService.insertOrder(new OrderProduct(1,3,6));
//		System.out.println(orderService.selectAllOrder());
//		orderService.insertOrder(new OrderProduct(1,6,7));
//		orderService.insertOrder(new OrderProduct(2,3,7));
//		orderService.insertOrder(new OrderProduct(1,6,7));
//		orderService.insertOrder(new OrderProduct(2,6,7));
//		System.out.println(orderService.selectAllOrder());
//		System.out.println("订单1的详细"+orderService.selectOrderProductByOrderId(1));
//		System.out.println("订单2的详细"+orderService.selectOrderProductByOrderId(2));

		// 测试修改订单
//		orderService.updateOrder(new OrderProduct(1,2,3,6));
//		System.out.println(orderService.selectAllOrderProducts());
//		System.out.println(orderService.selectAllOrder());


		// 测试删除功能
		// 删除一个订单
		//orderService.deleteOrder(2);
		// 删除一个商品
		System.out.println(service.deleteProduct(3));
		System.out.println(orderService.selectAllOrder());
		System.out.println(orderService.selectAllOrderProducts());

	}


}
