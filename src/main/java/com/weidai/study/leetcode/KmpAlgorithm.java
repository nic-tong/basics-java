package com.weidai.study.leetcode;

import java.util.Arrays;

/**
 * KMP算法  求一个字符串 是否包含另外一个字符串
 *
 * @author lianghong.tlh
 * @date 2020/03/10
 */
public class KmpAlgorithm {

    public static boolean contains(String originStr, String patternStr) {

        char[] originChar = originStr.toCharArray();

        char[] patternChar = patternStr.toCharArray();

        int[] nextPrefix = new int[patternChar.length];

        nextPrefix[0] = -1;
        for (int i = 1; i < nextPrefix.length; i++) {
            nextPrefix[i] = getAffix(patternChar, i-1);
        }

        // 进行KMP比较
        int startIndex = 0;
        for (int j = 0; j < originChar.length; j++) {
            if(originChar[j] == patternChar[j-startIndex]) {
                if(j-startIndex == patternChar.length-1) {
                    return true;
                }
            }else {
                startIndex += j - startIndex - nextPrefix[j-startIndex];
                if(startIndex < j){
                    j--;
                }
            }
        }
        return false;
    }

    /**
     * 求前后缀 最大匹配数 a b a b c
     *
     * @param patternChar
     * @param maxIndex
     * @return
     */
    private static int getAffix(char[] patternChar, int maxIndex) {
        for (int i = maxIndex; i > 0; i--) {
            char [] subChar1 = Arrays.copyOfRange(patternChar,0, i);
            char [] subChar2 = Arrays.copyOfRange(patternChar,maxIndex-i+1, maxIndex+1);
            for(int re=0;re< subChar1.length;re++) {
                if(subChar1[re] != subChar2[re]) {
                    break;
                }
                if(re+1 == subChar1.length){
                    return subChar1.length;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        char[] pattern = {'a','b','a','b','c'};

        System.out.println(contains("aaaaaaaaaaaab","aaaab"));
    }
}
