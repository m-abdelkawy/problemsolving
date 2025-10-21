# Problem: 141. Linked List Cycle
# Level: Easy
# Tags: LinkedList
# Link: https://leetcode.com/problems/linked-list-cycle
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
    def hasCycle1(self, head):
        slow = head
        fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if(slow == fast):
                return True
        return False
    
    # set/hashtable approach to check if a node has been visited before
    def hasCycle2(self, head):
        nodes_seen = set()
        ptr = head
        while ptr:
            if ptr in nodes_seen:
                return True
            nodes_seen.add(ptr)
            ptr = ptr.next
        return False
    
    def hasCycle3(self, head):
        if not head:
            return False
        slow = head
        fast = head.next
        while slow != fast:
            if not fast or not fast.next:
                return False
            slow = slow.next
            fast = fast.next.next
        return True
        
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
lst.hasCycle1(node1)
print('has cycle1 (false expected): ' + str(lst.hasCycle1(node1)))
print('has cycle2 (false expected): ' + str(lst.hasCycle2(node1)))

node4.next = node1
print('has cycle1- (true expected): ' + str(lst.hasCycle1(node1)))
print('has cycle2- (true expected): ' + str(lst.hasCycle2(node1)))