package com.wjc;

/**
 * @author wjc28
 * @Date 2023/10/14
 *
 * @注释 处理修改订单时找不到订单异常
 */
public class UpdateExceptionForOrders extends Exception{
	@Override
	public String toString() {
		return "修改失败";
	}
}
