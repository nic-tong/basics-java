package com.weidai.study.leetcode;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * @author lianghong.tlh
 * @date 2020/03/19
 */
public class A136_SingleNumber {

    /**
     * 使用异或解决。 0^n == n;  n^n == 0
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int k = 0;
        for(int i=0; i< nums.length; i++) {
            k = k^nums[i];
        }
        return k;
    }
}
