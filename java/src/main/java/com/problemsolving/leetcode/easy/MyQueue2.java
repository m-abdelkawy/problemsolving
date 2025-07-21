package com.problemsolving.leetcode.easy;

import java.util.Stack;

public class MyQueue2 {

    Stack<Integer> stack;
    public MyQueue2() {
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        int pop = stack.get(0);
        stack.remove(0);

        return pop;
    }

    public int peek() {
        return stack.get(0);
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
