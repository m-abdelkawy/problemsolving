package com.problemsolving.leetcode.easy;

import java.util.Map;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 * Link: https://leetcode.com/problems/valid-parentheses/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 25.08.2022
 */
public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (s.charAt(i) == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (s.charAt(i) == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArr = s.toCharArray();
        int len = charArr.length;

        for (int i = 0; i < len; i++) {
            if (stack.isEmpty()) {
                if (charArr[i] == ')' || charArr[i] == '}' || charArr[i] == ']')
                    return false;
                else
                    stack.push(charArr[i]);
            } else {
                char lastInserted = stack.peek();
                if (charArr[i] == ')' && lastInserted == '('
                        || charArr[i] == '}' && lastInserted == '{'
                        || charArr[i] == ']' && lastInserted == '[')
                    stack.pop();
                else
                    stack.push(charArr[i]);
            }
        }

        return stack.isEmpty();
    }

    public static boolean isValid3(String s) {
        Map<Character, Character> map = Map.of('(', ')', '{', '}', '[', ']');
        Stack<Character> stack = new Stack<>();
        char[] charArr = s.toCharArray();
        int len = charArr.length;

        for (int i = 0; i < len; i++) {
            if (stack.isEmpty()) {
                if(map.values().contains(charArr[i]))
                    return false;
                else
                    stack.push(charArr[i]);
            } else {
                char lastInserted = stack.peek();
                if (map.containsKey(lastInserted) && charArr[i] == map.get(lastInserted))
                    stack.pop();
                else
                    stack.push(charArr[i]);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{}";
        System.out.println(isValid(s));
    }
}
