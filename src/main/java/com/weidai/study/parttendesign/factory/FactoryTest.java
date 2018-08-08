package com.weidai.study.parttendesign.factory;


/**
 * @描述
 * @author nic 
 * @time：2018年6月10日 下午3:50:46
 */
public class FactoryTest {

	public static void main(String[] args) {
//		SimpleFactory factory = new SimpleFactory();
//		System.out.println(factory.getCar("benz"));
		
		
		/**
		 * 工厂方法模式：需要具体是那个工厂来生产车
		 */
//		Factory factory = new AudiFactory();
//		System.out.println(factory.getCar());
		
		/**
		 * 抽象工厂模式： 
		 */
		Default4SFactory factory = new Default4SFactory();
		System.out.println(factory.getCar("benz"));
	}
}
