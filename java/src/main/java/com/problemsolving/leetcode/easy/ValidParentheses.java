package com.problemsolving.leetcode.easy;

import java.util.*;

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

    public static List<String> matchingBraces(List<String> braces) {
        // Write your code here
        List<String> res = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < braces.size(); i++){
            stack.clear();
            char[] chars = braces.get(i).toCharArray();

            for(int j = 0; j < chars.length; j++){
                if(chars[j] == '{' || chars[j] == '(' || chars[j] == '['){
                    stack.push(chars[j]);
                }else if(!stack.isEmpty() && ((chars[j] == '}' && stack.peek() == '{')
                        || (chars[j] == ']' && stack.peek() == '[') || (chars[j] == ')' && stack.peek() == '('))){
                    stack.pop();

                }else{
                    res.add("NO");
                    break;
                }
            }

            if(res.size() >= i+1)
                continue;

            if(stack.isEmpty()){
                res.add("YES");
            }else{
                res.add("NO");
            }
        }

        return res;
    }


    public static void main(String[] args) {
        //String s = "{}";
        //System.out.println(isValid(s));

        List<String> braces = List.of("{[()]}", "{[(])}", "{{[[(())]]}}");
        System.out.println(Arrays.toString(matchingBraces(braces).toArray()));
    }
}
