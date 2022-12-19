package com.problemsolving.sita;

import java.util.HashSet;
import java.util.Set;

public class Task1 {
    public String solution(String S) {
        // write your code in Java SE 8
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < S.length(); i++){
            if(!set.add(S.charAt(i))){
                return S.charAt(i) + "";
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String s = "Codility";
Task1 task1 = new Task1();
        System.out.println(task1.solution(s));
    }
}
