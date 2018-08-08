package com.weidai.study;

import java.util.HashSet;

public class ThreadLocalTest {

	
	private static void testThreadLocal() {
	    Thread t = new Thread() {
	        ThreadLocal<String> mStringThreadLocal = new ThreadLocal<>();

	        @Override
	        public void run() {
	            super.run();
	            mStringThreadLocal.set(this.getName() + "droidyue.com");
	            mStringThreadLocal.get();
	        }
	    };

	    t.start();
	}
	
	public static void main(String[] args) {
		HashSet<String> set1 = new HashSet();
		set1.add("12");
		set1.add("21");
		HashSet<String> set2 = new HashSet<String>();
		set2.add("21");
		set2.add("12");
		System.out.println(set1.toString());
		System.out.println(set1.equals(set2));
//		testThreadLocal();
	}
}
