package com.weidai.study.spring;

public class MyBatisTest {

	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		t1.start();
//		synchronized (MyThread.s) {
//			MyThread.s.notifyAll();
//		}
		System.out.println(Thread.currentThread().getName() +"主线");
		t2.start();
	}
}

class MyThread extends Thread {

	private volatile int sum=0;
	public static String s = "123";
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(sum < 1000) {
			synchronized (s) {
				try {
					System.out.println(Thread.currentThread().getName() +"我开始等待了：" + s);
					Thread.sleep(60000);
					System.out.println(Thread.currentThread().getName() + "我开始运行了：" + s);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			sum++;
		}
	}
	
}