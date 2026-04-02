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
     * "Time Limit Exceeded"
     * <p>
     * Time complexity: O(n^3), outer, inner loops and the loop in the isRepeated method
     * Space complexity: O(n) as hashset holds at most n elements
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
        int left = 0, right = 0, n = s.length();
        int maxLength = 0;

        Map<Character, Integer> map = new HashMap<>();

        while (right < n) {
            char r = s.charAt(right);
            map.put(r, map.getOrDefault(r, 0) + 1);
            int frequency = map.get(r);
            while (frequency > 1) {
                char l = s.charAt(left);
                map.put(l, map.get(l) - 1);
                left++;
                frequency = map.get(r);
            }

            right++;
            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;
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
            if (frequencyMap.containsKey(c)) {
                left = Math.max(left, frequencyMap.get(c) + 1);
            }
            maxLen = Math.max(maxLen, right - left + 1);
            frequencyMap.put(c, right);
        }

        return maxLen;
    }

    /**
     * Sliding window using hashset
     * <p>
     * Time complexity: O(n) — left and right each traverse at most n steps total
     * Space complexity: O(n), the hashset holds n elements at max
     *
     * @param s input string
     * @return length of longest substring without repeated characters
     */
    public int lengthOfLongestSubstring5(String s) {
        int left = 0, right = 0, maxLen = 0;
        int N = s.length();
        Set<Character> seen = new HashSet<>();
        while(right < N){
            if(!seen.add(s.charAt(right))){
                maxLen = Math.max(maxLen, right - left);
                seen.remove(s.charAt(left));
                left++;
                continue;
            }
            right++;
        }
        return Math.max(maxLen, right - left);
    }

    /**
     * Sliding window using hashset
     * <p>
     * Time complexity: O(n) one loop, each element is traversed once
     * Space complexity: O(n), the hashset holds n elements at max
     *
     * @param s input string
     * @return length of longest substring without repeated characters
     */
    public int lengthOfLongestSubstring6(String s) {
        int maxLength = 0, N = s.length();
        int left = 0, right = 0;
        Set<Character> seen = new HashSet<>();
        while (right < N) {
            while(seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left++));
            }
            seen.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";

        LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(ls.lengthOfLongestSubstring2(s));

        System.out.println(ls.lengthOfLongestSubstring4("abba"));
    }
}
