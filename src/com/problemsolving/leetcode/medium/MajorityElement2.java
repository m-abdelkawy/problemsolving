package com.problemsolving.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 229. Majority Element II
 * Link: https://leetcode.com/problems/majority-element-ii/description/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 14.02.2023
 */
public class MajorityElement2 {
    /**
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * @param nums input array of numbers
     * @return numbers with occurrence more that floor(size / 3)
     */
    public static List<Integer> majorityElement(int[] nums) {
        int floorThird = nums.length/3;
        // 1st pass
        int count1 = 0;
        int count2 = 0;

        Integer candidate1 = null;
        Integer candidate2 = null;

        for (int num : nums) {
            if (candidate1 != null && candidate1 == num) {
                count1++;
            } else if (candidate2 != null && candidate2 == num) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1++;
            }else if(count2 == 0){
                candidate2 = num;
                count2++;
            }else{
                count1--;
                count2--;
            }
        }

        List<Integer> res = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        // 2nd pass
        for(int num: nums){
            if(num == candidate1){
                count1++;
            }else if(num == candidate2){
                count2++;
            }
        }

        if(count1 > floorThird)
            res.add(candidate1);
        if(count2 > floorThird)
            res.add(candidate2);

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,1,1};
        System.out.println(majorityElement(nums));
    }
}
