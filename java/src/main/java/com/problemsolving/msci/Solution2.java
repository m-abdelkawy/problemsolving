package com.problemsolving.msci;

public class Solution2 {
    public static boolean isPalindrome(String str){
        StringBuilder sb = new StringBuilder(str);

        return sb.toString().equals(sb.reverse().toString());
    }

    public static boolean isNumberPalindrome(int num){
        int j = num;
        StringBuilder reversed = new StringBuilder();
        while(j > 0){
            int i = j%10;
            j/=10;
            reversed.append(i);
        }

        return Integer.parseInt(reversed.toString()) == num;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("aaabaaa"));
        System.out.println(isNumberPalindrome(1112111));
    }
}
