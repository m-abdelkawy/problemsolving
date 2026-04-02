package com.problemsolving.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 424. Longest Repeating Character Replacement
 * Link: https://leetcode.com/problems/longest-repeating-character-replacement
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 02.04.2026
 */
public class LongestRepeatingCharacterReplacement {
    /**
     *
     * Time complexity: O(n), left and right each move at most n steps
     * Space complexity: O(1),
     * map at most holds 26 characters (alphabet is fixed number, not proportional with input size)
     *
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement1(String s, int k) {
        int left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();
        int N = s.length(), maxFreq = 0;
        int replacementNeeded = 0, maxLen = 0;
        while (right < N) {
            char c = s.charAt(right);
            int freq = map.getOrDefault(c, 0) + 1;
            map.put(c, freq);
            maxFreq = Math.max(maxFreq, freq);
            int windowSize = right - left + 1;
            replacementNeeded = windowSize - maxFreq;
            if (replacementNeeded <= k) {
                maxLen = Math.max(maxLen, windowSize);
            } else {
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }
            right++;
        }
        return maxLen;
    }

    /**
     *
     * Time complexity: O(n), left and right each move at most n steps
     * Space complexity: O(1),
     * array at most holds 26 cells (alphabet is fixed number, not proportional with input size)
     *
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement2(String s, int k) {
        int left = 0, right = 0;
        int[] frequencyArray = new int[26];
        int N = s.length(), maxFreq = 0;
        int replacementNeeded = 0, maxLen = 0;
        while (right < N) {
            char c = s.charAt(right);
            frequencyArray[c - 'A']++;
            maxFreq = Math.max(maxFreq, frequencyArray[c - 'A']);
            int windowSize = right - left + 1;
            replacementNeeded = windowSize - maxFreq;
            if (replacementNeeded <= k) {
                maxLen = Math.max(maxLen, windowSize);
            } else {
                frequencyArray[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return maxLen;
    }

    /**
     *
     * Time complexity: O(n), left and right each move at most n steps
     * Space complexity: O(1),
     * array at most holds 26 cells (alphabet is fixed number, not proportional with input size)
     *
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement3(String s, int k) {
        int left = 0, right = 0;
        int[] frequencyArray = new int[26];
        int N = s.length(), maxFreq = 0, maxLen = 0;
        while (right < N) {
            maxFreq = Math.max(maxFreq, ++frequencyArray[s.charAt(right) - 'A']);
            if (right - left + 1 - maxFreq > k) {
                frequencyArray[s.charAt(left) - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}
