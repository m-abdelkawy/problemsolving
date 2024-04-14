package com.problemsolving.leetcode.easy;

/**
 * 1150. Check If a Number Is Majority Element in a Sorted Array
 * https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 15.02.2023
 */
public class CheckIfaNumberIsMajorityElementinaSortedArray {
    public boolean isMajorityElement1(int[] nums, int target) {
        int candidate = nums[nums.length/2];
        if(candidate != target)
            return false;
        int count = 0;
        for(int num: nums){
            if(num == target)
                count++;
        }
        return count > nums.length/2;
    }

    public boolean isMajorityElement2(int[] nums, int target) {
        int firstOccurence = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target){
                firstOccurence = i;
                break;
            }
        }
        if(firstOccurence == -1)
            return false;

        if(firstOccurence + nums.length/2 < nums.length && nums[firstOccurence + nums.length/2] == target)
            return true;

        return false;
    }
}
