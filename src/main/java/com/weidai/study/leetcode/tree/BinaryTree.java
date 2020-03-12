package com.weidai.study.leetcode.tree;

/**
 * @author lianghong.tlh
 * @date 2020/03/13
 */
public class BinaryTree {

    /**
     * 求深度
     * @param root
     * @param <T>
     * @return
     */
    public  static <T>  int death(TreeNode<T> root) {
        if(root == null) {
            return 0;
        }
        return Math.max(death(root.left),death(root.right)) + 1;
    }

    /**
     * 求二叉树中节点的个数
     * @param root
     * @param <T>
     * @return
     */
    public static <T> int numOfTreeNode(TreeNode<T> root) {
        if(root == null) {
            return 0;
        }
        int leftCount = numOfTreeNode(root.left);
        int rightCount = numOfTreeNode(root.right);
        return leftCount + rightCount + 1;
    }

    /**
     * 求二叉树中叶子节点的个数
     * @param root
     * @param <T>
     * @return
     */
    public static <T> int numOfNoChildNode(TreeNode<T> root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        int left = numOfTreeNode(root.left);
        int right = numOfTreeNode(root.right);
        return left + right;
    }


    public static  <T> int getKNumOfNode(TreeNode<T> root, int k) {
        if(root == null|| k < 1) {
            return 0;
        }

        if(k == 1) {
            return 1;
        }
        return getKNumOfNode(root.left, k-1) + getKNumOfNode(root.right, k-1);
    }

    public static <T> boolean balanceTree(TreeNode<T> root) {
        if(root == null) {
            return true;
        }
        int deathLeft = death(root.left);
        int deathRight = death(root.right);
        if(Math.abs(deathLeft - deathRight) > 1) {
            return false;
        }
        return balanceTree(root.left) && balanceTree(root.right);
    }


    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);

        TreeNode<Integer> leftNode = new TreeNode<>(2);
        TreeNode<Integer> leftNode2 = new TreeNode<>(3);
        TreeNode<Integer> rightNode1 = new TreeNode<>(4);
        TreeNode<Integer> rightNode2 = new TreeNode<>(5);
        TreeNode<Integer> rightNode3 = new TreeNode<>(5);
        TreeNode<Integer> rightNode4 = new TreeNode<>(5);
        root.left =leftNode;
        root.right = rightNode1;
        leftNode.left = leftNode2;
        rightNode1.right = rightNode2;
        rightNode2.right = rightNode3;
        rightNode3.right = rightNode4;

        System.out.println(death(root));
        System.out.println(numOfTreeNode(root));
        System.out.println(numOfNoChildNode(root));
        System.out.println(getKNumOfNode(root,3));
        System.out.println(balanceTree(root));
    }
}
