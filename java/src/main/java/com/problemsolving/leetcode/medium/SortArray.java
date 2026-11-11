package com.problemsolving.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

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
     * O(n^2) does not pass leetcode
     * @param nums
     * @return
     */
    public int[] sortArray_selection(int[] nums){
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

    /**
     * O()
     * passed leetcode tests
     * @param nums
     * @return
     */
    public int[] sortArray_merge(int[] nums){
        //base case
        int n = nums.length - 1;
        mergeSort(nums, 0, n);
        return nums;
    }

    private void mergeSort(int[] nums, int start, int end){
        if(start >= end){
            return;
        }

        // divide
        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end){
        List<Integer> lst = new ArrayList<>();
        int left = start;
        int right = mid + 1;

        while(left <= mid && right <= end){
            if(nums[left] <= nums[right]){
                lst.add(nums[left++]);
            } else{
                lst.add(nums[right++]);
            }
        }

        while(left <= mid){
            lst.add(nums[left++]);
        }

        while(right <= end){
            lst.add(nums[right++]);
        }

        int i = start;
        for(Integer x: lst){
            nums[i++] = x;
        }
    }

    public static void main(String[] args) {

    }
}
