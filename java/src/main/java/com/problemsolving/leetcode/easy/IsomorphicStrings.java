package com.problemsolving.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 205. Isomorphic Strings
 * Link: https://leetcode.com/problems/isomorphic-strings/
 *
 * @author m-abdelkawy
 * @version 1.0.0
 * @since 05.07.2022
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        int n = s.length();
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char char_s = s.charAt(i);
            char char_t = t.charAt(i);

            if (map.containsKey(char_s)) {
                // if the s-char exists but maps to a different character this time
                if(map.get(char_s) != char_t)
                    return false;
            } else if (map.values().contains(char_t)) {
                // if another s-character maps to the current t-character
                return false;
            } else {
                // if it passed the above cases
                // (s-char does not exist as a key and no other s-char maps to the current t-character)
                map.put(char_s, char_t);
            }
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        int[] mappingStoT = new int[256];
        Arrays.fill(mappingStoT, -1);

        int[] mappingTtoS = new int[256];
        Arrays.fill(mappingTtoS, -1);

        int n = s.length();

        for (int i = 0; i < n; i++) {
            char char_s = s.charAt(i);
            char char_t = t.charAt(i);

            if(mappingStoT[char_s] == -1 && mappingTtoS[char_t]==-1){
                mappingStoT[char_s] = char_t;
                mappingTtoS[char_t] = char_s;
            }

            else if(mappingStoT[char_s]!=char_t || mappingTtoS[char_t]!= char_s)
                return false;
        }
        return true;
    }

    public boolean isIsomorphic3(String s, String t) {
        return transformString(s).equals(transformString(t));
    }

    private String transformString(String str){
        Map<Character, Integer> map = new HashMap<>();
        int n = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, i);
            }
            sb.append(map.get(c));
            sb.append("-");
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abcdefghijklmnopqrstuvwxyzva";
        String t = "abcdefghijklmnopqrstuvwxyzck";
        IsomorphicStrings is = new IsomorphicStrings();
        System.out.println(is.isIsomorphic3(s, t));

        String s1 = "egg";
        String t1 = "add";
        IsomorphicStrings is1 = new IsomorphicStrings();
        System.out.println(is1.isIsomorphic3(s1, t1));
    }
}
