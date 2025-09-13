package com.problemsolving.leetcode.easy;

import java.util.Arrays;

/**
 * 383. Ransom Note
 * Link: https://leetcode.com/problems/ransom-note/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 29.06.2022
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] chars1 = ransomNote.toCharArray();
        char[] chars2 = magazine.toCharArray();

        int len1 = chars1.length;
        int len2 = chars2.length;

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        int count = 0;
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            if (chars1[i] == chars2[j]) {
                count++;
                i++;
                j++;
            } else if (chars1[i] > chars2[j]) {
                j++;
            } else {
                break;
            }
        }
        return count == len1;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] count = new int[26];
        int len1 = ransomNote.length();
        int len2 = magazine.length();
        for (int i = 0; i < len2; i++) {
            count[magazine.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < len1; i++) {
            count[ransomNote.charAt(i) - 'a'] -= 1;
            if (count[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RansomNote rn = new RansomNote();
        String ransomNote1 = "a";
        String magazine1 = "b";
        System.out.println(rn.canConstruct2(ransomNote1, magazine1));
        System.out.println();
        String ransomNote2 = "aa";
        String magazine2 = "ab";
        System.out.println(rn.canConstruct2(ransomNote2, magazine2));
        System.out.println();
        String ransomNote3 = "aa";
        String magazine3 = "aab";
        System.out.println(rn.canConstruct2(ransomNote3, magazine3));
    }
}
