package com.problemsolving.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters1(String s) {
        int[] chars = new int[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (chars[c] == 0) {
                chars[c]++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (chars[i] > 0) {
                sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }
    
    public String removeDuplicateLetters2(String s){
        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(set.add(c)){
               sb.append(c);
            }
        }
        return sb.toString();
    }

//    public String removeDuplicateLetters3(String s){
//        char[] chars = s.toCharArray();
//        StringBuilder sb = new StringBuilder();
//        int lastInserted = 1;
//        for (int i = 1; i < chars.length; i++) {
//            if(chars[i] != char)
//        }
//    }

    public static void main(String[] args) {
        String s = "mississippi";
        RemoveDuplicateLetters rd = new RemoveDuplicateLetters();
        System.out.println(rd.removeDuplicateLetters2(s));
    }
}
