# Problem: 19. Remove Nth Node From End of List
# Level: Medium
# Tags: LinkedList
# Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list
# Date Solved: 2025.09.19

class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class LinkedList:
    def __init__ (self, value):
        new_node = ListNode(value)
        self.head = new_node
        self.tail = new_node

    def append(self, value):
        new_node = ListNode(value)
        if self.head is None:
            self.head = new_node
            self.tail = new_node
        else:
            self.tail.next = new_node
            self.tail = new_node
        return True

    def removeNthFromEnd(self, n):
        sz = 0
        ptr = self.head
        while ptr:
            sz += 1
            ptr = ptr.next
        pos = sz - n + 1
        ptr = self.head
        prev = None
        for _ in range(pos-1):
            prev = ptr
            ptr = ptr.next
        if pos == 1:
            self.head = self.head.next
        else:
            prev.next = ptr.next
            ptr.next = None
        return self.head
    
    def removeNthFromEnd_lt(self, head, n):
        """
        :type head: Optional[ListNode]
        :type n: int
        :rtype: Optional[ListNode]
        """
        sz = 0
        ptr = head
        while ptr:
            sz += 1
            ptr = ptr.next
        pos = sz - n + 1
        ptr = head
        prev = None
        for _ in range(pos-1):
            prev = ptr
            ptr = ptr.next
        if pos == 1:
            head = head.next
        else:
            prev.next = ptr.next
            ptr.next = None
        return head
    
    def print_list(self):
        if not self.head:
            print('list is empty!')
        ptr = self.head
        while ptr:
            print(ptr.val, end=" ")
            ptr = ptr.next
        print()
    
lst = LinkedList(1)
lst.append(2)
# lst.append(3)
# lst.append(4)
# lst.append(5)

lst.print_list()
        
lst.removeNthFromEnd(2)
lst.print_list()