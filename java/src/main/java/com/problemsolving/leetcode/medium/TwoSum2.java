package com.problemsolving.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 167. Two Sum II - Input Array Is Sorted
 * Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/?envType=study-plan&id=algorithm-i
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 19.12.2022
 */
public class TwoSum2 {
    /**
     * Space Complexity: O(1)
     * Time Complexity: O(N)
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum1(int[] numbers, int target) {
        int[] result = new int[2];
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                break;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }

    /**
     * Space Complexity: O(N)
     * Time Complexity: O(N)
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum2(int[] numbers, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int first = numbers[i];
            int second = target - first;
            if(indexMap.containsKey(second)){
                int index1 = i + 1;
                int index2 = indexMap.get(second) + 1;
                result[0] = Math.min(index1, index2);
                result[1] = Math.max(index1, index2);
                break;
            }
            indexMap.put(first, i);
        }
        
        return result;
    }
}
