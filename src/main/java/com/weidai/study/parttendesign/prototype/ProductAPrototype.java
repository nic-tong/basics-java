package com.weidai.study.parttendesign.prototype;


/**
 * @描述
 * @author nic 
 * @time：2018年6月11日 上午9:39:34
 */
public class ProductAPrototype extends Prototype {

	String intraduction;
	public ProductAPrototype(String intraduction) {
		this.intraduction = intraduction;
	}
	public void show() {
		System.out.println("我是产品:" + intraduction+ "公司名称:" + name + " 地址:" + address);
	}
}
