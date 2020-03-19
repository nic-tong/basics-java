package com.weidai.study.leetcode.tree;

import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

import com.google.common.collect.Lists;
import com.weidai.study.leetcode.A199_BinaryTreeRightSideView;

/**
 * @author lianghong.tlh
 * @date 2020/03/13
 */
public class BinaryTree {

    /**
     * 求深度
     *
     * @param root
     * @param <T>
     * @return
     */
    public static <T> int death(TreeNode<T> root) {
        if (root == null) {
            return 0;
        }
        return Math.max(death(root.left), death(root.right)) + 1;
    }

    /**
     * 求二叉树中节点的个数
     *
     * @param root
     * @param <T>
     * @return
     */
    public static <T> int numOfTreeNode(TreeNode<T> root) {
        if (root == null) {
            return 0;
        }
        int leftCount = numOfTreeNode(root.left);
        int rightCount = numOfTreeNode(root.right);
        return leftCount + rightCount + 1;
    }

    /**
     * 求二叉树中叶子节点的个数
     *
     * @param root
     * @param <T>
     * @return
     */
    public static <T> int numOfNoChildNode(TreeNode<T> root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = numOfTreeNode(root.left);
        int right = numOfTreeNode(root.right);
        return left + right;
    }

    /**
     * 求 前k层节点的个数。
     * @param root
     * @param k
     * @param <T>
     * @return
     */
    public static <T> int getKNumOfNode(TreeNode<T> root, int k) {
        if (root == null || k < 1) {
            return 0;
        }

        if (k == 1) {
            return 1;
        }
        return getKNumOfNode(root.left, k - 1) + getKNumOfNode(root.right, k - 1);
    }

    /**
     * 前序遍历
     * @param root
     * @param qian
     * @param <T>
     */
    public static <T> void beforBianLi(TreeNode<T> root, List<T> qian) {
        if (root == null) {
            return;
        }
        qian.add(root.value);
        beforBianLi(root.left, qian);
        beforBianLi(root.right, qian);
    }

    public static <T> void innerBianli(TreeNode<T> root, List<T> zhong) {
        if(root == null) {
            return;
        }
        innerBianli(root.left, zhong);
        zhong.add(root.value);
        innerBianli(root.right, zhong);
    }

    /**
     * 层序遍历
     */
    public static <T> void cengxuBianli(TreeNode<T> root, List<T> cengxu) {

        LinkedBlockingDeque<TreeNode<T>> queue = new LinkedBlockingDeque<>();

        queue.push(root);


        while(!queue.isEmpty()) {

            TreeNode<T> node = queue.pop();
            cengxu.add(node.value);

            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static <T> boolean balanceTree(TreeNode<T> root) {
        if (root == null) {
            return true;
        }
        int deathLeft = death(root.left);
        int deathRight = death(root.right);
        if (Math.abs(deathLeft - deathRight) > 1) {
            return false;
        }
        return balanceTree(root.left) && balanceTree(root.right);
    }

    public static <T> TreeNode<T> findCommonParent(TreeNode<T> root, TreeNode<T> t1, TreeNode<T> t2) {
        if (findNode(root.left, t1)) {
            if (findNode(root.right, t2)) {
                return root;
            } else {
                return findCommonParent(root.left, t1, t2);
            }
        } else if (findNode(root.right, t1)) {
            if (findNode(root.left, t2)) {
                return root;
            } else {
                return findCommonParent(root.right, t1, t2);
            }
        }
        return null;
    }

    private static <T> boolean findNode(TreeNode<T> root, TreeNode<T> t1) {
        if (root == null || t1 == null) {
            return false;
        }
        if (root == t1) {
            return true;
        }
        return findNode(root.left, t1) || findNode(root.right, t1);

    }



    /**
     *          1
     *         / \
     *        2  4
     *       /   \
     *      3     5
     *            \
     *            5
     *            \
     *             5
     * @param args
     */
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);

        TreeNode<Integer> leftNode = new TreeNode<>(2);
        TreeNode<Integer> leftNode2 = new TreeNode<>(3);
        TreeNode<Integer> rightNode1 = new TreeNode<>(4);
        TreeNode<Integer> rightNode2 = new TreeNode<>(5);
        TreeNode<Integer> rightNode3 = new TreeNode<>(5);
        TreeNode<Integer> rightNode4 = new TreeNode<>(5);
        root.left = leftNode;
        root.right = rightNode1;
        leftNode.left = leftNode2;
        rightNode1.right = rightNode2;
        rightNode2.right = rightNode3;
        rightNode3.right = rightNode4;

        //System.out.println(death(root));
        //System.out.println(numOfTreeNode(root));
        //System.out.println(numOfNoChildNode(root));
        //System.out.println(getKNumOfNode(root, 3));
        //System.out.println(balanceTree(root));
        List<Integer> qianxu = Lists.newArrayList();
        //beforBianLi(root, qianxu);
        //qianxu.forEach(System.out::println);
        List<Integer> zhongxu = Lists.newArrayList();
        innerBianli(root, zhongxu);
        //zhongxu.forEach(System.out::println);
        List<Integer> chengxu = Lists.newArrayList();
        cengxuBianli(root, chengxu);
        //chengxu.forEach(System.out::println);

        A199_BinaryTreeRightSideView view = new A199_BinaryTreeRightSideView();
        List<Integer> right = view.rightSideView(null);
        right.forEach(System.out::println);
    }
}
