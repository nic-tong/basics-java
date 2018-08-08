/**
 * 
 */
package com.weidai.study.lightcontrol;

/**
 * @Description: TODO
 * @ClassName: Light
 * @author nic
 * @date: 2018年8月7日 下午11:28:58
 */
public class Light {

	boolean on;
	public void on() {
		System.out.println(System.currentTimeMillis() + " 开灯");
	}
	
	public void off() {
		System.out.println(System.currentTimeMillis() + " 关灯");
	}
}
