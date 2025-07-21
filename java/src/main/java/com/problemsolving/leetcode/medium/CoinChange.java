package com.problemsolving.leetcode.medium;

import java.util.Arrays;

/**
 * 322. Coin Change
 * Link: https://leetcode.com/problems/coin-change/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 07 Jun 2022
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        // 01. Greedy Approach iterative (fails)
        // return coinChangeIterative(coins, amount);

        // 02. dynamic programming approach
        return dbChange(coins, amount);
    }

    /**
     * Greedy approach fails!
     * @param coins array of coins available
     * @param amount the sum of money
     * @return minimum number of coins in the amount if possible, otherwise -1
     */
    private int coinChangeIterative(int[] coins, int amount) {
        int count = 0;
        int maxIndex = coins.length - 1;
        while (amount > 0 && maxIndex >= 0) {
            count += amount / coins[maxIndex];
            amount = amount % coins[maxIndex];
            if (amount == 0)
                break;
            if (maxIndex == 0)
                return -1;
            while (amount > 0 && amount < coins[--maxIndex]) {
                if (maxIndex == 0)
                    return -1;
            }
        }
        return count;
    }

    private int dbChange(int[] coins, int amount) {
        int[] minNumCoins = new int[amount + 1];
        minNumCoins[0] = 0;
        for (int m = 1; m <= amount; m++) {
            minNumCoins[m] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (m >= coins[j]) {
                    if(minNumCoins[m - coins[j]] == Integer.MAX_VALUE)
                        continue;
                    minNumCoins[m] = Math.min(minNumCoins[m], minNumCoins[m - coins[j]] + 1);
                }
            }
        }
        return minNumCoins[amount] == Integer.MAX_VALUE? -1: minNumCoins[amount];
    }

    public static void main(String[] args) {
//        int[] coins = {186, 419, 83, 408};
//        int amount = 6249;

        int[] coins = {1, 2, 5};
        int amount = 11;

        CoinChange c = new CoinChange();

        System.out.println(c.coinChange(coins, amount));
    }
}
