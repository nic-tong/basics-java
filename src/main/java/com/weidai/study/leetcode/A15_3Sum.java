package com.weidai.study.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique
 * triplets in the array which gives the sum of zero.
 *
 * @author lianghong.tlh
 * @date 2020/03/12
 */
public class A15_3Sum {

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;
        boolean bigInteger = true;
        int turn = 1;
        int k = i + 1;
        List<List<Integer>> list = new ArrayList<>();
        while (i < 0 && j > 0) {
            int sum = nums[i] + nums[j] + nums[k];
            if (sum == 0) {
                list.add(Lists.newArrayList(nums[i], nums[k], nums[j]));
                k = k + turn;
                if(turn>0) {
                    i=i+1;
                } else {
                    j= j-1;
                }
                continue;
            }

        }
        return list;
    }
}
