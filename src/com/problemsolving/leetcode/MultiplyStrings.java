package com.problemsolving.leetcode;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        // reverse numbers to multiply from right to left
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();
        
        int[] arr = new int[n1.length() + n2.length()];

        for (int i = 0; i < n1.length(); i++) {
            for (int j = 0; j < n2.length(); j++) {
                arr[i+j] += (n1.charAt(i)-'0') * (n2.charAt(j)-'0');
            }
        }

        // result in string builder
        StringBuilder sb = new StringBuilder();

        // consider all numbers in the array as units
        // so the unit part of each number will be in its correct position
        // carry the remaining part to the next position
        for (int i = 0; i < arr.length; i++) {
            int mod = arr[i] % 10; // the unit part- keep in place
            int carry = arr[i] /10; // carry the tens part to the next position
            if(i+1 < arr.length){
                arr[i+1] += carry;
            }
            sb.insert(0, mod);
        }

        // remove zeros from the left
        while(sb.charAt(0) == '0' && sb.length() > 1){
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }

    public String multiplyKaratsuba(String num1, String num2){
        // to do
        throw  new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        String num1 = "207";
        String num2 = "30";

        System.out.println(new MultiplyStrings().multiply(num1, num2));
    }
}
