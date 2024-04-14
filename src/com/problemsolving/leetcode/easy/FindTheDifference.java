package com.problemsolving.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 389. Find the Difference
 * Link: https://leetcode.com/problems/find-the-difference
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 04.05.2023
 */
public class FindTheDifference {
    public char findTheDifference1(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        for (int i = 0; i < chars1.length; i++) {
            if(chars2[i] != chars1[i]){
                return chars2[i];
            }
        }

        return chars2[chars2.length - 1];
    }

    public char findTheDifference2(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
        }
        char res = 0;
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            if(entry.getValue() > 0){
                res = entry.getKey().charValue();
                break;
            }
        }
        return res;
    }

    public char findTheDifference3(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        char res = '\0';
        for (int i = 0; i < t.length(); i++) {
            int count = map.getOrDefault(t.charAt(i), 0);
            if(count == 0) {
                res = t.charAt(i);
                break;
            }else{
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            }
        }
        return res;
    }

    public char findTheDifference4(String s, String t) {
        int m = s.length();
        int n = t.length();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < m; i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }
        map.put(t.charAt(n - 1), map.getOrDefault(t.charAt(n - 1), 0) - 1);
        char diff = '\0';
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue() != 0){
                diff = entry.getKey();
                break;
            }
        }
        return diff;
    }

    public char findTheDifference5(String s, String t) {
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        char res = '\0';
        for (int i = 0; i < t.length(); i++) {
            if(chars[t.charAt(i) - 'a'] == 0){
                res = t.charAt(i);
                break;
            }else{
                chars[t.charAt(i) - 'a']--;
            }
        }
        return res;
    }

    public char findTheDifference6(String s, String t) {
        char c = '\0';
        for (int i = 0; i < s.length(); i++) {
            c ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            c ^= t.charAt(i);
        }
        return c;
    }

    public char findTheDifference7(String s, String t) {
        char res = '\0';
        for(int i = 0; i < s.length(); i++){
            res ^= s.charAt(i);
            res ^= t.charAt(i);
        }
        res ^= t.charAt(t.length() - 1);

        return res;
    }

    public static void main(String[] args) {

    }
}
