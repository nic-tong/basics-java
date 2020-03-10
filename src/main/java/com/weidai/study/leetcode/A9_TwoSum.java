/**
 * 
 */
package com.weidai.study.leetcode;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * @Description: 
 * 	Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *	You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 
 * Example:
 * 	Given nums = [2, 7, 11, 15], target = 9,
 *	Because nums[0] + nums[1] = 2 + 7 = 9,
 *	return [0, 1].
 * 
 * @ClassName: TwoSum_1
 * 
 * @author nic
 * @date: 2018年8月14日 下午9:01:17
 */
public class A9_TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        if (nums.length<2) {
            return new int[0];
        }
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i=0; i< nums.length; i++) {
            Integer j = numMap.get(target - nums[i]);
            if (null != j) {
  
                int [] result = {j, i};
                return result;
            } else {
                numMap.put(nums[i], i);
            }
        }
        return new int[0];
    }
    
    public static void main(String[] args) {
    	int [] nums = new int [] {2, 3, 4, 7, 11, 15};
    	int target = 9;
    	int [] result = twoSum(nums, target);
    	System.out.println(JSON.toJSON(result));
	}
}
