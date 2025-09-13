package com.problemsolving.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 66. Plus One
 * Link: https://leetcode.com/problems/plus-one
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 08.05.2023
 */
public class PlusOne {
    // failed case 61/111
    public static int[] plusOne1(int[] digits) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < digits.length; i++){
            sb.append(digits[i]);
        }

        long num = Long.parseLong(sb.toString()) + 1;

        List<Long> lst = new ArrayList<>();

        while(num > 0){
            lst.add(num % 10);
            num /= 10;
        }

        Collections.reverse(lst);
        return lst.stream().mapToInt(x -> x.intValue()).toArray();
    }

    public static int[] plusOne2(int[] digits) {
        digits[digits.length - 1]++;
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            carry = 0;
            if(digits[i] == 10){
                digits[i] = 0;
                carry = 1;
            }
        }

        if(carry == 1){
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            System.arraycopy(digits, 0, res, 1, digits.length);
            return res;
        }

        return digits;
    }

    public static int[] plusOne3(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if(digits[i] == 9){
                digits[i] = 0;
            }else{
                digits[i]++;
                return digits;
            }
        }

        digits = new int[n+1];
        digits[0] = 1;

        return digits;
    }

    public static void main(String[] args) {
        // 9223372036854775807
        // 728509129536673284379577474947011174006
        //int[] digits = {7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6};
        int[] digits = {9};

        System.out.println(Arrays.toString(plusOne2(digits)));
    }
}
