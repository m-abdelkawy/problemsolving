package com.problemsolving.leetcode.medium;


/**
 * 2. Add Two Numbers
 * Link: https://leetcode.com/problems/add-two-numbers
 *
 * @author m-bdelkawy
 * @version 1.0.0
 * @since 01.06.2023
 */
public class AddTwoNumbers {

    //Definition for singly-linked list.
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum/10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        return dummyHead.next;
    }
}
