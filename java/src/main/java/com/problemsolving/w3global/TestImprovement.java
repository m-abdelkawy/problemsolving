package com.problemsolving.w3global;

public class TestImprovement {

    public static boolean s2SubStringOfS1(String s1, String s2) {
        //Ex: s2SubStringOfS1("abcde", "cd") return true.
        //Ex: s2SubStringOfS1("abcde", "ce") return false. ce is not a substring of the abcde.
        //Note: Do not use any Standard String class methods like contains(), substring(), etc.
        //Implement your own algorithm/logic to return true or false. focus on implementation optimized for memory/performance

        if (s2.length() > s1.length())
            return false;


        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(0)) {
                if(s2.length() > s1.length() - i)
                    return false;
                StringBuilder sb = new StringBuilder();
                for (int j = i; j < i + s2.length(); j++) {
                    sb.append(s1.charAt(j));
                }
                if(sb.toString().equals(s2))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(s2SubStringOfS1("abcde", "ce"));
        System.out.println(s2SubStringOfS1("abcde", "cd"));
        System.out.println(s2SubStringOfS1("abcde", "de"));
        System.out.println(s2SubStringOfS1("abcde", "d"));
        System.out.println(s2SubStringOfS1("abcde", "e"));
        System.out.println(s2SubStringOfS1("abcde", "ab"));
        System.out.println(s2SubStringOfS1("abcde", "ac"));
        System.out.println(s2SubStringOfS1("abcde", "dee"));
    }

}