package com.problemsolving.leetcode.easy;

/**
 * 19. Remove Nth Node From End of List
 * Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * @author m-abdelkawy
 * @version 1.0.0
 * @since 1.1.2023
 */
public class RemoveNthNodeFromEndOfList {
    ListNode head;

    {
        head = new ListNode(1);
        head.next = new ListNode(2);
        //head.next = new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))));
    }

    class ListNode {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int sz = 0;
        ListNode itr = head;
        while (itr != null) {
            sz++;
            itr = itr.next;
        }

        int m = sz - n + 1;
        int counter = 0;
        ListNode current = head;
        ListNode prev = current;
        while (counter < m - 1) {
            counter++;
            prev = current;
            current = current.next;
        }


        if (m == 1) {
            head = head.next;
        } else if (prev == current) {
            head = null;
        }else{
            prev.next = current.next;
            current.next = null;
        }


        return head;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList rn = new RemoveNthNodeFromEndOfList();
        ListNode res = rn.removeNthFromEnd(rn.head, 2);
        System.out.println(res == null ? "[]" : res.val);
    }
}
