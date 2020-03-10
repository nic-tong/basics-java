/**
 * 
 */
package com.weidai.study.leetcode;

/**
 * @Description: TODO
 * @ClassName: MedianOfTwoSortedArrays_4
 * @author nic
 * @date: 2018年8月13日 下午6:17:23
 */
public class A4_MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        int i=0, j=0; 
        int [] nums3 = new int[len1 + len2];
        
        while (i+j <= (len1+len2)/2) {
            if (i == len1) {nums3[i+j] = nums2[j]; j++; continue;}
            
            if (j == len2) {nums3[i+j] = nums1[i]; i++; continue;}
            
            if (nums1[i] < nums2[j]) {
                nums3[i+j] = nums1[i]; i++;
            } else {
                nums3[i+j] = nums2[j]; j++;
            }
        }
        
        if ((len1+len2)%2 == 0) {
            return ((double)nums3[(len1+len2)/2-1] + (double)nums3[(len1+len2)/2])/2;
        } else {
            return (double)nums3[(len1+len2)/2];
        }
    }
    
    public static void main(String[] args) {
		int [] arr1 = new int [] {1, 3};
		int [] arr2 = new int [] {2};
		System.out.println(findMedianSortedArrays(arr1, arr2));
	}
}
