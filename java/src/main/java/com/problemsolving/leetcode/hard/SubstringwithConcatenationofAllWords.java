package com.problemsolving.leetcode.hard;

import java.util.*;

/**
 * 30. Substring with Concatenation of All Words
 * Link: https://leetcode.com/problems/add-two-numbers
 *
 * @author m-bdelkawy
 * @version 1.0.0
 * @since 04.06.2023
 */
public class SubstringwithConcatenationofAllWords {

    // exceeds time limit case 174 / 178
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();

        int arr_len = words.length;
        int word_len = words[0].length();
        int window_len = arr_len * word_len;
        Set<Integer> set = new HashSet<>();

        if(word_len == 1){
            for (int i = 0; i < s.length(); i++) {
                if(s.substring(i, i+1).equals(s)){
                    res.add(i);
                }
            }
            return res;
        }

        boolean isConcatinated = false;
        for (int i = 0; i < s.length(); i++) {
            isConcatinated = false;
            set.clear();
            int j = i + window_len;
            for (int k = i; k + word_len <= Math.min(j + 1, s.length()); k += word_len) {
                String sub = s.substring(k, k + word_len);
                List<Integer> indexes = contains(sub, words);
                if (indexes.get(0) != -1) {
                    if (set.containsAll(indexes)) {
                        break;
                    }else{
                        for (int l = 0; l < indexes.size(); l++) {
                            if(set.add(indexes.get(l))){
                                break;
                            }
                        }
                    }
                } else {
                    break;
                }
                if (set.size() == words.length) {
                    isConcatinated = true;
                }
            }
            if (isConcatinated) {
                res.add(i);
                //i += word_len - 1;
            }
        }


        return res;
    }

    private List<Integer> contains(String word, String[] words) {
        List<Integer> indexes = new ArrayList<>();
        int index = 0;
        for (String s : words) {
            if (word.equals(s)) {
                indexes.add(index);
            }
            index++;
        }
        return indexes.size() > 0 ? indexes : List.of(-1);
    }

    public static void main(String[] args) {
        String[] words = {"aa","aa"};
        String s = "aaaaaaaaaaaaaa";
        SubstringwithConcatenationofAllWords ss = new SubstringwithConcatenationofAllWords();
        System.out.println(ss.findSubstring(s, words));

    }
}
