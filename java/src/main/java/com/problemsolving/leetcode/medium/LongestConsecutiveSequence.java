package com.problemsolving.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 * Link: https://leetcode.com/problems/longest-consecutive-sequence
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 03.22.2026
 */
public class LongestConsecutiveSequence {

    /**
     * time O(n^2), space O(n)
     * @param nums
     * @return
     */
    public int longestConsecutive1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int currentCount = 0, longest = 0;
        for (int num : nums) {
            int left = num - 1;
            int right = num + 1;
            currentCount = 1;
            while(set.contains(left)) {
                currentCount++;
                left--;
            }
            while(set.contains(right)){
                currentCount++;
                right++;
            }
            longest = Math.max(longest, currentCount);
        }
        return longest;
    }

    /**
     * Time O(n), space O(n)
     * @param nums
     * @return
     */
    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int currentCount = 0, longest = 0;
        for (int num : set) {
            int right = num + 1;

            currentCount = 1;
            if(!set.contains(num - 1)) { //the current num is the start of the sequence
                while(set.contains(right)){
                    currentCount++;
                    right++;
                }
            }

            longest = Math.max(longest, currentCount);
        }
        return longest;
    }
}
