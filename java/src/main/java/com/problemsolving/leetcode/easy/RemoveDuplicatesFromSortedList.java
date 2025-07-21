package com.problemsolving.leetcode.easy;

/**
 * 83. Remove Duplicates from Sorted List
 * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 23.08.2022
 */
public class RemoveDuplicatesFromSortedList {
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

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode ptr = head;
        ListNode prev = new ListNode(-101);
        prev.next = head;
        ListNode next = head.next;
        while (ptr != null) {
            if (ptr.val == prev.val) {
                ptr.next = null;
                prev.next = next;
                ptr = next;
                next = next == null ? null : next.next;
            } else {
                prev = prev.next;
                ptr = ptr.next;
                next = next == null ? null : next.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode ptr = head;
        while (ptr.next != null) {
            if (ptr.next.val == ptr.val)
                ptr.next = ptr.next.next;
            else
                ptr = ptr.next;
        }
        return head;
    }
}
