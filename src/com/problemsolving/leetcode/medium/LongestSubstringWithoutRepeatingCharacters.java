package com.problemsolving.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 * Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 02.01.2022
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Brute Force Algorithm
     *
     * @param s input string
     * @return length of longest substring without repeated characters
     */
    public int lengthOfLongestSubstring1(String s) {
        int maxLen = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (!isRepeated(s, i, j)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return maxLen;
    }

    private boolean isRepeated(String s, int start, int end) {
        Set<Character> chars = new HashSet<>();
        for (int i = start; i <= end; i++) {
            if (!chars.add(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sliding window
     *
     * @param s input string
     * @return length of longest substring without repeated characters
     */
    public int lengthOfLongestSubstring2(String s) {
        int maxLen = 0;
        int left = 0, right = 0, n = s.length();
        Map<Character, Integer> frequencyMap = new HashMap<>();

        while (right < n) {
            Character c = s.charAt(right);
            int frequency = frequencyMap.getOrDefault(c, 0);
            frequencyMap.put(c, frequency + 1);

            while (left <= right && frequency > 0) {
                frequencyMap.put(s.charAt(left), frequencyMap.get(s.charAt(left)) - 1);
                frequency = frequencyMap.getOrDefault(c, 0);
                left++;
                if (s.charAt(left - 1) == c)
                    break;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }

    /**
     * Sliding window
     *
     * @param s input string
     * @return length of longest substring without repeated characters
     */
    public int lengthOfLongestSubstring3(String s) {
        int maxLen = 0;
        int left = 0, right = 0, n = s.length();
        Map<Character, Integer> frequencyMap = new HashMap<>();

        while (right < n) {
            Character c = s.charAt(right);
            int frequency = frequencyMap.getOrDefault(c, 0);
            frequencyMap.put(c, frequency + 1);

           while(frequencyMap.get(c) > 1){
               char l = s.charAt(left);
               frequencyMap.put(l, frequencyMap.get(l) - 1);
               left++;
           }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }

    /**
     * Sliding window optimized
     *
     * @param s input string
     * @return length of longest substring without repeated characters
     */
    public int lengthOfLongestSubstring4(String s) {
        int maxLen = 0, n = s.length();
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (int left = 0, right = 0; right < n; right++) {
            Character c = s.charAt(right);
            if(frequencyMap.containsKey(c)){
                left = Math.max(left, frequencyMap.get(c) + 1);
            }
            maxLen = Math.max(maxLen, right - left + 1);
            frequencyMap.put(c, right);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";

        LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(ls.lengthOfLongestSubstring2(s));
    }
}
