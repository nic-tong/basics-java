package com.weidai.study.leetcode;

import java.util.Arrays;

/**
 * 最长重复子串问题
 * @author lianghong.tlh
 * @date 2020/03/24
 */
public class A1044_Longest_Duplicate_SubString {




    public static String getMaxSubStr(String str) {
        String [] subStr = new String[str.length()];

        for (int i=0; i< str.length(); i++) {
            subStr[i] = str.substring(i);
        }
        Arrays.sort(subStr);
        int maxLength = 0;
        String tempStr = "";
        for(int i=0; i< subStr.length - 1 ; i++) {
            String  str1 = subStr[i];
            String str2 = subStr[i+1];
            int max = getNaberMax(str1, str2);
            if(max > maxLength) {
                maxLength = max;
                tempStr = str1.substring(0, maxLength);
            }
        }
        return tempStr;
    }

    private static int getNaberMax(String str1, String str2) {
        int i=0;
        while(i< str1.length() && i< str2.length() && str1.charAt(i) == str2.charAt(i)) {
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(getMaxSubStr("abcdsbdkeajsdakjwlerjsjdfsmbfbsdjfklsdhjshdgsdfksfmnnklsjdfk"));
    }
}
