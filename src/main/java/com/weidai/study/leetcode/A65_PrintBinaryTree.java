package com.weidai.study.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lianghong.tlh
 * @date 2020/03/19
 */
public class A65_PrintBinaryTree {


    public List<List<String>> printTree(TreeNode root) {
        int death = death(root);
        int layer = 0;
        return printLayer(root, layer, death);
    }

    private List<List<String>>  printLayer(TreeNode root, int layer, int death) {
        String [][] strArr = new String[death][(int)Math.pow(2,death) -1];
        int currentDeath = 0;
        List<List<String>> lists = new ArrayList<>();
        int parent = (int)Math.pow(2d, (double)(death - 1))-1;
        addInStringArray(strArr, root,currentDeath, parent, death);
        for(int i=0; i< strArr.length; i++) {
            List<String> stringList = new ArrayList<>();
            for (int j=0; j< strArr[i].length; j++) {
                stringList.add(strArr[i][j] == null? "": strArr[i][j]);

            }
            lists.add(stringList);
        }
        return lists;
    }

    private void addInStringArray(String[][] strArr, TreeNode root, int currentDeath,int parent, int death) {
        if(root == null) {
            return;
        }
        strArr[currentDeath][parent] = String.valueOf(root.val);
        int addIndx = (int)Math.pow(2, death-currentDeath-2);
        addInStringArray(strArr, root.left, currentDeath+1, parent-addIndx, death);
        addInStringArray(strArr, root.right, currentDeath+1, parent+addIndx, death);
    }

    private int death(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(death(root.left), death(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node.left = node1;
        node.right= node2;
        node1.right = node4;
        A65_PrintBinaryTree a65_printBinaryTree = new A65_PrintBinaryTree();
        a65_printBinaryTree.printTree(node);
    }
}
