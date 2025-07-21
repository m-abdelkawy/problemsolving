package com.problemsolving.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 316. Remove Duplicate Letters
 * Link: https://leetcode.com/problems/remove-duplicate-letters/description/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 13.12.2022
 */
public class RemoveDuplicateLetters {
    // just removes duplicates, not what is required
    public String removeDuplicateLetters1(String s) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            set.add(chars[i]);
        }

        return set.stream().map(c -> c + "").collect(Collectors.joining(""));
    }

    /**
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * @param s
     * @return
     */
    public String removeDuplicateLetters2(String s) {
        int[] count = new int[26];
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos))
                pos = i;
            if (--count[s.charAt(i) - 'a'] == 0)
                break;
        }
        return s.length() == 0 ? ""
                :
                s.charAt(pos) + removeDuplicateLetters2(s.substring(pos + 1).replaceAll(s.charAt(pos) + "", ""));
    }

    public String removeDuplicateLetters3(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> seen = new HashSet<>();
        Map<Character, Integer> last_occurrence = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            last_occurrence.put(s.charAt(i), i);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!seen.contains(c)){
                while(!stack.isEmpty() && c < stack.peek() && last_occurrence.get(stack.peek()) > i){
                    seen.remove(stack.pop());
                }
                stack.add(c);
                seen.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c: stack) {
            sb.append(c.charValue());
        }
        return sb.toString();
    }

    public String removeDuplicateLetters4(String s) {
        int n = s.length();
        int[] lastIndex = new int[26];
        for (int i = 0; i < n; i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        boolean[] seen = new boolean[26];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if(!seen[c]){
                while(!stack.isEmpty() && c < stack.peek() && lastIndex[stack.peek()] > i){
                    seen[stack.pop()] = false;
                }
                seen[c] = true;
                stack.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Integer i: stack) {
            sb.append((char)(i + 'a'));
        }
        return sb.toString();
    }
}
