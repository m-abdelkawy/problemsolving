# Problem: 876. Middle of the Linked List
# Level: Easy
# Tags: LinkedList
# Link: https://leetcode.com/problems/middle-of-the-linked-list
# Date Solved: 2025.09.13

class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class LinkedList(object):
    # def __init__ (self, val = 0):
    #     new_node = ListNode(val)
    #     self.head = new_node
    #     self.tail = new_node

    # slow and fast pointers approach
    def middleNode1(self, head):
        slow = head
        fast = head
        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next
        return slow
    
    # array approach
    def middleNode2(self, head):
        arr = [head]
        while arr[-1].next:
            arr.append(arr[-1].next)
        return arr[len(arr)//2]
        
node1 = ListNode(1)
node2 = ListNode(2)
node3 = ListNode(3)
node4 = ListNode(4)
node5 = ListNode(5)

node1.next = node2
node2.next = node3
node3.next = node4
node4.next = node5

lst = LinkedList()
print('middle node 1: ' + str(lst.middleNode1(node1).val))
print('middle node 2: ' + str(lst.middleNode2(node1).val))