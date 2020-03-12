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

    /**
     * 固定一个值，后面两个值左右移动
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++) {
            if(i == 0 || nums[i] != nums[i-1]) {
                int j = i+1, k = nums.length-1;
                while(j < k) {
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        res.add(list);
                        j++;
                        k--;
                        while(j < k && nums[j] == nums[j-1]) {
                            j++;
                        }
                        while(j < k && nums[k] == nums[k+1]) {
                            k--;
                        }
                    }else if(nums[i] + nums[j] + nums[k] < 0) {
                        j++;
                    }else {
                        k--;
                    }
                }
            }
        }

        return res;
    }
}
