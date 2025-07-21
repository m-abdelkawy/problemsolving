package com.problemsolving.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 206. Reverse Linked List
 * Link: https://leetcode.com/problems/reverse-linked-list/
 *
 * @author m-bdelkawy
 * @version 1.0.0
 * @since 06.07.2022
 */
public class ReverseLinkedList {
    private static class ListNode {
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

    private void swap(ListNode a, ListNode b){
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;
        if(head.next == null)
            return head;

        ListNode ptr = head;
        ListNode last = null;


        while (ptr != last) {
            while (ptr.next != last) {
                swap(ptr, ptr.next);
                ptr = ptr.next;
                if(ptr.next == last){
                    break;
                }
            }
            last = ptr;
            ptr = head;
        }
        return head;
    }

    public ListNode reverseList2(ListNode head) {
        List<Integer> lst = new ArrayList<>();
        ListNode ptr = head;
        while(ptr != null){
            lst.add(ptr.val);
            ptr = ptr.next;
        }
        int[] arr = lst.stream()
                .mapToInt(x->x.intValue())
                .toArray();
        int i = 0, j = arr.length-1;

        while(i<j){
            swap(arr, i++, j--);
        }

        int k = 0;
        ptr = head;
        while(ptr != null){
            ptr.val = arr[k++];
            ptr = ptr.next;
        }
        return head;
    }

    private void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public ListNode reverseList3(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        // The technique here is to reverse links (i.e. next)
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public ListNode reverseList4(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode newHead = reverseList4(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode head = node1;

        ReverseLinkedList rls = new ReverseLinkedList();
        rls.reverseList(head);
    }
}
