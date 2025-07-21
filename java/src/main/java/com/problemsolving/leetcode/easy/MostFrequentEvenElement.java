package com.problemsolving.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 2404. Most Frequent Even Element
 * Link: https://leetcode.com/problems/most-frequent-even-element/description/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 15.02.2023
 */
public class MostFrequentEvenElement {
    public static int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int val = -1;
        int valFrequency = 0;
        for (int num: nums){
            if(num % 2 == 0){
                int numFrequency = frequencyMap.getOrDefault(num, 0) + 1;
                frequencyMap.put(num, numFrequency);
                if(numFrequency == valFrequency){
                    valFrequency = numFrequency;
                    val = Math.min(num, val);
                }
                else if(numFrequency > valFrequency){
                    valFrequency = numFrequency;
                    val = num;
                }
            }
        }
        return val;
    }
}
