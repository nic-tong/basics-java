package com.weidai.study.leetcode;

import java.util.Arrays;
import java.util.List;

import com.weidai.study.leetcode.tree.TreeNode;

/**
 * 二叉树右视图
 * @author lianghong.tlh
 * @date 2020/03/17
 */
public class A199_BinaryTreeRightSideView {


    public List<Integer> rightSideView(TreeNode<Integer> root) {

        int deep = getDeep(root);
        Integer [] integers = new Integer[deep];
        rightSideView(root, integers,0);
        return Arrays.asList(integers);

    }

    /**
     * 递归 求每层的右边，设置最右边为出现的值。
     * @param root
     * @param integers
     * @param deep
     */
    public void rightSideView(TreeNode<Integer> root, Integer [] integers, int deep) {
        if(root == null) {
            return;
        }
        integers[deep] = root.value;
        rightSideView(root.left, integers, deep+1);
        rightSideView(root.right, integers, deep+1);
    }

    /**
     * 求树的深度
     * @param root
     * @return
     */
    public int getDeep(TreeNode<Integer> root) {
        if(root == null) {
            return 0;
        }
        int deepLeft = getDeep(root.left);
        int deepRight = getDeep(root.right);
        return Math.max(deepLeft, deepRight) + 1;
    }
}
