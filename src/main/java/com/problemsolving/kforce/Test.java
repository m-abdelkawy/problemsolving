package com.problemsolving.kforce;

import java.util.List;

public class Test {
    int solution(String pattern, String source){
        int count = 0;
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u', 'y');

        for (int i = 0; i < source.length() - pattern.length() + 1; i++) {
            int end = pattern.length();
            String sub = source.substring(i, i + end);
            boolean match = true;
            for(int j = 0; j < pattern.length(); j++){
                if((pattern.charAt(j) == '0' && !vowels.contains(sub.charAt(j)))
                        ||
                        (pattern.charAt(j) == '1' && vowels.contains(sub.charAt(j)))){
                    match = false;
                }
            }
            if(match){
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String pattern = "010";
        String source = "amazing";

        Test test = new Test();
        System.out.println(test.solution(pattern, source));
    }
}
