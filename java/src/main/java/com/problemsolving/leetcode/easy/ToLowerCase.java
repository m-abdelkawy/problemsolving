package com.problemsolving.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 709. To Lower Case
 * Link: https://leetcode.com/problems/to-lower-case/description/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 28.02.2024
 */
public class ToLowerCase {
    public String toLowerCase(String s) {
        Map<Character, Character> map = new HashMap<>();
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < 26; i++){
            map.put(upper.charAt(i), lower.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (char c: s.toCharArray()){
            sb.append(map.containsKey(c) ? map.get(c) : c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ToLowerCase tlc = new ToLowerCase();
        String input = "HelloWorld";
        String output = "helloworld";
        System.out.println(tlc.toLowerCase(input).equals(output));
    }
}
