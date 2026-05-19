package com.problemsolving.leetcode.medium;

/**
 * 153. Find Minimum in Rotated Sorted Array
 * Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 19.05.2026
 */
public class FindMinimumInRotatedSortedArray {
    /**
     * Time Complexity: O(log n)
     * Space Complextiy: O(1)
     * @param nums
     * @return
     */
    public int findMin1(int[] nums) {
       int n = nums.length;
       int lo = 0, hi = n - 1;
       int mid = -1;
       while(lo <= hi){
           mid = lo + (hi - lo)/2;

           if(nums[mid] > nums[n - 1]){
               lo = mid + 1;
           } else{
               hi = mid - 1;
           }
       }
       return nums[lo];
    }

    public int findMin2(int[] nums) {
        int n = nums.length;
        int lo = 0, hi = n - 1;
        int mid = -1;
        while(lo < hi){
            mid = lo + (hi - lo)/2;

            if(nums[mid] > nums[hi]){
                lo = mid + 1;
            } else{
                hi = mid;
            }
        }
        return nums[lo];
    }
}
