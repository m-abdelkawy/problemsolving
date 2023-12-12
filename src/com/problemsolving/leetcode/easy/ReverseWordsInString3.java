package com.problemsolving.leetcode.easy;

import java.util.Arrays;

/**
 * 557. Reverse Words in a String III
 * Link: https://leetcode.com/problems/reverse-words-in-a-string-iii/
 *
 * @author m-abdelkawy
 * @version 1.0.0
 * @since 28.12.2022
 */
public class ReverseWordsInString3 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        for (String word: words) {
            sb.append(reverseString(word));
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }


    private String reverseString(String str) {
        char[] s = str.toCharArray();
        int i = 0, j = s.length - 1;
        while (i < j) {
            swap(s, i++, j--);
        }
        return new String(s);
    }
}
