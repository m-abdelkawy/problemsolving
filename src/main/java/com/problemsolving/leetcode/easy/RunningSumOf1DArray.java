package com.problemsolving.leetcode.easy;

/**
 * 1480. Running Sum of 1d Array
 * Link: https://leetcode.com/problems/running-sum-of-1d-array/
 *
 * @author m-abdelkawy
 * @version 1.0.0
 * @since 03.07.2022
 */
public class RunningSumOf1DArray {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            res[i] =sum;
        }

        return res;
    }

    public int[] runningSum2(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i-1];
        }
        return nums;
    }
}
