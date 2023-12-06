import com.ShaoXia.dao.OrderMapper;
import com.ShaoXia.dao.OrderProductMapper;
import com.ShaoXia.pojo.OrderProduct;
import com.ShaoXia.pojo.Product;
import com.ShaoXia.service.OrderService;
import com.ShaoXia.service.OrderServiceImpl;
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
	public void test(){
		ApplicationContext context =
				new ClassPathXmlApplicationContext("spring-service.xml");

		ProductService service =context .getBean(ProductService.class);
		// 增加一个商品（测试无误，等待答辩）
//		System.out.println(service.insertProduct( "冰红茶", new BigDecimal("4.50")));
//		System.out.println(service.insertProduct( "话梅", new BigDecimal("20.00")));
//		System.out.println(service.insertProduct( "丝之鸽", new BigDecimal("100.00")));
//		System.out.println(service.insertProduct( "纸巾", new BigDecimal("7.00")));
//		System.out.println(service.insertProduct( "100元钞票", new BigDecimal("101.00")));
//		System.out.println(service.insertProduct( "苹果99", new BigDecimal("10000.00")));


		// 修改一个商品(测试无误，等待答辩)
//		Map map = new HashMap();
//		map.put("productId",1);
//		map.put("productName","一元硬币");
//		map.put("productPrice",new BigDecimal("1.00"));
//		System.out.println(service.updateProduct(map));
//
		// 查询所有商品ok
//		List<Product> products = service.selectAllProduct();
//		for (Product product : products) {
//			System.out.println(product);
//		}
//		 查询指定商品ok
//		System.out.println(service.selectProductById(2));
//		System.out.println(service.selectProductById(3));
//		System.out.println(service.selectProductById(4));
//		System.out.println(service.selectProductById(5));


		// -------------------------- //

		// 订单mapper测试
		OrderMapper orderMapper = context.getBean(OrderMapper.class);
		// 订单商品关联表测试
		OrderProductMapper orderProductMapper = context.getBean(OrderProductMapper.class);
		// 订单业务测试
		OrderServiceImpl orderService = context.getBean(OrderServiceImpl.class);

		// 测试增加订单ok
//		int id1 = orderService.insertHollowOrder();
//		System.out.println(id1);
//		orderService.insertOrder(new OrderProduct(id1,10,9));
//		System.out.println(orderService.selectAllOrder());
//		int id2 = orderService.insertHollowOrder();
//		System.out.println(id2);
//		orderService.insertOrder(new OrderProduct(id2,9,7));
//		System.out.println(orderService.selectAllOrder());
//		System.out.println("订单1的详细"+orderService.selectOrderProductByOrderId(1));
//		System.out.println("订单2的详细"+orderService.selectOrderProductByOrderId(2));


		// 测试修改订单
//		orderService.updateOrder(new OrderProduct(6,9,6));
//		System.out.println(orderService.selectAllOrderProducts());
//		System.out.println(orderService.selectAllOrder());


		// 测试删除功能
		// 删除一个订单
//		orderService.deleteOrder(1);
		// 删除一个商品
//		System.out.println(service.deleteProduct(3));
//		System.out.println(orderService.selectAllOrder());
//		System.out.println(orderService.selectAllOrderProducts());

	}


}
