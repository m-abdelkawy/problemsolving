package com.problemsolving.leetcode.medium;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ReverseWordsInString2 {
    public static void reverseWords1(char[] s) {
        String str = new String(s);

        String[] words = str.split("\\s+");

        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]).append(" ");
        }

        char[] arr = sb.toString().trim().toCharArray();
        for (int i = 0; i < s.length; i++) {
            s[i] = arr[i];
        }
    }
    /*----------------------------------------------------------------------------*/

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param s array of characters
     */
    public static void reverseWords2(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            swap(s, i++, j--);
        }

        i = 0;
        for (int k = 0; k < s.length; k++) {
            if (k == s.length - 1 || s[k + 1] == ' ') {
                j = k;
                while (i < j) {
                    swap(s, i++, j--);
                }
                i = k + 2;
            }
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        char[] chars = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};

        System.out.println("Before: " + Arrays.toString(chars));

        reverseWords1(chars);

        System.out.println("After: " + Arrays.toString(chars));
    }
}
