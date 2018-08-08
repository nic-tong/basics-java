/**
 * 
 */
package com.weidai.study;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: TODO
 * @ClassName: VolatileTest
 * @author nic
 * @date: 2018年8月7日 下午4:06:05
 */
public class VolatileTest {

	public static volatile int race = 0;
	
	private static ReentrantLock lock = new ReentrantLock(true);
	public static void increase() {
		lock.lock();
		System.out.println(Thread.currentThread().getName());
		race = race + 1;
		lock.unlock();
	}
	
	static final int THREAD_COUNT = 20;
	
	public static void main(String[] args) throws InterruptedException {
		Thread [] threads = new Thread[THREAD_COUNT];
		CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT);
		for (int i=0; i< THREAD_COUNT; i++) {
			threads[i] = new Thread(new Runnable() {
				
				@Override
				public void run() {
					for (int i = 0; i< 3 ; i++) {
						increase();
					}
					countDownLatch.countDown();
				}
			});
			threads[i].start();
		}
		countDownLatch.await();
		
		System.out.println(race);
	}
}
