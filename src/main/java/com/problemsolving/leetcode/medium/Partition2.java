package com.problemsolving.leetcode.medium;

import java.util.Arrays;

/**
 * 416. Partition Equal Subset Sum
 * Link: https://leetcode.com/problems/partition-equal-subset-sum/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 16.06.2022
 */
public class Partition2 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();

        if (sum % 2 != 0 || n < 2) {
            return false;
        }

        int row = n + 1;
        int col = sum / 2 + 1;

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
}
