package com.problemsolving.leetcode.medium;

/**
 * 1143. Longest Common Subsequence
 * Link: https://leetcode.com/problems/longest-common-subsequence/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 10.06.2022
 */
public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length() + 1;
        int n = text2.length() + 1;

        int[][] lcs = new int[m][n];
        for (int i = 0; i < m; i++) {
            lcs[i][0] = 0;
        }
        for (int j = 0; j < n; j++) {
            lcs[0][j] = 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }

        return lcs[m - 1][n - 1];
    }

    public static String longestCommonSubsequence2(String text1, String text2) {
        int m = text1.length() + 1;
        int n = text2.length() + 1;

        int[][] lcs = new int[m][n];
        for (int i = 0; i < m; i++) {
            lcs[i][0] = 0;
        }
        for (int j = 0; j < n; j++) {
            lcs[0][j] = 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }

        int i = m - 1, j = n - 1;
        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) {
            if(lcs[i][j] - lcs[i-1][j-1] == 1){
                sb.append(text1.charAt(i-1));
                i--;
                j--;
            }else if(lcs[i-1][j] < lcs[i][j-1]){
                i--;
            }else{
                j--;
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence2("abcde", "ace"));
        System.out.println(longestCommonSubsequence2("abc", "abc"));
        System.out.println(longestCommonSubsequence2("abc", "def"));
    }
}
