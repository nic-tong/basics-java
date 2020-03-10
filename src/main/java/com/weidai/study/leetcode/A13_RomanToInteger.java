package com.weidai.study.leetcode;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * @author lianghong.tlh
 * @date 2020/03/11
 */
public class A13_RomanToInteger {

    public static int romanToInteger(String roman) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC","L","XL","X","IX","V","IV","I"};

        int intValue = 0;
        for(int i=0;i< strs.length;i++) {
            while(roman.startsWith(strs[i])){
                intValue += values[i];
                roman = roman.substring(strs[i].length());
            }
        }
        System.out.println(intValue);
        return intValue;
    }

    public static void main(String[] args) {
        System.out.println(romanToInteger("MCMXCIV"));
    }

}
