package com.problemsolving.leetcode.easy;

import java.util.*;

/**
 * 387. First Unique Character in a String
 * Link: https://leetcode.com/problems/first-unique-character-in-a-string/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 29.06.2022
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            } else {
                map.put(chars[i], 1);
            }
        }

        Character uniqueChar = null;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                uniqueChar = entry.getKey();
                break;
            }
        }

        return uniqueChar == null? -1 : findIndex(chars, uniqueChar.charValue());
    }

    private int findIndex(char[] a, char c){
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if(a[i] == c){
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar1(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            frequencyMap.put(chars[i], frequencyMap.getOrDefault(chars[i], 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            if(frequencyMap.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        int[] letterFrequency = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            letterFrequency[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < n; i++) {
            if(letterFrequency[s.charAt(i)-'a'] == 1){
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar3(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if(s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i)))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacterInAString uc = new FirstUniqueCharacterInAString();
        String s1 = "leetcode";
        System.out.println(uc.firstUniqChar(s1));

        System.out.println();

        String s2 = "loveleetcode";
        System.out.println(uc.firstUniqChar(s2));

        System.out.println();

        String s3 = "aabb";
        System.out.println(uc.firstUniqChar(s3));
    }
}
