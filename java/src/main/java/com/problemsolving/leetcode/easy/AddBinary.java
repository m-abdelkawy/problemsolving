package com.problemsolving.leetcode.easy;

import java.math.BigInteger;

/**
 * 67. Add Binary
 * Link: https://leetcode.com/problems/add-binary
 *
 * @author m-abdelkawy
 * @version 1.0.0
 * @since 18.05.2023
 */
public class AddBinary {
    public String addBinary1(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }

    public String addBinary2(String a, String b) {
        int n = a.length(), m = b.length();
        if (n < m) {
            return addBinary2(b, a);
        }

        StringBuilder sb = new StringBuilder();
        int carry = 0, j = m - 1;
        for (int i = n - 1; i > -1; i--) {
            if (a.charAt(i) == '1') {
                carry++;
            }
            if (j > -1 && b.charAt(j--) == '1') {
                carry++;
            }

            if (carry % 2 == 1) {
                sb.append(1);
            }else{
                sb.append(0);
            }

            carry /= 2;
        }

        if(carry == 1){
            sb.append(1);
        }

        sb.reverse();

        return sb.toString();
    }

    public String addBinary3(String a, String b) {
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        BigInteger carry, answer;
        BigInteger zero = new BigInteger("0", 2);
        while(y.compareTo(zero) != 0){
            answer = x.xor(y);
            carry = x.and(y).shiftLeft(1);

            x = answer;
            y = carry;
        }
        return x.toString(2);
    }

    public static void main(String[] args) {
        String a = "1010", b = "1011";
        AddBinary addition = new AddBinary();
        System.out.println(addition.addBinary3(a, b));
    }
}
