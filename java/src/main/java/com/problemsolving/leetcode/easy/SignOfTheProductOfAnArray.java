package com.problemsolving.leetcode.easy;


/**
 * 1822. Sign of the Product of an Array
 * Link: https://leetcode.com/problems/sign-of-the-product-of-an-array
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 08.05.2023
 */
public class SignOfTheProductOfAnArray {
    public static int arraySign1(int[] nums) {
        int product = 1;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0){
                product *= 1;
            }else if(nums[i] < 0){
                product *= -1;
            }else{
                product = 0;
            }
        }

        int res = 0;
        if (product > 0) {
            res = 1;
        } else if (product < 0) {
            res = -1;
        }
        return res;
    }

    public static int arraySign2(int[] nums) {
        int countNegativeNumbers = 0;
        for(int num: nums){
            if(num == 0){
                return 0;
            }else if(num < 0){
                countNegativeNumbers++;
            }
        }
        return countNegativeNumbers % 2 == 0 ? 1 : -1;
    }

    public static void main(String[] args) {
        int[] nums = {41,65,14,80,20,10,55,58,24,56,28,86,96,10,3,84,4,41,13,32,42,43,83,78,82,70,15,-41};
        System.out.println(arraySign1(nums));
    }
}
