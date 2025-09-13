package com.problemsolving.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element
 * Link: https://leetcode.com/problems/majority-element/?envType=study-plan&id=data-structure-ii
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 12.09.2022
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int majority_element = 0;

        for (int i = 0; i < 32; i++) {
            int bit = 1 << i;

            int count = 0;
            for (int num: nums) {
                if ((num & bit) != 0){
                    count++;
                }
            }
            if(count > n/2){
                majority_element |= bit;
            }
        }
        return majority_element;
    }

    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i] ,map.get(nums[i])+1);
            }else{
                map.put(nums[i], 1);
            }
        }

        int res = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() > nums.length/2){
                res = entry.getKey();
                break;
            }
        }
        return res;
    }

    public int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public static void main(String[] args) {

    }
}
