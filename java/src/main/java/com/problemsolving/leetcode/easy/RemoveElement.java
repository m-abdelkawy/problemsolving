package com.problemsolving.leetcode.easy;

/**
 * 27. Remove Element
 * Link: https://leetcode.com/problems/remove-element
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 25.05.2023
 */
public class RemoveElement {
    public int removeElement1(int[] nums, int val) {
        int count = nums.length;
        int i = 0;
        while(i < nums.length){
            if(nums[i] == val){
                nums[i] = -1;
                swap(nums, i, count -1);
                count--;
            }else if(nums[i] == -1){
                break;
            }
            else{
                i++;
            }

        }
        return count;
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public int removeElement3(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while(i < n){
            if(nums[i] == val){
                nums[i] = nums[n - 1];
                n--;
            }else{
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        RemoveElement rm = new RemoveElement();
        System.out.println(rm.removeElement1(nums, 3));
    }
}
