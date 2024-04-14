package com.problemsolving.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. Linked List Cycle
 * Link: https://leetcode.com/problems/linked-list-cycle/
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 02.07.2022
 */
public class LinkedListCycle {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // the fastest
    public boolean hasCycle(ListNode head) {
        ListNode  slow = head;
        ListNode fast = head;
        while(fast != null && fast.next!= null){
            fast = fast.next.next;
            slow=slow.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    //slow
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode ptr = head;
        while(ptr != null){
            if(set.contains(ptr)){
                return true;
            }
            set.add(ptr);
            ptr=ptr.next;
        }
        return false;
    }
}
