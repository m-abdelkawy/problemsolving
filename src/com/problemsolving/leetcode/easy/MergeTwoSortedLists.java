package com.problemsolving.leetcode.easy;

/**
 * 21. Merge Two Sorted Lists
 * Link: https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 03.07.2022
 */
public class MergeTwoSortedLists {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null)
            return null;
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        ListNode i = list1;
        ListNode j = list2;
        ListNode head;
        ListNode ptr;
        if(i.val <= j.val){
            head = new ListNode(i.val);
            i = i.next;
        }else{
            head = new ListNode(j.val);
            j = j.next;
        }
        ptr = head;

        while(i != null || j != null){
            if(i == null){
                while(j != null){
                    ptr.next = new ListNode(j.val);
                    j = j.next;
                    ptr = ptr.next;
                }
            }
            else if(j == null){
                while(i != null){
                    ptr.next = new ListNode(i.val);
                    i = i.next;
                    ptr = ptr.next;
                }
            }else{
                if(i.val <= j.val){
                    ptr.next = new ListNode(i.val);
                    i = i.next;
                    ptr = ptr.next;
                }else{
                    ptr.next = new ListNode(j.val);
                    j = j.next;
                    ptr = ptr.next;
                }
            }
        }
        return head;
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null)
            return null;
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;

        ListNode ptr = null;
        ListNode head = ptr;

        ListNode ptr1 = list1;
        ListNode ptr2 = list2;

        if(list1.val <= list2.val){
            head = list1;
            ptr = head;
            ptr1 = ptr1.next;
        }else{
            head = list2;
            ptr = head;
            ptr2 = ptr2.next;
        }

        while(ptr != null){

            if(ptr1 == null){
                while(ptr != null && ptr2 != null){
                    ptr.next = ptr2;
                    ptr = ptr.next;
                    ptr2 = ptr2.next;
                }
                break;
            }else if(ptr2 == null){
                while(ptr != null && ptr1 != null){
                    ptr.next = ptr1;
                    ptr = ptr.next;
                    ptr1 = ptr1.next;
                }
                break;
            }
            if(ptr1.val <= ptr2.val){
                ptr.next = ptr1;
                ptr = ptr.next;
                ptr1 = ptr1.next;
            }

            else{
                ptr.next = ptr2;
                ptr = ptr.next;
                ptr2 = ptr2.next;
            }


        }


        return head;
    }

    public ListNode mergeTwoLists3(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;

        ListNode head = null;

        if(list1.val <= list2.val){
            head = list1;
            head.next = mergeTwoLists(list1.next, list2);
        }else{
            head = list2;
            head.next = mergeTwoLists(list1, list2.next);
        }

        return head;
    }
}
