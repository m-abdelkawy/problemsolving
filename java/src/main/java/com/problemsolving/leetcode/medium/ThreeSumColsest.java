package com.problemsolving.leetcode.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeSumColsest {
    /**
     * returns the closest sum to the target in time O(N^2 * log N)
     * @param nums array of numbers
     * @param target target value
     * @return closest sum to the target
     */
    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int difference = Integer.MAX_VALUE;
        Arrays.sort(nums);

        List<Integer> sortedList = Arrays.stream(nums).boxed().collect(Collectors.toList());

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int index = binarySearchIterative(nums, j + 1, nums.length - 1, target - (nums[i] + nums[j]));
                if (index >= j && index < nums.length) {
                    if (index == j) {
                        if(index + 1 < nums.length && Math.abs(nums[i] + nums[j] + nums[index + 1] - target) <= difference){
                            result = nums[i] + nums[j] + nums[index + 1];
                            difference = Math.abs(result - target);
                        }
                    }
                    else if (index > j) {
                        if(Math.abs(nums[i] + nums[j] + nums[index] -target) <= difference){
                            result = nums[i] + nums[j] + nums[index];
                            difference = Math.abs(result - target);
                        }
                        if (index + 1 < nums.length && Math.abs(nums[i] + nums[j] + nums[index + 1]-target) <= difference) {
                            result = nums[i] + nums[j] + nums[index + 1];
                            difference = Math.abs(result - target);
                        }
                    }

                }
            }
        }
        return result;
    }

    private int binarySearchIterative(int[] arr, int lo, int hi, int key) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (key == arr[mid]) {
                return mid;
            } else if (key < arr[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo - 1;
    }

    /**
     * returns the closest sum to the target in time O(N^2)
     * @param nums array of numbers
     * @param target target value
     * @return closest sum to the target
     */
    public int threeSumClosest2(int[] nums, int target) {
        int minDiff = Integer.MAX_VALUE;
        int result = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(sum - target);
                if (diff == 0)
                    return sum;

                if (diff < minDiff) {
                    minDiff = diff;
                    result = sum;
                }

                if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSumColsest threesum = new ThreeSumColsest();
        int[] arr = {-1, 2, 1, -4};
        System.out.println(threesum.threeSumClosest(arr, 1));
        System.out.println(threesum.threeSumClosest2(arr, 1));
    }
}
