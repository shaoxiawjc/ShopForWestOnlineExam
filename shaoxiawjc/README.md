# 项目的介绍以及遇到的一些问题

## 简单介绍

~~介绍~~(**ShopManager**)

修改后的是**shopmanager2**主要不知道github能不能看之前的记录，就把之前的项目保留下来了

**其中之前的项目1是订单商品关联表采用联合主键设计的表，但是因为性能低和操作的复杂等原因被我抛弃了**

以下是最新的shopmanager2的介绍 （还没写异常类。。。）

整个项目**使用spring，mybatis框架，mysql8.0**



### ~~数据库的表~~（最初的表）

1. 商品表(用sqlyog偷懒创建的)

   ![image-20231115180920569](./markdown-img/README.assets/image-20231115180920569.png)

2. 订单表（同上）

   ![image-20231115180942453](./markdown-img/README.assets/image-20231115180942453.png)

3. 商品订单关联表

   用于将订单和商品联系起来的表

   ```sql
   CREATE TABLE `productorder` (
   `id` INT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '唯一标识id',
   `order_id` INT NOT NULL COMMENT '对应订单id',
   `product_id` INT NOT NULL COMMENT '对应商品id',
   `quantity` INT NOT NULL COMMENT '商品数量',
   CONSTRAINT fk_order_id FOREIGN KEY (`order_id` )REFERENCES `order` (order_id) ON DELETE CASCADE, -- 同时删除
   CONSTRAINT fk_product_id FOREIGN KEY (`product_id`) REFERENCES `product` (product_id) ON DELETE CASCADE -- 同时删除
   )ENGINE=INNODB DEFAULT CHARSET=utf8
   ```



### 项目结构

因为写这个项目的时候springmvc学了一点点，所以就把它当web项目了（



### 实体类pojo

order

```JAVA
private int orderId;
private BigDecimal orderPrice;
```

orderproduct

```JAVA
private int orderId;
private int productId;
private int quantity;
```

product

```java
private int productId;
private String productName;
private BigDecimal productPrice;
```



### mapper层对pojo层最基本的增删改查

详细代码参考项目



### service层根据需求复杂化dao层



### controller层（摆设）







## 项目亮点

==没有亮点也是亮点==



## 遇到的问题

1. 第一个就是抛弃了联合主键的关联表，重写了项目，但是对于这种一对多的数据库的设计还是不够熟练，并不知道什么时候可以使用联合主键。
2. 第二个问题，在最初的项目遇到了。假设我不使用声明式事务，在一个事务里，我要创建一个订单，其中订单的price属性通过sum函数自动计算总价，同时在关联表里插入相关数据，但是如果我先在关联表里插入行，会因为外键找不到对应主键而保存，但是如果我先创建订单，我的sum函数又无法发挥作用。我的解决办法是在service的insert方法里先创建一个price为0.00的行，在插入关联表，在更新。但是我想知道有没有其他的方法。



