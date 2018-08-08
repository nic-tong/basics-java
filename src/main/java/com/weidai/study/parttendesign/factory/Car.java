package com.weidai.study.parttendesign.factory;


/**
 * @描述
 * @author nic 
 * @time：2018年6月10日 下午3:46:17
 */
public abstract class Car {

	private String wheel;
	private String body;
	public String getWheel() {
		return wheel;
	}
	public void setWheel(String wheel) {
		this.wheel = wheel;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
}
