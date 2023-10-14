package com.wjc;

/**
 * @author wjc28
 * @Date 2023/10/14
 *
 * @注释 处理查询订单时找不到订单异常
 */
public class SelectExceptionForOrders extends Exception{
	@Override
	public String toString() {
		return "未找到该订单，订单查询失败";
	}
}
