# Problem: 86. Partition List
# Level: Medium
# Tags: LinkedList
# Link: https://leetcode.com/problems/partition-list
# Date Solved: 2025.11.15

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
    
class LinkedList(object):
    def __init__ (self, value):
        new_node = ListNode(value)
        self.head = new_node
        self.tail = new_node
        self.length = 1

    def append(self, value):
        new_node = ListNode(value)
        if self.head is None:
            self.head = new_node
            self.tail = new_node
        else:
            self.tail.next = new_node
            self.tail = new_node
        self.length += 1
        return True
    
    def __str__(self):
        res = []
        current = self.head
        while current:
            res.append(str(current.val))
            current = current.next
        return  " -> ".join(res)

#solution#
class Solution(object):
    

    def partition(self, head, x):
        less = ListNode(0)
        less_ptr = less
        greaterOrEqual = ListNode(0)
        greater_ptr = greaterOrEqual
        ptr = head
        while ptr:
            if ptr.val < x:
                less_ptr.next = ListNode(ptr.val)
                less_ptr = less_ptr.next
            else:
                greater_ptr.next = ListNode(ptr.val)
                greater_ptr = greater_ptr.next
            ptr = ptr.next
        #merge and clean
        if less.next:
            head = less.next
            less.next = None
            less_ptr.next = greaterOrEqual.next
        else:
            head = greaterOrEqual.next
        greaterOrEqual.next = None
        greater_ptr = less_ptr = None
        return head
    
    def partition2(self, head, x):
        less = less_ptr = ListNode(0)
        greaterOrEqual = greater_ptr = ListNode(0)
        while head:
            if head.val < x:
                less_ptr.next = head
                less_ptr = less_ptr.next
            else:
                greater_ptr.next = head
                greater_ptr = greater_ptr.next
            head = head.next
        # end the cycle by making the last node next as null
        greater_ptr.next = None
        less_ptr.next = greaterOrEqual.next
        greaterOrEqual.next = None
        return less.next




if __name__== "__main__":
    # define linked list 1 -> 4 -> 3 -> 2 -> 5 -> 2
    lst = LinkedList(1)
    lst.append(4)
    lst.append(3)
    lst.append(2)
    lst.append(5)
    lst.append(2)

    print("\nBefore partitioning: ")
    print(lst)

    sol = Solution()
    lst.head = sol.partition2(lst.head, 3)

    print("after partitioning: ")
    print(lst)
    