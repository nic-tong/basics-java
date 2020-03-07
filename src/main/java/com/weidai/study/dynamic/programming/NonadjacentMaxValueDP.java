package com.weidai.study.dynamic.programming;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * 求一组数列中不相邻的数字最大和的解。
 * <p>
 * 如：3 1 1 9 1   最大和的解为 12
 * <p>
 * 解题思路 假定第i个值的期望最大为OPT(i), 那么OPT(i)= max( a[i]+ OPT(i-2), OPT[i-1])
 * 递归的出口为：
 *
 * 当i=2 时，OPT(2) = max(a[0], a[1])
 * 当i=1时，OPT(1) = a[1]
 *
 * @author lianghong.tlh
 * @date 2020/03/08
 */
public class NonadjacentMaxValueDP {



    public static int getMaxValueNonRecursive(int [] array) {

        int [] valueOpt = new int[array.length];
        valueOpt[0] = array[0];
        valueOpt[1] = Math.max(array[0], array[1]);

        for (int i=2; i< array.length; i++) {
            int chooseValue = array[i] + valueOpt[i-2];
            int nonChooseValue = valueOpt[i-1];
            valueOpt[i] = Math.max(chooseValue, nonChooseValue);
        }
        return valueOpt[array.length-1];
    }

    public static MaxValue getMaxValueRecursive(int[] array, int i) {
        if (i == 0) {
            MaxValue maxValue = new MaxValue();
            maxValue.setMaxValue(array[0]);
            maxValue.addAll(Lists.newArrayList(0));
            return maxValue;
        }

        if (i == 1) {
            MaxValue maxValue = new MaxValue();
            if (array[0] > array[1]) {
                maxValue.setMaxValue(array[0]);
                maxValue.addAll(Lists.newArrayList(0));
            } else {
                maxValue.setMaxValue(array[1]);
                maxValue.addAll(Lists.newArrayList(1));
            }
            return maxValue;
        }
        MaxValue MaxValue_2 = getMaxValueRecursive(array, i - 2);
        MaxValue MaxValue_1 = getMaxValueRecursive(array, i - 1);
        int chooseValue = array[i] + MaxValue_2.getMaxValue();
        int nonChooseValue = MaxValue_1.getMaxValue();
        MaxValue maxValue = new MaxValue();
        if (chooseValue > nonChooseValue) {
            maxValue.setMaxValue(chooseValue);
            maxValue.addAll(MaxValue_2.getIndexs());
            maxValue.getIndexs().add(i);
        } else {
            maxValue.setMaxValue(nonChooseValue);
            maxValue.addAll(MaxValue_1.getIndexs());
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[] array = {3, 1, 1, 9, 1,2,4,5,6,2,5,4,9,1,9,1,1,1,1,7,6,5,4,3,9};
        MaxValue maxValue = getMaxValueRecursive(array, array.length - 1);
        System.out.println(maxValue.getMaxValue());
        System.out.println(maxValue.getIndexs());

        System.out.println(getMaxValueNonRecursive(array));
    }

    public static class MaxValue {
        public int getMaxValue() {
            return maxValue;
        }

        public void setMaxValue(int maxValue) {
            this.maxValue = maxValue;
        }

        /**
         * 最大期望值
         */
        int maxValue;

        public List<Integer> getIndexs() {
            return indexs;
        }

        public void setIndexs(List<Integer> indexs) {
            this.indexs = indexs;
        }

        /**
         * 下标集合
         */
        List<Integer> indexs = new ArrayList<>();

        public void addAll(List<Integer> oldIndexs) {
            indexs.addAll(oldIndexs);
        }

    }

}
