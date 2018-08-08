package com.weidai.study.parttendesign.delegale;


/**
 * @描述
 * @author nic 
 * @time：2018年6月10日 下午5:43:27
 */
public class OrderBuilder implements ISystemBuild {

	@Override
	public void building() {
		System.out.println("订单模块建造完成");
	}
}
