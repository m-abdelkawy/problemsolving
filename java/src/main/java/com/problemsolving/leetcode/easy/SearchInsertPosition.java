package com.problemsolving.leetcode.easy;

/**
 * 35. Search Insert Position
 * Link: https://leetcode.com/problems/search-insert-position/?envType=study-plan&id=algorithm-i
 *
 * @author m-abdelkawy
 * @version 1.0.0
 * @since 10.12.2022
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        return binarySearchRecursive(nums, target, lo, hi);
    }

    private int binarySearchRecursive(int[] nums, int target, int lo, int hi) {
        if(lo > hi)
            return lo + 1;

        int mid = lo + (hi - lo) / 2;
        if(nums[mid] == target)
            return mid;
        else if(nums[mid] < target)
            return binarySearchRecursive(nums, target, lo, mid - 1);
        else
            return binarySearchRecursive(nums, target, mid + 1, hi);
    }

    private int binarySearchIterative(int[] nums, int target, int lo, int hi){
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(target == nums[mid])
                return mid;
            else if(target < nums[mid])
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return lo;
    }
}
