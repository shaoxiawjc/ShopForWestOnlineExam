package com.wjc;

/**
 * @author wjc28
 * @Date 2023/10/14
 */
public class SelectExceptionForProduct extends Exception{
	@Override
	public String toString() {
		return "查询异常，未找到该商品";
	}
}
