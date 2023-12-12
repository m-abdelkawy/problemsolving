package com.problemsolving.leetcode.easy;

import java.util.Arrays;

/**
 * 242. Valid Anagram
 * Link: https://leetcode.com/problems/valid-anagram/
 * 
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 29.06.2022
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        int len1 = s.length();
        int len2 = t.length();
        if(len1!=len2)
            return false;

        for (int i = 0; i < len1; i++) {
            count[s.charAt(i)-'a']+=1;
            count[t.charAt(i)-'a']-=1;
        }

        for (int i = 0; i < 26; i++) {
            if(count[i] != 0){
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        String s_sorted = new String(chars1);
        String t_sorted = new String (chars2);
        return s_sorted.equals(t_sorted);
    }

    public static void main(String[] args) {

    }
}
