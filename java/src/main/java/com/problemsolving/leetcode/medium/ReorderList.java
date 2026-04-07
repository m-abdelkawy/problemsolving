package com.problemsolving.leetcode.medium;

/**
 * 143. Reorder List
 * Link: https://leetcode.com/problems/reorder-list
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 07.04.2026
 */
public class ReorderList {

    public class ListNode {
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
     *
     * @param head
     */
    public void reorderList1(ListNode head) {
        // 1. find the middle node
        ListNode slow = head, fast= head;
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode list2 = slow.next;
        slow.next = null;

        // 2. reverse the second half
        list2 = reverseIterative1(list2);


        // 3. merge both halves
        head = mergeTwoLists1(head, list2);

    }

    private ListNode reverseIterative1(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private ListNode reverseRecursive1(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = reverseRecursive1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private ListNode mergeTwoLists1(ListNode list1, ListNode list2){
        ListNode prehead = new ListNode(-1);
        ListNode ptr = prehead;
        boolean atList1 = true;
        while (list1 != null && list2 != null){
            if(atList1){
                ptr.next = list1;
                list1 = list1.next;
                atList1 = false;
            } else{
                ptr.next = list2;
                list2 = list2.next;
                atList1 = true;
            }
            ptr = ptr.next;
        }
        ptr.next = list1 == null ? list2 : list1;
        return prehead.next;
    }

    /*------------simplified-----------*/
    public void reorderList2(ListNode head) {
        // 1. find middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. reverse second half
        ListNode list2 = reverseIterative2(slow.next);
        slow.next = null;

        // 3. merge alternating in place
        mergeTwoLists2(head, list2);
    }

    private ListNode reverseIterative2(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private ListNode reverseRecursive2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = reverseRecursive2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private void mergeTwoLists2(ListNode list1, ListNode list2){
        while(list1 != null && list2 != null){
            ListNode next1 = list1.next;
            ListNode next2 = list2.next;

            list1.next = list2;

            if(next1 != null) list2.next = next1;

            list1 = next1;
            list2 = next2;
        }
    }
}