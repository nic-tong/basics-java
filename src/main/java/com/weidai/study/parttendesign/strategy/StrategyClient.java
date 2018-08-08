package com.weidai.study.parttendesign.strategy;


/**
 * @描述
 * @author nic 
 * @time：2018年6月11日 上午10:18:13
 */
public class StrategyClient {

	public static void main(String[] args) {
		
		VIPSales sale = new VIPSales(new ManjianStrategy());
		double p = sale.getFinalPrice(500);
		System.out.println(p);
		
		sale = new VIPSales(new TwoOffStrategy());
		p = sale.getFinalPrice(1000);
		System.out.println(p);
	}
}
