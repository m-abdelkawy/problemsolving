package com.problemsolving.leetcode.easy;

/**
 * 1768. Merge Strings Alternately
 * Link: https://leetcode.com/problems/merge-strings-alternately
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 04.05.2023
 */
public class MergeStringsAlternately {
    public String mergeAlternately1(String word1, String word2) {
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while(i < word1.length() && j < word2.length()){
            sb.append(word1.charAt(i++)).append(word2.charAt(j++));
        }
        while(i < word1.length()){
            sb.append(word1.charAt(i++));
        }
        while(j < word2.length()){
            sb.append(word2.charAt(j++));
        }
        return sb.toString();
    }

    public String mergeAlternately2(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while(i < m || j < n){
            if(i < m){
                sb.append(word1.charAt(i++));
            }
            if(j < n){
                sb.append(word2.charAt(j++));
            }
        }
        return sb.toString();
    }

    public String mergeAlternately3(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int max = Math.max(m, n);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < max; i++){
            if(i < m){
                sb.append(word1.charAt(i));
            }
            if(i < n){
                sb.append(word2.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
