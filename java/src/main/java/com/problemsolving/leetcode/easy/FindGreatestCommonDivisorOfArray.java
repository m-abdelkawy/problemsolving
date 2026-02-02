package com.problemsolving.leetcode.easy;

public class FindGreatestCommonDivisorOfArray {
    public int findGCD(int[] nums){
        int[] maxMin = findMinMax(nums);
        return compute_gcd(maxMin[0], maxMin[1]);
    }

    private int[] findMinMax(int[] nums){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums){
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        int[] res = new int[2];
        res[0] = max;
        res[1] = min;
        return res;
    }

    private int compute_gcd(int a, int b){
        if(b == 0) return a;
        return compute_gcd(b, a % b);
    }

    public static void main(String[] args) {

    }
}