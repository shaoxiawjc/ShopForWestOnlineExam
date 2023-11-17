# 项目的介绍以及遇到的一些问题

## 简单介绍

之前的修改记录被我删除了（写的太烂了）

以下是最新的介绍

### 数据库的表

1. 商品表(用sqlyog偷懒创建的)

   ![image-20231115180920569](./markdown-img/README.assets/image-20231115180920569.png)

2. 订单表（同上）

   ![image-20231115180942453](./markdown-img/README.assets/image-20231115180942453.png)

3. 商品订单关联表

   用于将订单和商品联系起来的表

   ```sql
   CREATE TABLE `orderproduct`(
   `order_id` INT(20) NOT NULL COMMENT '订单的id',
   `product_id` INT(20) NOT NULL COMMENT '商品的id',
   `quantity` INT(20) NOT NULL COMMENT '商品的数量',
   PRIMARY KEY (`order_id`, `product_id`),
   FOREIGN KEY (`order_id`) REFERENCES `order`(order_id) ON DELETE CASCADE,
   FOREIGN KEY (product_id) REFERENCES `product`(product_id) ON DELETE CASCADE
   ) ENGINE=INNODB DEFAULT CHARSET=utf8;
   ```

   





