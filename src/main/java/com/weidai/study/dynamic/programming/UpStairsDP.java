package com.weidai.study.dynamic.programming;

/**
 * 动态规划上楼梯 每次只能上1层或2层  上n层一共有多少种上法
 *
 * @author lianghong.tlh
 * @date 2020/03/19
 */
public class UpStairsDP {


    public static int upStairRecursive(int n) {
        if (n == 1) {
            return 1;
        }
        if(n== 2) {
            return 2;
        }

        return upStairRecursive(n-1) + upStairRecursive(n-2);
    }


    public static int upStairNonRecursive(int n) {
        int [] solution = new int[n];
        solution[0] = 1;
        solution[1] = 2;
        for (int i=2; i< n; i++) {
            solution[i] = solution[i-1] + solution[i-2];
        }
        return solution[n-1];
    }

    public static void main(String[] args) {
        System.out.println(upStairNonRecursive(19));
    }
}
