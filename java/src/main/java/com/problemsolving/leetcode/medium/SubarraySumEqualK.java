package com.problemsolving.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. Subarray Sum Equals K
 * Link: https://leetcode.com/problems/subarray-sum-equals-k
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 30.05.2023
 */
public class SubarraySumEqualK {

    /***
     * Brute Force
     * Time Limit exceeded
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum1(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                int sum = 0;
                for (int i = start; i < end; i++) {
                    sum += nums[i];
                }
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        for (int i = 0; i < sum.length; i++) {
            for (int j = i+1; j < sum.length; j++) {
                int diff = sum[j] - sum[i];
                if(diff == k){
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySum3(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(sum == k){
                    count++;
                }
            }
        }

        return count;
    }

    public int subarraySum4(int[] nums, int k) {
        int count = 0, sum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum - k)){
                count+= map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int k = 3;
        SubarraySumEqualK sub = new SubarraySumEqualK();
        System.out.println(sub.subarraySum1(nums, k));
    }
}
