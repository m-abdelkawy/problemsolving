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
        
        head: ListNode = None

        if(list1.val <= list2.val):
            head = list1
            list1.next =  mergeTwoLists(self, list1.next, list2)
        else:
            head = list2
            list2.next = mergeTwoLists(self, list1, list2.next)
        
        return head