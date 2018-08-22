package com.weidai.study.leetcode;

import jnr.ffi.types.mode_t;

/**
 * @描述
 * @author nic
 * @time：2018年8月22日 下午1:56:12
 */
public class PalindromeNumber_9 {

	/**
	 * 解法1 翻转整个数，看两个数是否相等
	 * 
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		int originX = x;
		int y = 0;
		while (x != 0) {
			int mod = x % 10;
			y = y * 10 + mod;
			x = x / 10;
		}
		return originX == y;
	}

	/**
	 * 解法2 翻转一半数字，看是否相等，或者奇数对称 除以10对比
	 * 
	 * @param x
	 * @return
	 */
	public boolean isPalindrome2(int x) {
		if (x < 0 || (x % 10 == 0 && x != 0))
			return false;
		int y = 0;
		while (x > y) {
			y = y * 10 + x % 10;
			x = x / 10;
		}
		return x == y || x == y / 10;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome(101));
	}
}
