package com.problemsolving.leetcode.easy;

/**
 * 724. Find Pivot Index
 * Link: https://leetcode.com/problems/find-pivot-index/
 *
 * @author m-abdelkawy
 * @version 1.0.0
 * @since 03.07.2022
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int sumLeft = 0, sumRight = 0, sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        sumRight = sum-nums[0];

        int i = 0;
        for (; i < n-1; i++) {
            if(sumLeft == sumRight){
                return i;
            }
            sumLeft +=nums[i];
            sumRight-=nums[i+1];
        }
        return sumLeft == sumRight?i:-1;
    }

    public int pivotIndex2(int[] nums) {
        int leftSum = 0, rightSum = 0, sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum+=nums[i];
        }

        int pivot = 0;
        rightSum = sum - nums[pivot];
        while(pivot < nums.length-1){
            if(leftSum == rightSum){
                return pivot;
            }
            leftSum += nums[pivot++];
            rightSum -= nums[pivot];
        }
        return leftSum == rightSum? pivot : -1;
    }

    public int pivotIndex3(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }

        int sumLeft = 0;
        for(int i = 0; i < nums.length; i++){
            if(sumLeft == (sum - nums[i])/2 && (sum - nums[i])%2 == 0){
                return i;
            }
            sumLeft+=nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        //int[] nums = {1,7,3,6,5,6};
        int[] nums = {-1,-1,0,1,1,0};
        //int[] nums = {1,2,3};
        FindPivotIndex fpi = new FindPivotIndex();
        System.out.println(fpi.pivotIndex(nums));
    }
}
