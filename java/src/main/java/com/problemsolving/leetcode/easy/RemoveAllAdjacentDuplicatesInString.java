package com.problemsolving.leetcode.easy;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 1047. Remove All Adjacent Duplicates In String
 * Link: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 30.01.2023
 */
public class RemoveAllAdjacentDuplicatesInString {
    /**
     * time limit exceeded
     *
     * @param s
     * @return
     */
    public String removeDuplicates1(String s) {
        int i = 0, j = 1;
        while (j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                s = s.substring(0, i) + s.substring(j + 1);
                i = 0;
                j = 1;
                continue;
            }
            i++;
            j++;
        }
        return s;
    }

    /**
     *
     *
     * @param s input string
     * @return string with duplicate consecutive characters removed
     */
    public String removeDuplicates1Optimized(String s) {
        int i = 0, j = i + 1;
        while (j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                s = s.substring(0, i) + s.substring(j + 1);
                i = i - 1 >= 0 ? i - 1 : 0;
                j = i + 1;
                continue;
            }
            i++;
            j++;
        }
        return s;
    }

    /**
     * Time Complexity: O(n2)
     * Time limit exceeded
     *
     * @param s input string
     * @return string with dupliucate consecutive characters removed
     */
    public String removeDuplicates2(String s) {
        Set<String> duplicates = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (char i = 'a'; i <= 'z'; i++) {
            sb.setLength(0);
            sb.append(i);
            sb.append(i);
            duplicates.add(sb.toString());
        }

        int previousLength = -1;
        while (previousLength != s.length()) {
            previousLength = s.length();
            for (String dup : duplicates) {
                s = s.replace(dup, "");
            }
        }
        return s;
    }

    /**
     * Time Complexity: O(n)
     *
     * @param s input string
     * @return string with dupliucate consecutive characters removed
     */
    public String removeDuplicates3(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (!stack.isEmpty()) {
                if (stack.peek().equals(s.charAt(i))) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(s.charAt(i));

        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public String removeDuplicates4(String s) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (sbLength != 0 && c == sb.charAt(sbLength - 1)) {
                sb.deleteCharAt(sbLength - 1);
                sbLength--;
            } else {
                sb.append(c);
                sbLength = sb.length();
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInString rd = new RemoveAllAdjacentDuplicatesInString();
        System.out.println(rd.removeDuplicates1Optimized("abbaca"));
        System.out.println(rd.removeDuplicates4("azxxzy"));
    }
}
