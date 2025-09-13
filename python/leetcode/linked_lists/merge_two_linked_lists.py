# Problem: 21. Merge Two Sorted Lists
# Level: Easy
# Tags: LinkedList
# Link: https://leetcode.com/problems/merge-two-sorted-lists/
# Date Solved: 2025.07.13

class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class MergeTwoSortedLists:
    def mergeTwoLists(self, list1, list2):
        if(list1 == None):
            return list2
        if(list2 == None):
            return list1
        
        head = None

        if(list1.val <= list2.val):
            head = list1
            head.next =  self.mergeTwoLists(list1.next, list2)
        else:
            head = list2
            head.next = self.mergeTwoLists(list1, list2.next)
        
        return head
    
    def mergeTwoLists2(self, list1, list2):
        """
        :type list1: Optional[ListNode]
        :type list2: Optiazonal[ListNode]
        :rtype: Optional[ListNode]
        """
        head = ListNode(-1)
        ptr = head

        while(list1 is not None and list2 is not None):
            if list1.val <= list2.val:
                ptr.next = list1
                list1 = list1.next
            else:
                ptr.next = list2
                list2 = list2.next
            ptr = ptr.next
        ptr.next = list2 if list1 is None else list1
        return head.next