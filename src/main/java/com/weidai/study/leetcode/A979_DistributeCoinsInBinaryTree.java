package com.weidai.study.leetcode;

/**
 * 给定一个有 N 个结点的二叉树的根结点 root，树中的每个结点上都对应有 node.val 枚硬币，并且总共有 N 枚硬币。
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
