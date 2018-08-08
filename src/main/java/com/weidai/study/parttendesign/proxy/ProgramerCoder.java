package com.weidai.study.parttendesign.proxy;


/**
 * @描述
 * @author nic 
 * @time：2018年6月9日 上午1:40:08
 */
public class ProgramerCoder implements Person {

	private String idcard;
	private String name;
	@Override
	public void buyTicket() {
		System.out.println("我要买高铁火车票");
	}
}
