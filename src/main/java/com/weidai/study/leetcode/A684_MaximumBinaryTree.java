package com.weidai.study.leetcode;

import com.weidai.study.leetcode.tree.TreeNode;

/**
 * @author lianghong.tlh
 * @date 2020/03/19
 */
public class A684_MaximumBinaryTree {


    public TreeNode<Integer> constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0) {
            return null;
        }
        int maxIndex = getMaxIndex(nums);
        TreeNode<Integer> root = new TreeNode<>(nums[maxIndex]);
        int [] leftNumber = subarray(nums, 0, maxIndex);
        root.left = constructMaximumBinaryTree(leftNumber);
        if(maxIndex == nums.length-1) {
            root.right = null;
        } else {
            int[] rightNumber = subarray(nums, maxIndex + 1, nums.length);
            root.right = constructMaximumBinaryTree(rightNumber);
        }
        return root;
    }

    private int getMaxIndex(int[] nums) {

        int temp = 0;
        int tempValue =nums[0];
        for (int i= 0; i< nums.length; i++) {
            if(nums[i] > tempValue) {
                temp = i;
                tempValue = nums[i];
            }
        }
        return temp;
    }

    private int [] subarray(int [] array, int start, int end) {
        if (array == null) {
            return null;
        }

        final int newSize = end - start;
        if (newSize <= 0) {
            return new int[0];
        }
        int [] newInt = new int[newSize];
        for(int i=0; i< newSize; i++) {
            newInt[i] = array[start+i];
        }
        return newInt;
    }
}
