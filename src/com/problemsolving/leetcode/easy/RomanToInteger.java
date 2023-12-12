package com.problemsolving.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer
 * Link: https://leetcode.com/problems/roman-to-integer
 *
 * @author m-abdelkawy
 * @version 1.0.0
 * @since 10.05.2023
 */
public class RomanToInteger {
    static Map<String, Integer> map = new HashMap<>();

    static {
        map.put("M", 1000);
        map.put("D", 500);
        map.put("C", 100);
        map.put("L", 50);
        map.put("X", 10);
        map.put("V", 5);
        map.put("I", 1);
    }

    public int romanToInt(String s) {
        int sum = 0;
        int i = 0;
        while (i < s.length()) {
            String current = s.substring(i, i + 1);
            int currentValue = map.get(current);
            if (i + 1 < s.length()) {
                String next = s.substring(i + 1, i + 2);
                int nextValue = map.get(next);
                if (currentValue < nextValue) {
                    sum += (nextValue - currentValue);
                    i += 2;
                    continue;
                }
            }
            sum += map.get(current);
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        RomanToInteger r = new RomanToInteger();
        System.out.println(r.romanToInt(s));
    }
}
