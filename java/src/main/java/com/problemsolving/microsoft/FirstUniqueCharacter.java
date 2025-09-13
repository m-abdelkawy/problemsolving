package com.problemsolving.microsoft;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {
    public static String firstUniqueChar(String s){
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if(s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i)))
                return Character.toString(s.charAt(i));
        }
        return "";
    }

    public String firstUniqChar(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            frequencyMap.put(chars[i], frequencyMap.getOrDefault(chars[i], 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            if(frequencyMap.get(s.charAt(i)) == 1)
                return Character.toString(s.charAt(i));
        }
        return "";
    }
}
