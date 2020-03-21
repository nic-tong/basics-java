package com.weidai.study.leetcode;

/**
 * @author lianghong.tlh
 * @date 2020/03/21
 */
public class A979_DistributeCoinsInBinaryTree {

    private int ans =0;
    public int distributeCoins(TreeNode root) {
        getSum(root);
        return ans;
    }

    public int getSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int l = getSum(root.left );
        int r = getSum(root.right);
        ans += Math.abs(l) + Math.abs(r);
        return l + r + root.val - 1;
    }
}
