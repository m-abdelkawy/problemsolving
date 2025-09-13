package com.problemsolving.leetcode.easy;

/**
 * 1672. Richest Customer Wealth
 * Link: https://leetcode.com/problems/richest-customer-wealth
 *
 * @author m-abdelkawy
 * @version 1.0.0
 * @since 16.05.2023
 */
public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int i = 0; i < accounts.length; i++) {
            int max = 0;
            for (int j = 0; j < accounts[0].length; j++) {
                max += accounts[i][j];
            }
            maxWealth = Math.max(maxWealth, max);
        }
        return maxWealth;
    }
}
