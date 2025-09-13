package com.problemsolving.leetcode.easy;

/**
 * 415. Add Strings
 * https://leetcode.com/problems/add-strings/?envType=study-plan&id=data-structure-ii
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 18.09.2022
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();

        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;

        int val = 0, carry = 0;

        while (p1 >= 0 || p2 >= 0) {
            int n1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
            int n2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
            val = (n1 + n2 + carry) % 10;
            carry = (n1 + n2 + carry) / 10;
            p1--;
            p2--;
            sb.append(val);
        }

        if(carry != 0){
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "11";
        String num2 = "123";
        AddStrings as = new AddStrings();
        System.out.println(as.addStrings(num1, num2));
    }
}
