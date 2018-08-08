package com.weidai.study.parttendesign.singleton;


/**
 * @描述
 * @author nic 
 * @time：2018年8月5日 下午6:41:39
 */
public class SingleTonTest {

	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance();
		System.out.println(singleton.toString());
		
		Singleton singleton2 = Singleton.getInstance();
		System.out.println(singleton2.toString());
		
		Singleton singleton3 = Singleton.getInstance();
		System.out.println(singleton3.toString());
	}
}
