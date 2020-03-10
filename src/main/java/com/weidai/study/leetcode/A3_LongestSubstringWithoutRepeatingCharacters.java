package com.weidai.study.leetcode;

import java.util.HashMap;
import java.util.Map;

import com.google.common.primitives.Ints;


/**
 * @描述
 * @author nic 
 * @time：2018年8月16日 下午6:56:50
 */
public class A3_LongestSubstringWithoutRepeatingCharacters {

	public static int lengthOfLongestSubstring(String s) {
		if (s.length() == 0)
			return 0;
		Map<Character, Integer> map = new HashMap<>();
		int maxLength = 0;
		int start = 0;
		for (int i=0; i< s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				if (map.get(c) > start) {
					start = map.get(c);
				}
			}
			maxLength = Math.max(maxLength, i-start + 1);
			System.out.println("c:" + c + ", i:" + i + ", start:" + start + ", maxLen: "+ maxLength) ;
			map.put(c, i+1);
		}
		return maxLength;
	}
	
	public static int lengthOfLongestSubstring2(String s) {
		if (s.length() == 0)
			return 0;
		int [] charArr = new int [128]; 
		int maxLength = 0;
		int start = 0;
		for (int i=0; i< s.length(); i++) {
			char c = s.charAt(i);
			if(charArr[c] > start) {
				start = charArr[c];
			}
			charArr[c] = i + 1;
			maxLength = Math.max(maxLength , i-start + 1);
		}
		return maxLength;
	}
	
	public static void main(String[] args) {
		int len = lengthOfLongestSubstring2("abcdacd");
		
		System.out.println(len);
	}
}
