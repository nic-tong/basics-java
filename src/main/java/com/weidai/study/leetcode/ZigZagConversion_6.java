/**
 * 
 */
package com.weidai.study.leetcode;

/**
 * @Description: TODO
 * @ClassName: ZigZagConversion_6
 * @author nic
 * @date: 2018年8月21日 下午3:53:40
 */
public class ZigZagConversion_6 {

	public static String convert(String s, int numRows) {
		if (s.length() <= numRows || numRows == 1)
			return s;
		StringBuilder [] rows = new StringBuilder[numRows];
		for(int i=0; i< rows.length ;i++ ) rows[i] = new StringBuilder();
		int row =0;
		boolean up = true;
		for (char c : s.toCharArray()) {
			rows[row].append(c);
			if (row == numRows-1 && up == true) {
				up = false;
			} else if(row == 0 && up == false) {
				up = true;
			}
			row += up ? 1 : -1; 
		}
		StringBuilder newStr = new StringBuilder();
		for (StringBuilder r : rows) {
			newStr.append(r);
		}
		return newStr.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(convert("abcd", 3));
	}
}
