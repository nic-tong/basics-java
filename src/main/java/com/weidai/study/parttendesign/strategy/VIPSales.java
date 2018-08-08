package com.weidai.study.parttendesign.strategy;


/**
 * @描述
 * @author nic 
 * @time：2018年6月11日 上午10:14:29
 */
public class VIPSales {

	SaleStrategy strategy;
	
	public VIPSales(SaleStrategy s) {
		this.strategy = s;
	}
	public double getFinalPrice(double price) {
		return strategy.getPrice(price);
	}
}
