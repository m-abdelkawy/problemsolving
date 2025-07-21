package com.problemsolving.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. Word Pattern
 * Link: https://leetcode.com/problems/word-pattern
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 28.03.2023
 */
public class WordPattern {
    /**
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern1(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        char[] chars = pattern.toCharArray();
        String[] strs = s.split(" ");

        if (chars.length != strs.length)
            return false;

        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                if (map.get(chars[i]).equals(strs[i])) {
                    continue;
                } else {
                    return false;
                }
            } else {
                if (map.values().contains(strs[i])) {
                    return false;
                }
            }
            map.put(chars[i], strs[i]);
        }
        return true;
    }

    /*------------------------------Two Hash Maps------------------------------*/

    /**
     * Time Complexity: O(N + M)
     * Space Complexity: O(1)
     *
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern2(String pattern, String s) {
        Map<Character, String> map_char = new HashMap<>();
        Map<String, Character> map_word = new HashMap<>();

        char[] chars = pattern.toCharArray();
        String[] words = s.split(" ");

        if (chars.length != words.length)
            return false;

        for (int i = 0; i < words.length; i++) {
            if (!map_char.containsKey(chars[i])) {
                if (map_word.containsKey(words[i])) {
                    return false;
                } else {
                    map_char.put(chars[i], words[i]);
                    map_word.put(words[i], chars[i]);
                }
            } else {
                String mapped_word = map_char.get(chars[i]);
                if (!mapped_word.equals(words[i])) {
                    return false;
                }
            }
        }

        return true;
    }

    /*------------------------------Single Index HashMap------------------------------*/

    /**
     * Time Complexity: O(N + M)
     * Space Complexity: O(1)
     *
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern3(String pattern, String s) {
        Map index_map = new HashMap();

        String[] words = s.split(" ");
        char[] chars = pattern.toCharArray();

        if (chars.length != words.length) {
            return false;
        }

        for (int i = 0; i < words.length; i++) {
            if (!index_map.containsKey(chars[i]))
                index_map.put(chars[i], i);

            if (!index_map.containsKey(words[i]))
                index_map.put(words[i], i);

            if (!index_map.get(chars[i]).equals(index_map.get(words[i])))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String pattern = "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
        String s = "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";

        WordPattern wp = new WordPattern();
        System.out.println(wp.wordPattern3(pattern, s));
    }
}
