package com.problemsolving.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Link: https://leetcode.com/problems/3sum/
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0 - 31.05.2022
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            int j = i + 1;
            int k = N - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    triplets.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j + 1] == nums[j]) {
                        j++;
                    }
                    while (j < k && nums[k - 1] == nums[k]) {
                        k--;
                    }
                    j++;
                    k--;


                } else if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                }
            }
            while (i + 1 < N && nums[i + 1] == nums[i]) {
                i++;
            }
        }
        return triplets;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        //int[] nums = {-1,0,1,2,-1,-4};
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> triplets = threeSum.threeSum(nums);
        for (List<Integer> triplet : triplets) {
            String tripletAsString = triplet.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));
            System.out.println(tripletAsString);
        }
    }
}
