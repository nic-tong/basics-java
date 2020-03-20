package com.weidai.study.bytedance;

/**
 * 给定一个数，算出平均值是整数的算法。例如：5 平均 2 份，则结果为，2 和 3；8 平均为 3 份，
 * 则为 2，3，3；11 平均 4 份，则为 2，3，3，3；15 平均 3 份，则为：5，5，5。求算法
 * @author lianghong.tlh
 * @date 2020/03/21
 */
public class IntegerAverage {


    public static int [] averageInteger(int number, int copies) {

        assert number > 0;
        assert number >= copies;
        int mode = number % copies;
        int avg = number / copies;

        int [] array = new int[copies];
        for(int i=0; i< array.length; i++) {
            array[i] =avg + ((copies - mode) > i ? 0 : 1);
        }
        return array;
    }

    public static void main(String[] args) {

        int [] value = averageInteger(5,2);
        for (int i : value) {
            System.out.print(i + ",");
        }
        System.out.println();
        value = averageInteger(8, 3);
        for (int i : value) {
            System.out.print(i + ",");
        }
        System.out.println();
        value = averageInteger(11, 4);
        for (int i : value) {
            System.out.print(i + ",");
        }
        System.out.println();
        value = averageInteger(15, 3);
        for (int i : value) {
            System.out.print(i + ",");
        }
    }
}
