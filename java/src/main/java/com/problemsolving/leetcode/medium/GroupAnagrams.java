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
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            if(!map.containsKey(sortedStr)){
                map.put(sortedStr, new ArrayList<String>());
            }
            map.get(sortedStr).add(str);
        }
        return new ArrayList(map.values());
    }
    /*--------------------------------------------------------------*/

    public List<List<String>> groupAnagrams3(String[] strs) {
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

    /*--------------------------------------------------------------*/
    public List<List<String>> groupAnagrams4(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            String sortedStr = sorted(strs[i]);
            if(!map.containsKey(sortedStr)){
                map.put(sortedStr, new ArrayList<String>());
            }
            map.get(sortedStr).add(strs[i]);
        }

        return new ArrayList(map.values());
    }

    private String sorted(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    /*--------------------------------------------------------------*/

    /**
     * O(n * m) time
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams5(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];
        for (int i = 0; i < strs.length; i++) {
            Arrays.fill(count, 0);

            String key = hashString(strs[i], count);

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }

    private String hashString(String str, int[] count){
        for(char c: str.toCharArray()){
            count[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < count.length; i++){
            sb.append("#").append(count[i]);
        }
        return sb.toString();
    }
}
