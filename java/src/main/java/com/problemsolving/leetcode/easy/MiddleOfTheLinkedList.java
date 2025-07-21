package com.problemsolving.leetcode.easy;

/**
 * 876. Middle of the Linked List
 * Link: https://leetcode.com/problems/middle-of-the-linked-list/
 *
 * @author m-abdelkawy
 * @version 1.0.0
 * @since 06.07.2022
 */
public class MiddleOfTheLinkedList {
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

    public ListNode middleNode(ListNode head) {
        int len = 0;
        ListNode ptr = head;
        while (ptr != null && ptr.next != null) {
            ptr = ptr.next;
            len++;
        }

        int mid = len % 2 != 0 ? (len / 2) + 1: len / 2;
        ptr = head;
        for (int i = 0; i < mid; i++) {
            ptr = ptr.next;
        }
        return ptr;
    }

    public ListNode middleNode2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
