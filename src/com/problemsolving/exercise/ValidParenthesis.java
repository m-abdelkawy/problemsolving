package com.problemsolving.exercise;

import java.util.Stack;

public class ValidParenthesis {
    public static boolean isValid(String s) {
        Stack<Character> stack1 = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack1.push(s.charAt(i));
            }
            else if(s.charAt(i) == ')' && stack1.peek() == '('){
                stack1.pop();
            }
            else if(s.charAt(i) == '}' && stack1.peek() == '{'){
                stack1.pop();
            }
            else if(s.charAt(i) == ']' && stack1.peek() == '['){
                stack1.pop();
            }
        }

        return stack1.isEmpty();
    }

    public static void main(String[] args) {
        String s = "())";

        System.out.println(isValid(s));
    }
}
