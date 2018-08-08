package com.weidai.study.parttendesign.prototype;


/**
 * @描述
 * @author nic 
 * @time：2018年6月11日 上午9:40:09
 */
public class PrototypeClient {

	public static void main(String[] args) {
		Prototype pa = new ProductAPrototype("产品1号 ");
		pa.show();
		
		ProductAPrototype pb = (ProductAPrototype)pa.clone();
		pb.show();
		System.out.println(pa == pb);
		System.out.println(pa.getClass() == pb.getClass());
	}
}
