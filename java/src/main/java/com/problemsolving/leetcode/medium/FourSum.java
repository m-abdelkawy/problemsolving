package com.problemsolving.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        int N = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int lo = j + 1;
                int hi = N - 1;
                while (lo < hi) {
                    int sum = nums[i] + nums[j] + nums[lo] + nums[hi];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        // to avoid duplicates
                        while (lo < hi && nums[lo + 1] == nums[lo])
                            lo++;
                        while (lo < hi && nums[hi - 1] == nums[hi])
                            hi--;
                        lo++;
                        hi--;
                    } else if (sum > target) {
                        hi--;
                    } else if (sum < target) {
                        lo++;
                    }
                }
                while (j + 1 < N && nums[j + 1] == nums[j])
                    j++;
            }
            while (i + 1 < N && nums[i + 1] == nums[i])
                i++;
        }
        return quadruplets;
    }
}
