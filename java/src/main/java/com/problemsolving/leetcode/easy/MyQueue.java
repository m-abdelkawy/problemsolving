package com.problemsolving.leetcode.easy;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> stackLeft;
    Stack<Integer> stackRight;
    /*
    left ----------------||-----------------
         ----------------||-----------------right
     */
    public MyQueue() {
        stackLeft = new Stack<>();
        stackRight = new Stack<>();
    }

    public void push(int x) {
        stackLeft.push(x);
    }

    public int pop() {
        while(!stackLeft.isEmpty()){
            stackRight.push(stackLeft.pop());
        }
        int pop = stackRight.pop();

        while(!stackRight.isEmpty()){
            stackLeft.push(stackRight.pop());
        }

        return pop;
    }

    public int peek() {
        while(!stackLeft.isEmpty()){
            stackRight.push(stackLeft.pop());
        }
        int peek = stackRight.peek();
        while(!stackRight.isEmpty()){
            stackLeft.push(stackRight.pop());
        }
        return peek;
    }

    public boolean empty() {
        return stackLeft.isEmpty();
    }
}
