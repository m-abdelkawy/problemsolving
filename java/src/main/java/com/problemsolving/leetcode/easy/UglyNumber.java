package com.problemsolving.leetcode.easy;

import java.util.*;

/**
 * 264. Ugly Number II
 * Link: https://leetcode.com/problems/ugly-number/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 17.11.2022
 */
public class UglyNumber {
    // time limit exceeded
    public boolean isUgly1(int n) {
        if (n <= 0)
            return false;
        if (n < 2)
            return true;
        List<Integer> lstPrimeFactors = getPrimeFactors(n);
        if (lstPrimeFactors.get(lstPrimeFactors.size() - 1) <= 5) {
            return true;
        }
        return false;
    }

    private List<Integer> getPrimeFactors(int n) {
        List<Integer> lst = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                if (!lst.contains(i))
                    lst.add(i);
                n /= i;
            }
        }
        return lst;
    }

    /**
     * time complexity O(log N)
     * space complexity O(1)
     * @param n number we check
     * @return true if ugly, otherwise false
     */
    public boolean isUgly2(int n) {
        // non positive
        if (n <= 0)
            return false;

        int[] factors = new int[]{2, 3, 5};
        for (int factor: factors) {
            n = keepDividingWhenDivisible(n, factor);
        }

        // check if n reduced to 1
        return n == 1;
    }

    private int keepDividingWhenDivisible(int dividend, int divisor) {
        while (dividend % divisor == 0)
            dividend /= divisor;
        return dividend;
    }



    public static void main(String[] args) {
        int n = 16;
        UglyNumber uglyNumber = new UglyNumber();
        System.out.println(n + " ugly number?" + " -- " + uglyNumber.isUgly1(n));
    }
}
