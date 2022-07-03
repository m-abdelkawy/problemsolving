package com.problemsolving.leetcode.easy;

/**
 * 53. Maximum Subarray
 * Link: https://leetcode.com/problems/maximum-subarray/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 23.06.2022
 */
public class MaximumSubarray {
    /**
     * O(n^2) solution - time limit exceeded
     *
     * @param nums array of integers
     * @return maximum sum of sub array
     */
    public int maxSubArray1(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += nums[j];
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        return maxSum;
    }

    /**
     * O(n) sliding window like solution
     *
     * @param nums array of integers
     * @return maximum sum of sub array
     */
    public int maxSubArray2(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum += nums[i];
            maxSum = Math.max(maxSum, currentSum);
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubarray ms = new MaximumSubarray();
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Expected: 6" + " --- actual: " + ms.maxSubArray2(nums1));
        System.out.println();

        int[] nums2 = {1};
        System.out.println("Expected: 1" + " --- actual: " + ms.maxSubArray2(nums2));
        System.out.println();

        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println("Expected: 23" + " --- actual: " + ms.maxSubArray2(nums3));
        System.out.println();

        int[] nums4 = {-2,-2,-3,0,-3,1,-3};
        System.out.println("Expected: 1" + " --- actual: " + ms.maxSubArray2(nums4));
        System.out.println();
    }
}
