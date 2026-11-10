package com.problemsolving.leetcode.medium;

/**
 * 912. Sort an Array
 * Link: https://leetcode.com/problems/sort-an-array
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 10.11.2026
 */
public class SortArray {
    /**
     * selection sort
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums){
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if(nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                int temp = nums[minIndex];
                nums[minIndex] = nums[i];
                nums[i] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {

    }
}
