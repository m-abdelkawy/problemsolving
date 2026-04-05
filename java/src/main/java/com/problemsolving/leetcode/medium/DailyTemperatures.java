package com.problemsolving.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 739. Daily Temperatures
 * Link: https://leetcode.com/problems/daily-temperatures
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 05.04.2026
 */
public class DailyTemperatures {
    /**
     * Brute force solution
     * Time complexity: O(n^2)
     * space complexity: O(1) ignoring the result array
     *
     * Time exceeds limit 47 / 48
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures1(int[] temperatures) {
        int N = temperatures.length;
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = i+1; j < N; j++) {
                count++;
                if(temperatures[j]>temperatures[i]) {
                    res[i] = count;
                    break;
                }
            }
        }
        return res;
    }


    /**
     * using Stack
     * Time complexity: O(n) for each index is pushed and popped exactly once at max
     * space complexity: O(n) , stack holds n values at max
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures2(int[] temperatures) {
        int N = temperatures.length;
        int[] res = new int[N];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int currentTemp = temperatures[i];
            while(!stack.isEmpty() && currentTemp > temperatures[stack.peek()]) {
                int previousDay = stack.pop();
                res[previousDay] = i - previousDay;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] temps = {73,74,75,71,69,72,76,73};
        dailyTemperatures.dailyTemperatures2(temps);
    }
}
