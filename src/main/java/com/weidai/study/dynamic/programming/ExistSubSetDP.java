package com.weidai.study.dynamic.programming;

/**
 * 存在一个整数的数组arr[n]， 是否存在数字之和为N的子集，如果存在返回true ，如果不存在返回false
 *
 * 假定第i个值选 Opt[i] = Opt[i-1]+ arr
 * @author lianghong.tlh
 * @date 2020/03/09
 */
public class ExistSubSetDP {



    public static boolean existSubSetRecursive(int []array, int i, int sum) {
        if(sum == 0) {
            return true;
        }
        if(i==0) {
            return sum == array[i];
        }
        if(sum < 0) {
            return false;
        }
        return existSubSetRecursive(array, i-1, sum-array[i]) || existSubSetRecursive(array, i-1, sum);
    }


    public static boolean existSubSetNonRecursive(int [] array, int sum) {
        boolean [][] optArray = new boolean[array.length][sum+1];

        for (int i=0; i< array.length;i++) {
            optArray[i][0]=true;
        }
        for (int j=0; j < sum+1;j++) {
            optArray[0][j] = (array[0] == j);
        }

        for (int i=1; i< array.length;i++) {
            for (int j=1; j< sum+1; j++) {
                if(j< array[i]) {
                    optArray[i][j] = optArray[i - 1][j];
                } else {
                    optArray[i][j] = optArray[i - 1][j - array[i]] || optArray[i - 1][j];
                }
            }
        }
        return optArray[array.length-1][sum];
    }

    public static void main(String[] args) {
        int [] array = {22,3,5,6,7,8,9,5,3};

        System.out.println(existSubSetRecursive(array, array.length-1, 4));
        System.out.println(existSubSetRecursive(array, array.length-1, 12));
        System.out.println(existSubSetRecursive(array, array.length-1, 38));

        System.out.println(existSubSetNonRecursive(array,  4));
        System.out.println(existSubSetNonRecursive(array,  12));
        System.out.println(existSubSetNonRecursive(array,  38));
    }
}
