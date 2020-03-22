package com.weidai.study.leetcode;

/**
 * 找出一个无序数组的中位数，利用快排解决
 *
 * @author lianghong.tlh
 * @date 2020/03/22
 */
public class MedianOfList {

    /**
     * 找到基准点
     * @param array
     * @param low
     * @param high
     * @return
     */
    private static int getIndex(int[] array, int low, int high) {
        int temp = array[low];

        while (low < high) {
            while (low < high && array[high] >= array[low]) {
                high--;
            }
            array[low] = array[high];

            while (low < high && array[low] <= array[high]) {
                low++;
            }
            array[high] = array[low];
        }

        array[low] = temp;
        return temp;
    }


    public static double getMedian(int [] array) {
        int low = 0;
        int high = array.length -1;
        int div = low;
        int median = array.length /2;
        while (div!= median) {
            if(div < median) {
                div = getIndex(array, div, high);
            }
            else {
                div = getIndex(array, 0, div);
            }
        }
        if(array.length%2 == 1) {
            return (double)array[div];
        }

        high = div;
        int median2 = median - 1;
        int div2 = low;
        while (div2 != median2) {
            if(div2 < median2) {
                div2 = getIndex(array, div2, high);
            } else {
                div2 = getIndex(array, 0, div2);
            }
        }
        return (array[div] + array[div2])/2d;
    }

    public static void main(String[] args) {
        int []array = {3,1,2,4,6,9};
        System.out.println(getMedian(array));
    }
}
