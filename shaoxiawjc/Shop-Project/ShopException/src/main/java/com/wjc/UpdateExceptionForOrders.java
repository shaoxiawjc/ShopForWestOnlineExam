package com.wjc;

/**
 * @author wjc28
 * @Date 2023/10/14
 */
public class UpdateExceptionForOrders extends Exception{
	@Override
	public String toString() {
		return "修改失败";
	}
}