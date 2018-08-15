/**
 * 
 */
package com.weidai.study.threadpool;

/**
 * @Description: TODO
 * @ClassName: OOMTest
 * @author nic
 * @date: 2018年8月13日 下午9:38:17
 */
public class OOMTest {

	public static void testOOM() {
		for(;;) {
			byte [] a = new byte[1024];
		}
	}
	
	
	public static void main(String[] args) {
		testOOM();
	}
}
