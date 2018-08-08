/**
 * 
 */
package com.weidai.study.lightcontrol;

/**
 * @Description: 用wait 和 notify  实现一个灯 反复开 关的 信号灯。 一个线程负责开灯， 一个线程负责关灯。很像kafka 的消费者生产者模型。
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
