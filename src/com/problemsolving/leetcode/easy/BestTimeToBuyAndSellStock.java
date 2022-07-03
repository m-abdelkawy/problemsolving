package com.problemsolving.leetcode.easy;

/**
 * 121. Best Time to Buy and Sell Stock
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 26.06.2022
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                profit = Math.max(profit, prices[j] - prices[i]);
            }
        }

        return profit;
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int profit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);

            profit = Math.max(profit, prices[i]-minPrice);
        }


        return profit;
    }

    public int maxProfit3(int[] prices) {
        int n = prices.length;
        int profit = 0;
        int minSoFar = Integer.MAX_VALUE;
        int profitIfSoldToday=0;

        for (int i = 0; i < n; i++) {
            if(prices[i] < minSoFar){
                minSoFar = prices[i];
            }
            profitIfSoldToday = prices[i] - minSoFar;
            if(profitIfSoldToday > profit){
                profit = profitIfSoldToday;
            }
        }


        return profit;
    }

    public static void main(String[] args) {

    }
}
