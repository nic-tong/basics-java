package com.weidai.study.dynamic.programming;

/**
 * 求最长公共子序列
 * Z是序列X与Y的公共子序列,如果Z是X的子序列也是Y的子序列。
 *
 * @author lianghong.tlh
 * @date 2020/03/09
 */
public class MaxLengthSubStringDP {

    public  static  String maxLengthSubString(String str1, String str2) {
        if(str1.length() == 0 || str2.length() == 0) {
            return "";
        }

        int [][] array = new int[str1.length()][str2.length()];
        int maxI = 0;
        int maxLength = 0;
        for(int i=0; i< str1.length();i++) {
            if(str1.charAt(i) == str2.charAt(0)) {
                array[i][0]= 1;
                maxI = i;
                maxLength = 1;
            } else {
                array[i][0] = 0;
            }
        }
        for(int j=1; j< str2.length(); j++) {
            if(str1.charAt(0) == str2.charAt(j)) {
                array[0][j]= 1;
                if(maxLength < 1) {
                    maxLength = 1;
                }
            } else {
                array[0][j] = 0;
            }
        }

        for(int i=1; i<str1.length();i++) {
            for(int j=1; j< str2.length(); j++) {
                if(str1.charAt(i) == str2.charAt(j)) {
                    array[i][j] = array[i-1][j-1] + 1;
                    if(maxLength < array[i][j]) {
                        maxI = i;
                        maxLength = array[i][j];
                    }
                } else {
                    array[i][j] = 0;
                }
            }
        }

        return str1.substring(maxI-maxLength+1,maxI + 1);
    }

    public static void main(String[] args) {
        System.out.println(maxLengthSubString("ababc", "ab"));
    }
}
