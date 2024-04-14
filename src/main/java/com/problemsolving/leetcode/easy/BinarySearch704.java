package com.problemsolving.leetcode.easy;

/**
 * 704. Binary Search
 * https://leetcode.com/problems/binary-search/?envType=study-plan&id=algorithm-i
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 10.12.2022
 */
public class BinarySearch704 {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        return binarySearchRecursive(nums, target, lo, hi);
    }

    private int binarySearchRecursive(int[] nums, int target, int lo, int hi){
        if(lo > hi)
            return -1;

        int mid = (lo + hi) / 2;
        if(target == nums[mid]){
            return mid;
        }
        else if(target > nums[mid]){
            return binarySearchRecursive(nums, target, mid + 1, hi);
        }
        else{
            return binarySearchRecursive(nums, target, lo, mid - 1);
        }
    }

    private int binarySearchIterative(int[] nums, int target, int lo, int hi){
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(target == nums[mid]){
                return mid;
            }
            else if(target > nums[mid]){
                lo = mid + 1;
            }
            else{
                hi = mid - 1;
            }
        }
        return -1;
    }
}
