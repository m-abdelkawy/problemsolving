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
            sum += currentValue;
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

class RomanToInteger2{
    static Map<String, Integer> map = new HashMap<>();
    static{
        map.put("M", 1000);
        map.put("D", 500);
        map.put("C", 100);
        map.put("L", 50);
        map.put("X", 10);
        map.put("V", 5);
        map.put("I", 1);

        map.put("CM", 900);
        map.put("CD", 400);
        map.put("XC", 90);
        map.put("XL", 40);
        map.put("IX", 9);
        map.put("IV", 4);
    }

    public int romanToInt(String s){
        int sum = 0;
        int i = 0;
        int len = s.length();
        while(i < len){
            String strValue1 = s.substring(i, i + 1);
            int value1 = map.get(strValue1);
            int value2 = 0;
            if(i + 1 < len){
                String strValue2 = s.substring(i, i + 2);
                value2 = map.getOrDefault(strValue2, -1);
                if(value2 != -1){
                    sum += value2;
                    i += 2;
                    continue;
                }
            }
            sum += value1;
            i++;
        }
        return sum;
    }

    public static void main(String[] args){
        String s = "MCMXCIV";
        RomanToInteger2 r = new RomanToInteger2();
        System.out.println(r.romanToInt(s));
    }
}

class RomanToInteger3{
    static Map<String, Integer> map = new HashMap<>();
    static{
        map.put("M", 1000);
        map.put("D", 500);
        map.put("C", 100);
        map.put("L", 50);
        map.put("X", 10);
        map.put("V", 5);
        map.put("I", 1);
    }

    public int romanToInt(String s){
        int sum = 0;
        int i = s.length() - 1;
        int previous = 0;
        while (i >= 0){
            String current = s.substring(i, i + 1);
            int currentValue = map.get(current);
            if(currentValue < previous){
                sum -= currentValue;
            }else{
                sum += currentValue;
            }
            previous = currentValue;
            i--;
        }
        return sum;
    }

    public static void main(String[] args){
        String s = "MCMXCIV";
        RomanToInteger3 r = new RomanToInteger3();
        System.out.println(r.romanToInt(s));
    }
}