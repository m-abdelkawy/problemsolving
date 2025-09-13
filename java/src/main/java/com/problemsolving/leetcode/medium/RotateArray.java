package com.problemsolving.leetcode.medium;

/**
 * 189. Rotate Array
 * Link: https://leetcode.com/problems/rotate-array/?envType=study-plan&id=algorithm-i
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 10.12.2022
 */
public class RotateArray {
    // time limit exceeded
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        for(int i = 0; i < k; i++){
            int numToHold = nums[n - 1];
            for(int j = n - 1; j > 0; j--){
                nums[j] = nums[j-1];
            }
            nums[0] = numToHold;
        }
    }

    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n) for the auxiliary array
     * @param nums input array
     * @param k number of rotation steps
     */
    public void rotate3(int[] nums, int k) {
        int n = nums.length;
        int[] aux = new int[n];
        k %= n;
        for (int i = 0; i < n; i++) {
            aux[(i + k) % n] = nums[i];
        }
        for(int i = 0; i < n; i++){
            nums[i] = aux[i];
        }
    }

    public void rotate4(int[] nums, int k) {
        int n = nums.length;
        int[] aux = new int[n];
        k %= n;
        for (int i = 0; i < n; i++) {
            aux[(i + k) % n] = nums[i];
        }
        for(int i = 0; i < n; i++){
            nums[i] = aux[i];
        }
    }
}
