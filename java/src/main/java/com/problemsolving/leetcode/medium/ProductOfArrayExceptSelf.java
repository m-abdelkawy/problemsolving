package com.problemsolving.leetcode.medium;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 238. Product of Array Except Self
 * Link: https://leetcode.com/problems/product-of-array-except-self
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 03.19.2025
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf1(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        int left = 1, right = 1;

        for (int i = 0; i < nums.length; i++) {
            prefix[i] = i > 0 ? left * nums[i - 1] : left;
            left = prefix[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            suffix[i] = i < nums.length - 1 ? right * nums[i + 1] : right;
            right = suffix[i];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = prefix[i] * suffix[i];
        }

        return res;
    }

    public int[] productExceptSelf2(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        prefix[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        suffix[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = prefix[i] * suffix[i];
        }

        return res;
    }


    // optimize space, O(1) instead of O(n)
    public int[] productExceptSelf3(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);

        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int suffix = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix = suffix * nums[i+1];
            res[i] *= suffix;
        }

        return res;
    }
}
