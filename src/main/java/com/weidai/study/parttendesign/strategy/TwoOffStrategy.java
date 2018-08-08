package com.weidai.study.parttendesign.strategy;


/**
 * @描述
 * @author nic 
 * @time：2018年6月11日 上午10:13:26
 */
public class TwoOffStrategy implements SaleStrategy {

	@Override
	public double getPrice(double originPrice) {
		return originPrice * 0.8;
	}

}
