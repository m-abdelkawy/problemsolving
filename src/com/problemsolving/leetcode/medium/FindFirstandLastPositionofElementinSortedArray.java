package com.problemsolving.leetcode.medium;


/**
 * 34. Find First and Last Position of Element in Sorted Array
 * Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 27.02.2023
 */
public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange1(int[] nums, int target) {
        int[] res = {-1, -1};

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                res[0] = i;
                res[1] = i;
                while(++i < nums.length && nums[i] == target){
                    res[1] = i;
                }
            }
        }

        return res;
    }

    public int[] searchRange2(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);
        return res;
    }

    private int findFirst(int[] nums, int target){
        int index = -1;

        int st = 0, end = nums.length - 1;

        while(st <= end){
            int mid = st + (end - st)/2;
            if(target > nums[mid]){
                st = mid+1;
            }else if(target < nums[mid]){
                end = mid - 1;
            }else{
                index = mid;
                end = mid-1;
            }
        }

        return index;
    }

    private int findLast(int[] nums, int target){
        int index = -1;

        int st = 0, end = nums.length - 1;

        while(st <= end){
            int mid = st + (end - st) / 2;
            if(target < nums[mid]){
                end = mid - 1;
            }else if(target > nums[mid]){
                st = mid + 1;
            }else{
                index = mid;
                st = mid+1;
            }
        }

        return index;
    }
}
