package com.problemsolving.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 49. Group Anagrams
 * Link: https://leetcode.com/problems/group-anagrams/
 */
public class GroupAnagrams {
    /**
     * O(n * m log m) time
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        int N = strs.length;
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] chars = strs[i].split("");
            Arrays.sort(chars);
            String key = Arrays.stream(chars).collect(Collectors.joining(""));
            if(map.containsKey(key)){
                map.get(key).add(strs[i]);
            }else{
                List<String> val = new ArrayList<>();
                val.add(strs[i]);
                map.put(key, val);
            }
        }
        return map.values().stream().collect(Collectors.toList());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        int N = strs.length;
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> anagrams = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        anagrams.addAll(map.values());
        return anagrams;
    }

}
