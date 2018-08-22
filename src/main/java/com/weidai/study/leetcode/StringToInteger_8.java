/**
 * 
 */
package com.weidai.study.leetcode;

import scala.collection.generic.BitOperations.Int;

/**
 * @Description: TODO
 * @ClassName: StringToInteger_8
 * @author nic
 * @date: 2018年8月22日 上午9:48:06
 */
public class StringToInteger_8 {

	public static int myAtoi(String str) {
		String newStr = str.trim();
		if (newStr.length()== 0 || "-".equals(newStr) || "+".equals(newStr))
			return 0;
		int result = 0;
		boolean zheng = true;
		int startChar = newStr.charAt(0);
		if (startChar == '-') {
			zheng = false;
			newStr = newStr.substring(1);
		} else if (startChar == '+') {
			newStr = newStr.substring(1);
		} else if (startChar < 48 || startChar > 57) {
			return 0;
		}
		for (char c : newStr.toCharArray()) {
			int i = c-48;
			if (i > -1 && i < 10) {
				if (result > (Integer.MAX_VALUE-i)/10 ) return zheng? Integer.MAX_VALUE: Integer.MIN_VALUE;
				result = result * 10 + i;
			} else {
				break;
			}
		}
		return zheng? result: -result;
	}
	
	public static void main(String[] args) {
		System.out.println(myAtoi("2147483647"));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
	}
}
