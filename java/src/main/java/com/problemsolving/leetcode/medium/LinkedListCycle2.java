package com.problemsolving.leetcode.medium;

public class LinkedListCycle2 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode curr=head;
        boolean isCycleExist = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                isCycleExist = true;
                break;
            }
        }
        if(!isCycleExist)
            return null;

        while (curr != null & curr.next != null){
            slow = curr;
            fast = curr;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if(slow == curr || fast == curr)
                    return curr;
                if(slow == fast)
                    break;
            }
            curr = curr.next;
        }
        return null;
    }
}
