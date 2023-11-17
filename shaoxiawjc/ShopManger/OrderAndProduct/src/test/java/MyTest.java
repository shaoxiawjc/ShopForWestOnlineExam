import com.ShaoXia.pojo.Product;
import com.ShaoXia.service.ProductService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.Date;

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
		ApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("spring-service.xml");

		ProductService service =
				applicationContext.getBean("productService", ProductService.class);

		// 增加一个商品
		System.out.println
				(service.insertProduct(new Product(1, "1颗原石", new BigDecimal("99999.99"), new Date())));

	}
}
