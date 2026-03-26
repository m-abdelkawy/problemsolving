package com.problemsolving.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 15. 3Sum
 * Link: https://leetcode.com/problems/3sum/
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 31.05.2022
 */
public class ThreeSum {
    /**
     * Space Complexity: O(1) -> no extra DS, ignoring output list
     * Time Complexity: O(n^2) -> O(n log n) for soring + O(n^2) for outer loop plus 2 pointers
     * @param numbers
     * @param target
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
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

    /**
     * Space Complexity: O(1) -> no extra DS, ignoring output list
     * Time Complexity: O(n^2) -> O(n log n) for soring + O(n^2) for outer loop plus 2 pointers
     * @param numbers
     * @param target
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
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
        }
        return triplets;
    }

    /**
     * Hashset approach
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSumHashSet1(nums, i, triplets);
            }
        }
        return triplets;
    }

    private void twoSumHashSet1(int[] nums, int firstIndex, List<List<Integer>> lst) {
        Set<Integer> seen = new HashSet<>();
        for (int i = firstIndex + 1; i < nums.length; i++) {
            int complement = -nums[firstIndex] - nums[i];
            if(seen.contains(complement)){
                lst.add(List.of(nums[firstIndex], nums[i], complement));
                while (i + 1 < nums.length && nums[i+1] == nums[i]){
                    i++;
                }
            }
            seen.add(nums[i]);
        }
    }

    /*-----------*/

    /**
     * Space Complexity: O(n) -> for introducing the seen hashset, that is created every outer iteration and holding n numbers at maximum [excluding the output list]
     * Time Complexity: O(n^2) -> for the outer loop x the inner hash scan
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum4(int[] nums) {
        int N = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            twoSumHashSet2(nums, i, res);
        }
        return res;
    }

    private void twoSumHashSet2(int[] nums, int firstIndex, List<List<Integer>> lst){
        int N = nums.length;
        Set<Integer> seen = new HashSet<>();
        for (int i = firstIndex + 1; i < N; i++) {
            int first = nums[firstIndex];
            int complement = 0-first-nums[i];
            if(seen.contains(complement)){
                lst.add(Arrays.asList(first, nums[i], complement));
                while(i + 1 < N && nums[i+1] == nums[i]){
                    i++;
                }
            }
            seen.add(nums[i]);
        }
    }

    public static void main(String[] args) {
        int[] nums = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        //int[] nums = {-1,0,1,2,-1,-4};
        // -4, -1, -1, -1, 0, 1, 2
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> triplets = threeSum.threeSum1(nums);
        for (List<Integer> triplet : triplets) {
            String tripletAsString = triplet.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));
            System.out.println(tripletAsString);
        }
    }
}
