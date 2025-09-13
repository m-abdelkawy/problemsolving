# Problem: 206. Reverse Linked List
# Level: Easy
# Tags: LinkedList
# Link: https://leetcode.com/problems/reverse-linked-list/
# Date Solved: 2025.07.13

class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class ReverseLinkedList:
    # Iterative approach - reversing the next pointer
    def reverseList1(self, head):
        prev = None
        current = head
        next = None

        while current is not None:
            next = current.next
            current.next = prev
            prev = current
            current = next
        
        return prev
    
    # Recursive approach - reversing the next pointer
    def reverseList2(self, head):
        # base case
        if(head is None or head.next is None):
            return head
        
        newHead = self.reverseList2(head.next)
        head.next.next = head
        head.next = None
        return newHead
