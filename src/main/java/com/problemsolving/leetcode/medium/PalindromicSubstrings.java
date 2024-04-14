package com.problemsolving.leetcode.medium;

/**
 * 647. Palindromic Substrings
 * Link: https://leetcode.com/problems/palindromic-substrings/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 30 Jun 2022
 */
public class PalindromicSubstrings {
    int res = 0;

    public int countSubstrings1(String s) {
        for (int i = 0; i < s.length(); i++) {
            count(s, i, i);
            count(s, i, i + 1);
        }
        return res;
    }

    public void count(String s, int st, int end) {
        while (st >= 0 && end < s.length() && s.charAt(st) == s.charAt(end)) {
            res++;
            st--;
            end++;
        }
    }

    public int countSubstrings2(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (isPalindrome(s.substring(i, j))) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
