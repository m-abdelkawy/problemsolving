# Problem: 83. Remove Duplicates from Sorted List
# Level: Easy
# Tags: LinkedList
# Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
# Date Solved: 2025.10.21

# Definition for singly linked list
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
    def __str__(self):
        res = []
        current = self
        while current:
            res.append(str(current.val))
            current = current.next
        return  " -> ".join(res)

class Solution(object):
    
    def deleteDuplicates_itiration1(self, head):
        current = head
        ptr = head
        while(ptr):
            while ptr.next and ptr.next.val == current.val:
                ptr.next = ptr.next.next
            ptr = ptr.next
            if(ptr is None):
                current = current.next
                ptr = current
        return head
    
    def deleteDuplicates_itiration2(self, head):
        current = head
        while current and current.next:
            if current.next.val==current.val:
                current.next=current.next.next
            else:
                current=current.next
        return head

if __name__ == "__main__":
    head = ListNode(1)
    head.next = ListNode(1)
    head.next.next = ListNode(2)
    head.next.next.next = ListNode(3)
    head.next.next.next.next = ListNode(3)

    print("original list: ")
    print(head)

    sol = Solution()

    sol.deleteDuplicates_itiration2(head)
    print("after removing duplicates: ")
    print(head)

    print("-------")
    head = ListNode(1)
    head.next = ListNode(1)
    head.next.next = ListNode(1)

    print("original list: ")
    print(head)

    sol = Solution()

    sol.deleteDuplicates_itiration2(head)
    print("after removing duplicates: ")
    print(head)
