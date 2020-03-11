package com.weidai.study.leetcode;

import static com.weidai.study.dynamic.programming.MaxLengthSubStringDP.maxLengthSubString;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 *
 * @author lianghong.tlh
 * @date 2020/03/11
 */
public class A14_LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String maxPrefix = strs[0];
        for(int i=1; i< strs.length;i++) {
            if("".equals(maxPrefix)) {
                return "";
            }
            maxPrefix = maxPrefixSubString(maxPrefix, strs[i]);
        }
        return maxPrefix;
    }

    private static String maxPrefixSubString(String maxPrefix, String str) {
        int minLength = maxPrefix.length() > str.length()? str.length(): maxPrefix.length();
        int maxSameChar = 0;
        for(int i=0; i< minLength; i++) {
            if(maxPrefix.charAt(i) == str.charAt(i)){
                maxSameChar++;
            }else {
                break;
            }
        }
        return maxPrefix.substring(0, maxSameChar);
    }

    public static void main(String[] args) {
        String []strs = {"flwww","flwwwsss","fcesss"};

        System.out.println("prefix:"+longestCommonPrefix(strs));
    }
}
