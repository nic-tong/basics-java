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


    public static int getMedian(int [] array) {
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
        return array[div];
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
