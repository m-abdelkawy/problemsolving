package com.problemsolving.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 283. Move Zeroes
 * Link: https://leetcode.com/problems/move-zeroes/description/?envType=study-plan&id=algorithm-i
 *
 * @author m-abdelkawy
 * @version 1.0.0
 * @since 19.12.2022
 */
public class MoveZeros {

    /**
     * Space Complexity: O(N)
     * Time Complexity: O(N)
     * @param nums
     */
    public void moveZeroes1(int[] nums) {
        int zeroCount = 0;
        List<Integer> nonZeroElm = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)
                zeroCount++;
            else{
                nonZeroElm.add(nums[i]);
            }
        }

        for(int i = 0; i < zeroCount; i++){
            nonZeroElm.add(0);
        }

        for(int i = 0; i < nums.length; i++){
            nums[i] = nonZeroElm.get(i);
        }
    }

    /**
     * Space Complexity: O(1)
     * Time Complexity: O(N)
     * total operations: N array writes
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        int lastNonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[lastNonZeroIndex++] = nums[i];
            }
        }

        for (int i = lastNonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * Space Complexity: O(1)
     * Time Complexity: O(N)
     * total operations: N array writes
     * @param nums
     */
    public void moveZeroes3(int[] nums) {
        for(int lastNonZeroIndex = 0, current = 0; current < nums.length; current++){
            if(nums[current] != 0){
                swap(nums, lastNonZeroIndex++, current);
            }
        }
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        MoveZeros mz = new MoveZeros();
        System.out.println();
    }
}
