package com.wjc;

/**
 * @author wjc28
 * @Date 2023/10/14
 *
 * @注释 处理修改商品找不到商品异常
 */
public class UpdateExceptionForProduct extends Exception {
	@Override
	public String toString() {
		return "修改失败";
	}
}

