package com.problemsolving.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 217. Contains Duplicate
 * Link: https://leetcode.com/problems/contains-duplicate/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 23.06.2022
 */
public class ContainsDuplicate {
    /**
     * Solution 1: use set data structure since they do not allow duplicates
     * @param nums array of integer
     * @return true if nums contains duplicates, false otherwise
     */
    public boolean containsDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        return nums.length != set.size();
    }

    public boolean containsDuplicate3(int[] nums){
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate cd = new ContainsDuplicate();

        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Expected: true" + " --- actual:" + cd.containsDuplicate2(nums1));
        System.out.println();

        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Expected: false" + " --- actual:" + cd.containsDuplicate2(nums2));
        System.out.println();

        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println("Expected: true" + " --- actual:" + cd.containsDuplicate2(nums3));
        System.out.println();
    }
}
