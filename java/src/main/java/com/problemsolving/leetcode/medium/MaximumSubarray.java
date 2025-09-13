package com.problemsolving.leetcode.medium;

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

    /**
     * O(n) sliding window like solution
     *
     * @param nums array of integers
     * @return maximum sum of sub array
     */
    public int maxSubArray3(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        int i = 0, j = 0;
        while (j < n) {
            curSum += nums[j];
            maxSum = Math.max(curSum, maxSum);
            j++;
            if (curSum < 0) {
                curSum = 0;
                i = j;
            }
        }
        return maxSum;
    }

    /**
     * Dynamic programming solution
     * Kidane's Alg: https://en.wikipedia.org/wiki/Maximum_subarray_problem#Kadane's_algorithm
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums array of integers
     * @return maximum sum of sub array
     */
    public int maxSubArray4(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            currentSum = Math.max(num, num + currentSum);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

    /**
     * Divide and Conquer solution
     * <p>
     * Time Complexity: O(n. logn)
     * Space Complexity: O(logn)
     *
     * @param nums array of integers
     * @return maximum sum of sub array
     */
    public int maxSubArray5(int[] nums) {
        return findBestSubArray(nums, 0, nums.length - 1);
    }

    private int findBestSubArray(int[] nums, int left, int right){
        // base case - empty array
        if(left > right){
            return Integer.MIN_VALUE;
        }

        int mid = Math.floorDiv(left + right, 2);
        int currentSum = 0;
        int bestLeftSum = 0, bestRightSum = 0;

        // left sum
        for(int i = mid - 1; i >= left; i--){
            currentSum += nums[i];
            bestLeftSum = Math.max(currentSum, bestLeftSum);
        }

        currentSum = 0;
        // right sum
        for(int i = mid + 1; i <= right; i++){
            currentSum += nums[i];
            bestRightSum = Math.max(currentSum, bestRightSum);
        }

        int bestSumCombined = bestLeftSum + nums[mid] + bestRightSum;

        int leftSum = findBestSubArray(nums, left, mid - 1);
        int rightSum = findBestSubArray(nums, mid + 1, right);

        return Math.max(bestSumCombined, Math.max(leftSum, rightSum));
    }

    public static void main(String[] args) {
        MaximumSubarray ms = new MaximumSubarray();
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Expected: 6" + " --- actual: " + ms.maxSubArray5(nums1));
        System.out.println();

        int[] nums2 = {1};
        System.out.println("Expected: 1" + " --- actual: " + ms.maxSubArray2(nums2));
        System.out.println();

        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println("Expected: 23" + " --- actual: " + ms.maxSubArray2(nums3));
        System.out.println();

        int[] nums4 = {-2, -2, -3, 0, -3, 1, -3};
        System.out.println("Expected: 1" + " --- actual: " + ms.maxSubArray2(nums4));
        System.out.println();
    }
}
