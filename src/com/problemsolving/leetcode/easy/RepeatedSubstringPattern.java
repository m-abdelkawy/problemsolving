package com.problemsolving.leetcode.easy;

/**
 * 459. Repeated Substring Pattern
 * Link: https://leetcode.com/problems/repeated-substring-pattern
 *
 * @author m-abdelkawy
 * @version 1.0.0
 * @since 06.05.2023
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for(int i = len/2; i >= 1; i--){
            if(len % i == 0){
                int reps = len/i;
                String sub = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < reps; j++) {
                    sb.append(sub);
                }
                if(sb.toString().equals(s)){
                    return true;
                }
            }
        }
        return false;
    }
}
