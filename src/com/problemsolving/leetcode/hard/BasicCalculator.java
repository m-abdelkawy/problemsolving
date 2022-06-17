package com.problemsolving.leetcode.hard;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();

        int res = 0;
        int num = 0;
        int sign = 1;
        stack.push(sign);

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                num = num * 10 + (chars[i] - '0');
            }
            else if(chars[i] == '+' || chars[i] == '-'){
                res += sign * num;
                sign = stack.peek() * (chars[i] == '+'?1:-1);
                num = 0;
            }
            else if(chars[i] == '('){
                stack.push((sign));
            }
            else if(chars[i] == ')'){
                stack.pop();
            }
        }

        res += sign * num;
        return res;
    }

    public static void main(String[] args) {
        BasicCalculator calc = new BasicCalculator();
        System.out.println(calc.calculate("1 + 1")); //2
    }
}
