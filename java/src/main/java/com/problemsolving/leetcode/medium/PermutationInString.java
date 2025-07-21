package com.problemsolving.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 567. Permutation in String
 * Link: https://leetcode.com/problems/permutation-in-string/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 02.01.2023
 */
public class PermutationInString {
    public boolean checkInclusion1(String s1, String s2) {
        boolean containsPermutation = true;
        int n1 = s1.length(), n2 = s2.length();

        if (n1 > n2)
            return false;

        int left = 0, right = n1;


        while (right <= n2) {
            int[] frequency = new int[26];
            String s = s2.substring(left, right);
            for (int i = left; i < right; i++) {
                frequency[s2.charAt(i) - 'a']++;
            }
            for (int i = 0; i < n1; i++) {
                frequency[s1.charAt(i) - 'a']--;
            }
            for (int i = 0; i < 26; i++) {
                containsPermutation = true;
                if (frequency[i] != 0) {
                    containsPermutation = false;
                    break;
                }
            }
            if (containsPermutation)
                break;
            right++;
            left++;
        }
        return containsPermutation;
    }

    public boolean checkInclusion2(String s1, String s2) {
        s1 = sort(s1);
        int n1 = s1.length(), n2 = s2.length();
        for (int i = 0; i < n2 - n1 + 1; i++) {
            String s = s2.substring(i, i + n1);
            if (s1.equals(sort(s)))
                return true;
        }
        return false;
    }

    private String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    /**
     * HashMap approach
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion3(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();

        if (n1 > n2)
            return false;

        Map<Character, Integer> s1Map = new HashMap<>();

        for (int i = 0; i < n1; i++) {
            char c = s1.charAt(i);
            s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < n2 - n1 + 1; i++) {
            Map<Character, Integer> s2Map = new HashMap<>();
            String s = s2.substring(i, i + n1);
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                s2Map.put(c, s2Map.getOrDefault(c, 0) + 1);
            }
            if(matches(s1Map, s2Map)){
                return true;
            }
        }
        return false;
    }

    /**
     * HashMap approach
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion4(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();

        if (n1 > n2)
            return false;

        Map<Character, Integer> s1Map = new HashMap<>();

        for (int i = 0; i < n1; i++) {
            char c = s1.charAt(i);
            s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < n2 - n1 + 1; i++) {
            Map<Character, Integer> s2Map = new HashMap<>();
            for (int j = 0; j < n1; j++) {
                char c = s2.charAt(i + j);
                s2Map.put(c, s2Map.getOrDefault(c, 0) + 1);
            }
            if(matches(s1Map, s2Map)){
                return true;
            }
        }
        return false;
    }

    private boolean matches(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (char key : map1.keySet()) {
            if (map1.get(key) - map2.getOrDefault(key, 0) != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Array approach
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion5(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        for (int i = 0; i < s1.length(); i++)
            s1map[s1.charAt(i) - 'a']++;
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] s2map = new int[26];
            for (int j = 0; j < s1.length(); j++) {
                s2map[s2.charAt(i + j) - 'a']++;
            }
            if (matches(s1map, s2map))
                return true;
        }
        return false;
    }

    public boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }

    /*---------------------------------------Sliding Window approach-------------------------------------------*/
    /**
     * Sliding Window approach
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion6(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();

        if (n1 > n2)
            return false;

        int[] s1map = new int[26];
        int[] s2map = new int[26];

        for (int i = 0; i < n1; i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < n2 - n1; i++) {
            if (matches(s1map, s2map))
                return true;
            int left = i, right = i + s1.length();
            s2map[s2.charAt(right) - 'a']++;
            s2map[s2.charAt(left) - 'a']--;
        }
        return matches(s1map, s2map);
    }
    /*---------------------------------------Sliding Window Optimized approach-------------------------------------------*/
    /**
     * Sliding Window Optimized
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion7(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (s1map[i] == s2map[i])
                count++;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int right = s2.charAt(i + s1.length()) - 'a', left = s2.charAt(i) - 'a';
            if (count == 26)
                return true;
            s2map[right]++;
            if (s2map[right] == s1map[right]) {
                count++;
            } else if (s2map[right] == s1map[right] + 1) {
                count--;
            }
            s2map[left]--;
            if (s2map[left] == s1map[left]) {
                count++;
            } else if (s2map[left] == s1map[left] - 1) {
                count--;
            }
        }
        return count == 26;
    }



    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        PermutationInString ps = new PermutationInString();
        System.out.println(ps.checkInclusion7(s1, s2));
    }
}
