package com.problemsolving.leetcode.easy;

/**
 * 896. Monotonic Array
 * Link: https://leetcode.com/problems/monotonic-array
 *
 * @author m-abdelkawy
 * @version 1.0.0
 * @since 10.05.2023
 */
public class MonotonicArray {
    public boolean isMonotonic1(int[] nums) {
        boolean mono = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] >= nums[i]) {
                continue;
            }
            mono = false;
            break;
        }
        if (mono) {
            return true;
        }
        mono = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] <= nums[i]) {
                continue;
            }
            mono = false;
            break;
        }
        return mono;
    }

    public boolean isMonotonic2(int[] nums) {
        return isDecreasing(nums) || isIncreasing(nums);
    }

    private boolean isDecreasing(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean isIncreasing(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * keeps track of {1, 0, -1}
     * if c keeps equal store or if c does not equal store while store = 0, then it's monotonic
     * if c does not equal store and store is not 0, then one of them is -1 and the other is 1, wich is not monotonic
     * @param nums
     * @return
     */
    public boolean isMonotonic3(int[] nums) {
        int store = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int c = Integer.compare(nums[i], nums[i + 1]);
            if (c != 0) {
                if (c != store && store != 0) {
                    return false;
                }
                store = c;
            }
        }
        return true;
    }

    public static boolean isMonotonic4(int[] nums) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i+1] > nums[i]){
                decreasing = false;
            }else if(nums[i+1] < nums[i]){
                increasing = false;
            }
        }
        return increasing || decreasing;
    }

    public boolean isMonotonic5(int[] nums) {
        if(nums[0] < nums[nums.length - 1]){
            for(int i = 0; i < nums.length - 1; i++){
                if(nums[i] > nums[i+1]){
                    return false;
                }
            }
        }else{
            for(int i = 0; i < nums.length - 1; i++){
                if(nums[i] < nums[i+1]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,2};
        System.out.println(isMonotonic4(arr));
    }
}
