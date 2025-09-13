package com.problemsolving.leetcode.easy;

/**
 * 28. Find the Index of the First Occurrence in a String
 * Link: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 05.05.2023
 */
public class FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr1(String haystack, String needle) {
        int len_needle = needle.length();
        int len_haystack = haystack.length();

        for (int i = 0; i < len_haystack; i++) {
            if(haystack.charAt(i) == needle.charAt(0) && len_haystack - i >= len_needle){
                String sb = haystack.substring(i, i + len_needle);
                if(sb.equals(needle)){
                    return i;
                }
            }
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        int index = -1;

        int len_needle = needle.length();
        int len_haystack = haystack.length();

        for(int i = 0; i < len_haystack; i++){
            if(needle.charAt(0) == haystack.charAt(i) && i + len_needle <= len_haystack){
                boolean equal = true;
                for(int j = 0; j < len_needle; j++){
                    if(needle.charAt(j) != haystack.charAt(j + i)){
                        equal = false;
                        break;
                    }
                }
                if(equal){
                    return i;
                }
            }
        }

        return index;
    }

    public int strStr3(String haystack, String needle) {
        int len_needle = needle.length();
        int len_haystack = haystack.length();

        for (int i = 0; i <= len_haystack - len_needle; i++) {
            if(haystack.charAt(i) == needle.charAt(0)){
                String sb = haystack.substring(i, i + len_needle);
                if(sb.equals(needle)){
                    return i;
                }
            }
        }
        return -1;
    }

    public int strStr4(String haystack, String needle) {
        int len_needle = needle.length();
        int len_haystack = haystack.length();

        for (int i = 0; i <= len_haystack - len_needle; i++) {
            for (int j = 0; j < len_needle; j++) {
                if(haystack.charAt(i+j) != needle.charAt(j)){
                    break;
                }
                if(j == len_needle - 1){
                    return i;
                }
            }
        }
        return -1;
    }

    public int strStr5(String haystack, String needle) {
        int index = -1;
        int m = haystack.length();
        int n = needle.length();

        for(int i = 0; i < m - n + 1; i++){
            if(haystack.charAt(i) == needle.charAt(0) && needle.equals(haystack.substring(i, i + n))){
                index = i;
                break;
            }
        }

        return index;
    }

    public int strStr6(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        for(int i = 0; i < m - n + 1; i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                String str = haystack.substring(i, i + n);
                if(str.equals(needle)){
                    return i;
                }
            }
        }
        return -1;
    }


}
