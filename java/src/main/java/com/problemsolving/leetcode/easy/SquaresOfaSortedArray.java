package com.problemsolving.leetcode.easy;

import java.util.Arrays;

/**
 * 977. Squares of a Sorted Array
 * Link: https://leetcode.com/problems/squares-of-a-sorted-array/description/?envType=study-plan&id=algorithm-i
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 10.12.2022
 */
public class SquaresOfaSortedArray {
    public int[] sortedSquares1(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            nums[i] = (int)Math.pow(nums[i], 2);
        }
        Arrays.sort(nums);
        return nums;
    }

    public int[] sortedSquares2(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int[] result = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int num;
            if(Math.abs(nums[left]) < Math.abs(nums[right])){
                num = nums[right];
                right--;
            }
            else{
                num = nums[left];
                left++;
            }
            result[i] = num * num;
        }
        return result;
    }
}
