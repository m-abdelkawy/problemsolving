package com.problemsolving.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern2 {
    public boolean wordPatternMatch(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        return isMatchDFS(pattern, 0, s, 0, map, set);
    }

    private boolean isMatchDFS(String pat, int pat_index, String str, int str_index, Map<Character, String> map, Set<String> set) {

        //base cases
        if (pat_index == pat.length() && str_index == str.length())
            return true;
        if (pat_index == pat.length() || str_index == str.length())
            return false;

        char c = pat.charAt(pat_index);

        if (map.containsKey(c)) {
            String mapped_str = map.get(c);

            if (!str.startsWith(mapped_str, str_index)) {
                return false;
            }

            return isMatchDFS(pat, pat_index + 1, str, str_index + mapped_str.length(), map, set);
        }

        for (int k = str_index; k < str.length(); k++) {
            String s = str.substring(str_index, k + 1);

            if (set.contains(s)) {
                continue;
            }

            map.put(c, s);
            set.add(s);

            if (isMatchDFS(pat, pat_index + 1, str, k + 1, map, set)) {
                return true;
            }

            //backtrack
            map.remove(c);
            set.remove(s);

        }
        return false;
    }


}
