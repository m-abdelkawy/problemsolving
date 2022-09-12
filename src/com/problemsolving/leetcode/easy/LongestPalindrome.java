package com.problemsolving.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 409. Longest Palindrome
 * Link: https://leetcode.com/problems/longest-palindrome/
 *
 * @author m-abdelkawy
 * @version 1.0.0
 * @since 07.07.2022
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int n = s.length();
        int len = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int centerElmCount = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            len += entry.getValue();
            if (entry.getValue() % 2 != 0) {
                centerElmCount = 1;
                len -= 1;
            }
        }
        return len + centerElmCount;
    }

    public int longestPalindrome2(String s) {
        // ASCII chars starts with A = 65 and ends with z = 122
        int[] chars = new int[58];

        int len = 0;
        int centerLetter=0;

        int n = s.length();

        for (int i = 0; i < n; i++) {
            chars[s.charAt(i) - 'A']+=1;
        }

        for (int i = 0; i < 58; i++) {
            if(chars[i] != 0 && chars[i]%2==0){
                len+=chars[i];
            }
            else if(chars[i]%2 !=0){
                len-=1;
                centerLetter=1;
            }
        }
        return len+centerLetter;
    }
}
