package com.problemsolving.leetcode.easy;

/**
 * 203. Remove Linked List Elements
 * Link: https://leetcode.com/problems/remove-linked-list-elements/
 *
 * @author m-abdelkawy
 * @version 1.0.0
 * @since 03.07.2022
 */
public class RemoveLinkedListElements {
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

    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = head, current = head;
        while(current != null){

            if(current.val == val){
                if(current == head){
                    head = head.next;
                    current.next = null;
                    current = head;
                    prev = head;
                }else{
                    current = current.next;
                    prev.next = current;
                }
            }
            else{
                prev = current;
                current = current.next;
            }
        }
        return head;
    }

    public ListNode removeElements1(ListNode head, int val) {
        ListNode current = head;

        ListNode prev = new ListNode();
        prev.next = current;


        while(current != null){
            if(current.val == val){
                prev.next = current.next;
                if(current == head){
                    head = prev.next;
                }
                current = prev.next;
            }
            else{
                current = current.next;
                prev = prev.next;
            }
        }
        return head;
    }

    public ListNode removeElements2(ListNode head, int val) {
        if(head == null)
            return null;

        ListNode ptr = head;
        while(ptr.next != null){
            if(ptr.next.val == val){
                ptr.next = ptr.next.next;
            }
            else{
                ptr = ptr.next;
            }
        }
        return head.val == val? head.next: head;
    }
}
