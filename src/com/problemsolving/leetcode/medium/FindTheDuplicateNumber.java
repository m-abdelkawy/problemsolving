package com.problemsolving.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 287. Find the Duplicate Number
 * Link: https://leetcode.com/problems/find-the-duplicate-number/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 13.12.2022
 */
public class FindTheDuplicateNumber {
    /**
     * Time Complexity: O(nlogn) for the sorting alg
     * Space Complexity: O(logn) as the sort in java uses space logn
     *
     * @param nums array of integers
     * @return the duplicate number in the array
     */
    public int findDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                return nums[i];
        }
        return -1;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param nums array of integers
     * @return the duplicate number in the array
     */
    public int findDuplicate2(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num))
                return num;
        }
        return -1;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param nums array of integers
     * @return the duplicate number in the array
     */
    public int findDuplicate3(int[] nums) {
        int duplicate = -1;

        for (int i = 0; i < nums.length; i++) {
            int current = Math.abs(nums[i]);
            if(nums[current] < 0){
                duplicate = current;
                break;
            }
            nums[current] *= -1;
        }
        
        //restore the original array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        
        return duplicate;
    }

    public static void main(String[] args) {
        FindTheDuplicateNumber fd = new FindTheDuplicateNumber();
        int[] nums = {1, 3,3,2};
        System.out.println(fd.findDuplicate3(nums));
    }
}
