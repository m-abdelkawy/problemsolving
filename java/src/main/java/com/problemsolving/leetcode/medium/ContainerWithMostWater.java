package com.problemsolving.leetcode.medium;

/**
 * 11. Container With Most Water
 * Link: https://leetcode.com/problems/container-with-most-water
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 26.03.2026
 */
public class ContainerWithMostWater {
    /**
     * Space Complexity: O(1), no DS is introduced
     * Time Complexity: O(n^2), outer and inner loops
     * it did not pass, time limit exceeded in some cases [needs optimization]
     * @param height
     * @return max area of a water container
     */
    public int maxArea1(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }


    /**
     * Space Complexity: O(1), no DS is introduced
     * Time Complexity: O(n), left and right pointers never cross, and they only move inward
     * it did not pass, time limit exceeded in some cases [needs optimization]
     * @param height
     * @return max area of a water container
     */
    public int maxArea2(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while(left < right){
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, area);
            if(height[left] <= height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxArea;
    }
}
