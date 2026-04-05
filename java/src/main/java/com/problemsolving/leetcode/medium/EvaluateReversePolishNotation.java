package com.problemsolving.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 150. Evaluate Reverse Polish Notation
 * Link: https://leetcode.com/problems/evaluate-reverse-polish-notation
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 05.04.2026
 */
public class EvaluateReversePolishNotation {
    /**
     * Time Complexity: O(n) since every token is checked once
     * Space Complexity: O(n) since the stack holds n value at max
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        int operationResult = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                operationResult = switch (token) {
                    case "+" -> (num1 + num2);
                    case "-" -> (num1 - num2);
                    case "*" -> (num1 * num2);
                    case "/" -> (num1 / num2);
                    default -> operationResult;
                };
                stack.push(operationResult);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
