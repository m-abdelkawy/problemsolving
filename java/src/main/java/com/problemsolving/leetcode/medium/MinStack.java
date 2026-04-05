package com.problemsolving.leetcode.medium;

import java.util.Stack;

/**
 * 155. Min Stack
 * Link: https://leetcode.com/problems/min-stack
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 04.04.2026
 */
class MinStack1 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinStack1() {

    }

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
    }

    public void pop() {
        int popped = stack.pop();
        if(popped == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Solution with one stack
 */
class MinStack2 {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<>();

    public MinStack2() {
    }

    public void push(int val) {
        // only push the old minimum value when the current
        // minimum value changes after pushing the new value x
        if(val <= min){
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value,
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min){
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Design a singly linked list that holds the current min value at every node
 */
class MinStack3 {
    ListNode head;
    int min = Integer.MAX_VALUE;

    class ListNode{
        int val;
        int currentMin;
        ListNode next;

        ListNode(int val, int min, ListNode next){
            this.val = val;
            this.currentMin = min;
            this.next = next;
        }
    }

    public MinStack3() {
        head = null;
    }

    public void push(int val) {
        min = Math.min(min, val);
        head = new ListNode(val, min, head);
    }

    public void pop() {
        head = head.next;
        if(head == null){
            min = Integer.MAX_VALUE;
        } else{
            min = head.currentMin;
        }
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.currentMin;
    }
}
