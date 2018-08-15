/**
 * 
 */
package com.weidai.study.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: TODO
 * @ClassName: ThreadPoolTest
 * @author nic
 * @date: 2018年8月10日 下午9:25:05
 */
public class ThreadPoolTest {

	public  static ExecutorService threadPool = Executors.newCachedThreadPool();
	
	public static void main(String[] args) {
		for (int i=0; i< 2; i++) {
			threadPool.execute(new NewThread());
		}
		try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		threadPool.shutdown();
	}
	
	static class NewThread implements Runnable {

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			double i = 1.0f;
			while(i < 2.0f) {
				i = i*1.00001f;
				if (i > 1.8f) {
					i = i/2.0f;
				}
			}
			System.out.println(i + " 执行");
		}
		
	}
}
