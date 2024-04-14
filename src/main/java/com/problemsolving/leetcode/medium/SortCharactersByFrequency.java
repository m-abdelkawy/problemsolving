package com.problemsolving.leetcode.medium;

import java.util.*;

/**
 * 451. Sort Characters By Frequency
 * Link: https://leetcode.com/problems/sort-characters-by-frequency/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 18.01.2022
 */
public class SortCharactersByFrequency {
    public static String frequencySort1(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            frequencyMap.put(chars[i], frequencyMap.getOrDefault(chars[i], 0) + 1);
        }
        List<String> lst = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character, Integer> entry: frequencyMap.entrySet()){
            Character c = entry.getKey();
            int frequency = entry.getValue();
            for (int i = 0; i < frequency; i++) {
                sb.append(c);
            }
            if(sb.length() > 0){
                lst.add(sb.toString());
                sb.setLength(0);
                sb = new StringBuilder();
            }
        }
        Collections.sort(lst, Comparator.comparing(String::length).reversed());
        return String.join("", lst);
    }

    public static String frequencySort2(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            frequencyMap.put(chars[i], frequencyMap.getOrDefault(chars[i], 0) + 1);
        }
        List<Character> lstChar = new ArrayList<>(frequencyMap.keySet());
        Collections.sort(lstChar, (a, b) -> frequencyMap.get(b) - frequencyMap.get(a));
        StringBuilder sb = new StringBuilder();
        for (Character c: lstChar){
            int frquency = frequencyMap.get(c);
            for (int i = 0; i < frquency; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort1("Aabb"));
    }
}
