/**
 * 
 */
package com.weidai.study.leetcode;

/**
 * @Description: TODO
 * @ClassName: IntegerToRoman_12
 * @author nic
 * @date: 2018年8月28日 下午3:14:58
 */
public class A12_IntegerToRoman {

	public String intToRoman(int num) {
		String M[] = {"", "M", "MM", "MMM"};
		String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
		String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
		String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
		StringBuilder sb = new StringBuilder();
		sb.append(M[num/1000]).append(C[(num%1000)/100]).append(X[(num%100)/10]).append(I[num%10]);
        return sb.toString();

    }
	
	public String intToRoman2(int num) {
		StringBuilder result = new StringBuilder();
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC","L","XL","X","IX","V","IV","I"};

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                result.append(strs[i]);
            }
        }
        
        return result.toString();


	}
}
