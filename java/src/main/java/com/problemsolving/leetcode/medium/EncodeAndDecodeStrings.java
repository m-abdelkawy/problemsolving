package com.problemsolving.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 271. Encode and Decode Strings
 * Link: https://leetcode.com/problems/encode-and-decode-strings
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 03.19.2025
 */
public class EncodeAndDecodeStrings {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = s.indexOf("#", i);
            int len = Integer.parseInt(s.substring(i, j));
            String word = s.substring(j + 1, j + 1 + len);
            result.add(word);
            i = j + len + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> list = List.of("Hello", "World");
        EncodeAndDecodeStrings codec = new EncodeAndDecodeStrings();

        // Test 1 — basic
        List<String> input1 = List.of("hello", "world");
        assert codec.decode(codec.encode(input1)).equals(input1) : "Test 1 failed";

        // Test 2 — delimiter inside string
        List<String> input2 = List.of("hello#world", "foo");
        assert codec.decode(codec.encode(input2)).equals(input2) : "Test 2 failed";

        // Test 3 — length >= 10
        List<String> input3 = List.of("helloworldx", "foo");
        assert codec.decode(codec.encode(input3)).equals(input3) : "Test 3 failed";

        // Test 4 — empty string in list
        List<String> input4 = List.of("", "foo", "");
        assert codec.decode(codec.encode(input4)).equals(input4) : "Test 4 failed";

        // Test 5 — single empty list
        List<String> input5 = List.of();
        assert codec.decode(codec.encode(input5)).equals(input5) : "Test 5 failed";

        System.out.println("All tests passed!");
    }
}
