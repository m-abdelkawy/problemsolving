package com.problemsolving.pureintegration;

import java.util.*;

public class AutocorrectPrototype {
    public static List<List<String>> getSearchResults(List<String> words, List<String> queries){
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();


        for (String query: queries) {
            String hashQuery = hashString(query);
            map.put(hashQuery, new ArrayList<>());
            for (String word: words) {
                if(hashString(word).equals(hashQuery)){
                    map.get(hashQuery).add(word);
                }
            }
            Collections.sort(map.get(hashQuery));
        }

        res.addAll(map.values());
        return res;
    }

    private static String hashString(String str){
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        for (char c: chars) {
            sb.append(c-'0').append("-");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<String> words1 = Arrays.asList(new String[]{"duel", "speed", "dule", "cars"});
        List<String> queries1 = Arrays.asList(new String[]{"spede","deul"});

        System.out.println(getSearchResults(words1, queries1));

        System.out.println("----------------------------------");

        List<String> words2 = Arrays.asList(new String[]{"allot", "cat", "peach", "dusty", "act", "cheap"});
        List<String> queries2 = Arrays.asList(new String[]{"tac", "study", "peahc"});

        System.out.println(getSearchResults(words2, queries2));
    }
}
