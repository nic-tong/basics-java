/**
 * 
 */
package com.weidai.study.lightcontrol;

/**
 * @Description: TODO
 * @ClassName: LightTest
 * @author nic
 * @date: 2018年8月8日 上午9:12:20
 */
public class LightTest {

	public static void main(String[] args) {
		Light light = new Light();
		Thread ont = new Thread(new OnThread(light));
		Thread offt = new Thread(new OffThread(light));
		ont.start();
		offt.start();
	}
}
