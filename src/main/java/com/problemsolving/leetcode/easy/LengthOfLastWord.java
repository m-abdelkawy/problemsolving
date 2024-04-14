package com.problemsolving.leetcode.easy;

public class LengthOfLastWord {
    public int lengthOfLastWord1(String s) {
        String[] arr = s.split(" ");
        return arr[arr.length - 1].length();
    }

    public int lengthOfLastWord2(String s) {
        int len = 0;
        int p = s.length() - 1;
        while(p >= 0){
            if(len == 0 && s.charAt(p) == ' '){
                p--;
                continue;
            }else{
                p--;
                len++;
            }

            if(p < 0 || s.charAt(p) == ' '){
                break;
            }
        }
        return len;
    }

    public int lengthOfLastWord3(String s) {
        s = s.trim();  // trim the trailing spaces in the string
        return s.length() - s.lastIndexOf(" ") - 1;
    }

    public int lengthOfLastWord4(String s){
        int p = s.length() - 1;
        while(p >= 0 && s.charAt(p) == ' '){
            p--;
        }

        int len = 0;
        while(p >= 0 && s.charAt(p) != ' '){
            p--;
            len++;
        }
        return len;
    }

    public int lengthOfLastWord5(String s){
        int p = s.length(), len = 0;
        while(p > 0){
            p--;
            if(s.charAt(p) != ' '){
                len++;
            }else if(len > 0){
                return len;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        String s = "a";
        LengthOfLastWord lw = new LengthOfLastWord();
        System.out.println(lw.lengthOfLastWord2(s));
    }
}
