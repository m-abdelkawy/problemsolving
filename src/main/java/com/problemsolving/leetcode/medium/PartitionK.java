package com.problemsolving.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 698. Partition to K Equal Sum Subsets
 * Link: https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
 *
 * *revisit
 */
public class PartitionK {
    private static boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();

        if (sum % k != 0 || n < k) {
            return false;
        }

        int row = n + 1;
        int col = sum / k + 1;

        boolean[][] partition = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            partition[i][0] = true;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                partition[i][j] = partition[i - 1][j];
                if (j >= nums[i - 1]) {
                    partition[i][j] = partition[i][j] || partition[i - 1][j - nums[i - 1]];
                }
            }
        }

        return partition[row - 1][col - 1];
    }

    private static boolean canPartitionKSubsets2(int[] nums, int k) {
        if(k == 1)
            return true;

        int n = nums.length;
        int sum = Arrays.stream(nums).sum();

        // target sum of each subset
        int target = sum/k;

        int[] dp = new int[1<<16];
        for (int i = 0; i < (1<<n); i++) {
            dp[i] = -1;
        }

        dp[0] = 0;

        for (int mask = 0; mask < (1<<n); mask++) {
            if(dp[mask] == -1)
                continue;

            for (int i = 0; i < n; i++) {
                if(((mask & (1<<i)) == 0) && (dp[mask] + nums[i] <= target)){
                    dp[mask | (1<<i)] = (dp[mask] + nums[i]) % target;
                }
            }
        }

        if(dp[(1<<n) - 1] == 0){
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
//        int[] nums = {2,2,2,2,3,4,5};
        int[] nums = {3522,181,521,515,304,123,2512,312,922,407,146,1932,4037,2646,3871,269};
        System.out.println(canPartitionKSubsets2(nums, 5));

    }
}
