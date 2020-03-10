/**
 * 
 */
package com.weidai.study.leetcode;

/**
 * @Description: TODO
 * @ClassName: ReverseInteger
 * @author nic
 * @date: 2018年8月21日 下午4:40:27
 */
public class A7_ReverseInteger {
	  
    public static int reverse(int x) {
        boolean zheng = x < 0? false: true;
		if (!zheng)
			x = -x;
		int reverx = 0;
		while(x>0) {
			int mod = x%10;
            if (reverx > Integer.MAX_VALUE/10) return 0;
			reverx  = reverx * 10 + mod;
			x = x/10;
		} 
		return zheng ? reverx : -reverx;
    }
	public static void main(String[] args) {
		System.out.println(reverse(-1100));
	}
}
