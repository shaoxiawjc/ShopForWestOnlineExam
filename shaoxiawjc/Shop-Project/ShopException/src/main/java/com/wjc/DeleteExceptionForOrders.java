package com.wjc;

/**
 * @author wjc28
 * @Date 2023/10/14
 *
 * @注释 处理删除订单找不到订单异常
 */
public class DeleteExceptionForOrders extends Exception{

	@Override
	public String toString() {
		return "没有该订单，订单删除失败";
	}
}
