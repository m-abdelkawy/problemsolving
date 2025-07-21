package com.problemsolving;

import java.util.Arrays;

public class Substring {
    public static boolean substring(String str1, String str2){
       int[] count = new int[26];

       for(int i = 0; i < str1.length(); i++){
           count[str1.charAt(i) - 'a']++;
       }

        for(int i = 0; i < str2.length(); i++){
            count[str2.charAt(i) - 'a']--;
            if(count[str2.charAt(i)- 'a'] < 0){
                return false;
            }
        }


        return true;
    }
    public static void main(String[] args) {
        // aabbcc
        // bb

        String s1 = "aabbcc";
        String s2 = "ac";

        System.out.println(substring(s1, s2));
    }
}
