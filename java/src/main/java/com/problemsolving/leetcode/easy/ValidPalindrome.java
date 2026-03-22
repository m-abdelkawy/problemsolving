package com.problemsolving.leetcode.easy;

/**
 * 125. Valid Palindrome
 * Link: https://leetcode.com/problems/valid-palindrome
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 03.22.2026
 */
public class ValidPalindrome {

    /**
     * Time O(n), Space O(1)
     * @param s the input string
     * @return
     */
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if(!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }

            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama";
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(vp.isPalindrome(input));
    }
}
