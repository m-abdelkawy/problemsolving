package com.problemsolving.leetcode.medium;

/**
 * 61. Rotate List
 * Link: https://leetcode.com/problems/rotate-list
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 09.04.2026
 */
public class RotateList {
    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Time complexity: O(n), each node is traversed once
     * Space complexity: O(1), no extra data structure is introducec
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) {
            return head;
        }

        // count length and locate tail, and normalize k
        int length = 1;
        ListNode tail = head;
        while(tail.next != null){
            length++;
            tail = tail.next;
        }
        k = k % length;

        //make a loop
        tail.next = head;
        int stepsToNewHead = length - 1 - k;
        ListNode newTail = head;
        for(int i = 1; i <= stepsToNewHead; i++){
            newTail = newTail.next;
        }

        // locate new tail
        head = newTail.next;

        // break the loop
        newTail.next = null;

        // locate new head and return
        return head;
    }
}
