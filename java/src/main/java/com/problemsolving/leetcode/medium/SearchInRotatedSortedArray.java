package com.problemsolving.leetcode.medium;

/**
 * 33. Search in Rotated Sorted Array
 * Link: https://leetcode.com/problems/search-in-rotated-sorted-array
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 13.05.2026
 */
public class SearchInRotatedSortedArray {
    public int search1(int[] nums, int target) {
        // 01. detect the pivot using binary search
        int n = nums.length;
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[n - 1]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        // 2. binary search left and right of the pivot
        int ans = binarySearch(nums, 0, lo - 1, target);
        if (ans != -1) return ans;

        return binarySearch(nums, lo, n - 1, target);
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /*------------------------------------One pass solution-------------------------------------------*/

    /**
     * Time complexity: O(log n)
     * Space Complexity: O(1), no extra data structure is introduced
     *
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (target == nums[mid]) return mid;

            // left partition is sorted
            if (nums[lo] <= nums[mid]) {
                // If target lies within sorted interval, discard right half
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                // Right half is monotonically sorted
                // Target lies within sorted right interval
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5, 1, 3};
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        System.out.println(s.search1(nums, 5));
    }
}
