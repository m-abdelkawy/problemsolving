# Problem: 121. Best Time to Buy and Sell Stock
# Level: Easy
# Tags: List
# Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock
# Date Solved: 2026.08.07

class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        low = prices[0]
        profit = 0
        for price in prices:
            low = min(low, price)
            profit = max(profit, price - low)
        return profit