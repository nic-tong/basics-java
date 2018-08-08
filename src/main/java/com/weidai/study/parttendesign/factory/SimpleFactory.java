package com.weidai.study.parttendesign.factory;


/**
 * @描述
 * @author nic 
 * @time：2018年6月10日 下午3:45:39
 */
public class SimpleFactory {

	
	public Car getCar(String name) {
		if ("benz".equalsIgnoreCase(name)) {
			return new Benz();
		} else if ("audi".equalsIgnoreCase(name)) {
			return new Audi();
		} else if ("bmw".equalsIgnoreCase(name)) {
			return new Bmw();
		} else {
			return null;
		}
	}
}
