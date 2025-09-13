package com.problemsolving.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class TwoSum {
    /**
     * O(n^2) brute force solution
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] res = new int[2];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return null;
    }

    /**
     * O(nlogn) solution using sorted array
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        int[] sortedNums = new int[nums.length];
        System.arraycopy(nums, 0, sortedNums, 0, nums.length);
        Arrays.sort(sortedNums);

        int[] res = new int[2];
        int i = 0, j = nums.length-1;
        int sum = 0;
        while(i < j){
            sum = sortedNums[i] + sortedNums[j];
            if(sum == target){
                break;
            }
            else if(sum > target){
                j--;
            }
            else if (sum < target){
                i++;
            }
        }

        int first = sortedNums[i];
        int second = sortedNums[j];

        res[0] = findIndex(nums, 0, nums.length, first);
        res[1] = Math.max(findIndex(nums, 0, res[0], second),
                findIndex(nums, res[0] + 1, nums.length, second));

        return res;
    }

    private int findIndex(int[] a, int start, int end, int value){
        for (int i = start; i < end; i++) {
            if(a[i] == value)
                return i;
        }
        return -1;
    }

    /**
     * Linear time solution using hashMap
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        int[] res = new int[2];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int first = nums[i];
            int second = target - first;
            if(indexMap.containsKey(second)){
                res[0] = i;
                res[1] = indexMap.get(second);
                break;
            }
            indexMap.put(first, i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,-4,-5};
        TwoSum ts = new TwoSum();
        System.out.println(Arrays.toString(ts.twoSum3(nums, -8)));
    }
}
