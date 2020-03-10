/**
 * 
 */
package com.weidai.study.leetcode;

/**
 * @Description: TODO
 * @ClassName: ContainerWithMostWater_11
 * @author nic
 * @date: 2018年8月28日 下午2:29:02
 */
public class A11_ContainerWithMostWater {

	public int maxArea(int[] height) {
        
		int max = 0;
		for(int i=0; i< height.length-1; i++) {
			for (int j = i+1 ; j < height.length; j++) {
				int currAare = (j - i) * Math.min(height[i], height[j]);
				if (currAare > max) max = currAare;
			}
		}
		return max;
    }
	
	public int maxArea2(int[] height) {
        
		int max = 0 ,l =0, r = height.length - 1;
		while (l < r) {
			max = Math.max(max, (r-l) * Math.min(height[l], height[r]));
			if (height[l] < height[r]) {
				l++;
			} else {
				r--;
			}
		}

		return max;
    }
}
