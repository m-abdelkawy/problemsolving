package com.problemsolving.leetcode.easy;

/**
 * 392. Is Subsequence
 * Link: https://leetcode.com/problems/is-subsequence/
 *
 * @author m-abdelkawy
 * @version 1.0.0
 * @since 05.07.2022
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int len_s = s.length();
        int len_t = t.length();

        boolean isSequence = true;
        int i = 0, j = 0;

        while (i < len_s && j < len_t) {
            char char_s = s.charAt(i);
            char char_t = t.charAt(j);
            if (char_s == char_t) {
                i++;
            }
            j++;
        }

        return i == len_s ? true : false;
    }

    public boolean isSubsequence2(String s, String t) {
        int index = -1;
        int len_s = s.length();
        int len_t = t.length();
        for (int i = 0; i < len_s; i++) {
            index = t.indexOf(s.charAt(i), index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        IsSubsequence is = new IsSubsequence();
        System.out.println(is.isSubsequence(s, t));

        String s2 = "axc";
        String t2 = "ahbgdc";
        System.out.println(is.isSubsequence(s2, t2));
    }
}
