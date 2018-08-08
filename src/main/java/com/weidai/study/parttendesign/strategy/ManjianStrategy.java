package com.weidai.study.parttendesign.strategy;


/**
 * @描述
 * @author nic 
 * @time：2018年6月11日 上午10:10:46
 */
public class ManjianStrategy  implements SaleStrategy {

	@Override
	public double getPrice(double originPrice) {
		// 每满300 减 10;
		 int time = ((int)originPrice)/300;
		return originPrice - time*10;
	}
}