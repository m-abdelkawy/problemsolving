package com.problemsolving.leetcode.easy;

/**
 * 344. Reverse String
 * Link: https://leetcode.com/problems/reverse-string/
 *
 * @author m-abdelkawy
 * @version 1.0.0
 * @since 28.12.2022
 */
public class ReverseString {
    public void reverseString1(char[] s) {
        reverseString1(s, 0, s.length - 1);
    }

    private void reverseString1(char[] s, int left, int right) {
        if (left >= right)
            return;
        swap(s, left++, right--);
        reverseString1(s, left, right);
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    /*-----------------------------*/

    public void reverseString2(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            swap(s, i++, j--);
        }
    }
}
