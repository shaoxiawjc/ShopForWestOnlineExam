package com.wjc;

/**
 * @author wjc28
 * @Date 2023/10/14
 */
public class DeleteExceptionForProducts extends Exception{
	@Override
	public String toString() {
		return "商品删除失败";
	}
}
