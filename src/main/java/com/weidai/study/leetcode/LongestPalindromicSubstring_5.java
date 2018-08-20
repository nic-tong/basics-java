package com.weidai.study.leetcode;

import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Template;

import com.alibaba.druid.sql.visitor.functions.If;


/**
 * @描述
 * @author nic 
 * @time：2018年8月17日 下午9:54:26
 */
public class LongestPalindromicSubstring_5 {

	public static String longestPalindrome(String str) {

		char [] newChar = new char[str.length() * 2 + 1];
		for (int i=0; i< newChar.length; i++) {
			newChar[i] = i%2 == 0 ? '#': str.charAt(i/2);
		}
		int start = 0;
		int end = 0;
		int longStr = 0;
		for (int i =0 ; i< newChar.length ; i++) {
			int j=1;
			while (i-j>=0 && i+j < newChar.length && newChar[i-j] == newChar[i+j]) {
				j++;
			}
			int temp = 2 * j - 1;
			if (temp > longStr) {
				longStr = temp;
				start = i-j+1;
				end = i+j;
			}
		}
		return str.substring(start/2, end/2);
	}
	
	public static void main(String[] args) {
		System.out.println(longestPalindrome("cc"));
	}
}
