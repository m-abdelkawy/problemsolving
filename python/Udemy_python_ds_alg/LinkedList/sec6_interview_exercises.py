class Node:
    def __init__ (self, val = 0, next = None):
        self.val = val
        self.next = next

class LinkedList:
    def __init__ (self, value):
        new_node = Node(self, value)
        self.head = new_node
        self.tail = new_node
    
    def middleNode(self, head):
        slow = self.head
        fast = self.head
        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next
        return slow
    
    def append(self, value):
        new_node = Node(value)
        if self.head is None:
            self.head = new_node
            self.tail = new_node
        else:
            self.tail.next = new_node
            self.tail = new_node
        # self.length += 1
        return True
    
    def prepend(self, value):
        new_node = Node(value)
        new_node.next = self.head
        self.head = new_node
        if(self.is_empty):
            self.tail = new_node
        # self.length += 1
        return True

lst = LinkedList(1)
lst.append(2)
lst.append(3)
lst.append(4)
lst.append(5)
print('middle node: ' + str(lst.middleNode(lst.head).val))

lst.append(6)
print('middle node: ' + str(lst.middleNode(lst.head).val))
