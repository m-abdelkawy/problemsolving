class Node:
    def __init__ (self, value):
        self.value = value
        self.next = None

class LinkedList:
    def __init__ (self, value):
        new_node = Node(value)
        self.head = new_node
        self.tail = new_node
        self.length = 1

    def append(self, value):
        new_node = Node(value)
        if self.head is None:
            self.head = new_node
            self.tail = new_node
        else:
            self.tail.next = new_node
            self.tail = new_node
        self.length += 1
        return True
    
    def prepend(self, value):
        new_node = Node(value)
        new_node.next = self.head
        self.head = new_node
        if(self.is_empty):
            self.tail = new_node
        self.length += 1
        return True

    def print_list(self):
        if(self.length == 0):
            print("List is Empty!!")
            return
        ptr = self.head
        while ptr is not None:
            print(ptr.value, end=" ")
            ptr = ptr.next
        print()

    def get_list(self):
        current = self.head
        values = []
        while current is not None:
            values.append(str(current.value))
            current = current.next
        return values


    def pop(self):
        if self.is_empty():
            res = None
        elif self.length == 1:
            res = self.tail
            self.head = None
            self.tail = None
        else:
            ptr = self.head
            while ptr.next.next is not None:
                ptr=ptr.next
            self.tail = ptr
            res = self.tail.next
            self.tail.next = None
        if self.length > 0:    
            self.length -= 1
        return res
    
    def pop_first(self):
        res = self.head
        if(not self.is_empty()):
            self.head = self.head.next
            res.next = None
            self.length -= 1
            if(self.length == 0):
                self.tail = None
        return res
    
    def get(self, index):
        if index < 0 or index >= self.length:
            return None
        ptr = self.head
        for _ in range(index):
            ptr = ptr.next
        return ptr
    
    def set_value(self, index, value):
        ptr = self.get(index)
        if ptr:
            ptr.value = value
            return True
        return False
    
    def insert(self, index, value):
        if index < 0 or index > self.length:
            return False
        if index == 0:
            return self.prepend(value)
        if index == self.length:
            return self.append(value)
        new_node = Node(value)
        ptr = self.get(index - 1)
        new_node.next = ptr.next
        ptr.next = new_node
        self.length += 1
        return True
    
    def remove(self, index):
        if index < 0 or index >= self.length:
            return None
        if index == 0:
            return self.pop_first()
        if index == self.length - 1:
            return self.pop()
        prev = self.get(index - 1)
        current = prev.next
        prev.next = current.next
        current.next = None
        self.length -= 1
        return current
    
    def reverse1(self):
        current = self.head
        after = current.next
        before = None
        for _ in range(self.length):
            current.next = before
            before = current
            current = after
            if after:
                after = after.next
        self.tail = self.head
        self.head = before
        return self.head
    
    def reverse2(self):
        prev = None
        self.tail = self.head
        current = self.head
        while current:
            next_node = current.next
            current.next = prev
            prev = current
            current = next_node
        self.head = prev
            


    def is_empty(self):
        return self.length == 0


lst = LinkedList(4)
lst.pop()
print(f"list: {" ".join(lst.get_list())}")
# lst: LinkedList = None
# lst.append(5)
# print(lst)
# print(lst.head.value)

# lst.print_list()

# print("popped element: " + str(lst.pop().value))
# lst.print_list()

# print(f"popped elelment: {lst.pop().value}")
# lst.print_list()

lst.prepend(9)
print(f"list: {" ".join(lst.get_list())}")

lst.prepend(12)
print(f"list: {" ".join(lst.get_list())}")

lst.prepend(7)
print(f"list: {" ".join(lst.get_list())}")

lst.prepend(8)
print(f"list: {" ".join(lst.get_list())}")

#----- pop_first
# print(f"popped: {lst.pop_first().value}")
# print(f"list: {" ".join(lst.get_list())}")

# print(f"popped: {lst.pop_first().value}")
# print(f"list: {" ".join(lst.get_list())}")

# print(f"popped: {lst.pop_first().value}")
# print(f"list: {" ".join(lst.get_list())}")

# print(f"popped: {lst.pop_first().value}")
# print(f"list: {" ".join(lst.get_list())}")

#----- get

print(lst.get(-1).value if lst.get(-1) is not None else None)
print(lst.get(0).value)
print(lst.get(1).value)
print(lst.get(2).value)
print(lst.get(3).value)
print(lst.get(4).value if lst.get(4) is not None else None)

#--- set(self, index, value)
# print(f"list: {" ".join(lst.get_list())}")
# node_set = lst.set_value(5, 4)
# print(f"set: {node_set.value if node_set is not None else None}")
# print(f"list: {" ".join(lst.get_list())}")

#--- remove(self, index)
print("trying remove(self, index)")
print(f"list: {" ".join(lst.get_list())}")
print(f"removed: {lst.remove(2).value}")
print(f"list: {" ".join(lst.get_list())}")
print(f"removed: {lst.remove(2).value}")
print(f"list: {" ".join(lst.get_list())}")
print(f"removed: {lst.remove(0).value}")
print(f"list: {" ".join(lst.get_list())}")
print(f"removed: {lst.remove(0).value}")
print(f"list: {" ".join(lst.get_list())}")
node_removed = lst.remove(0)
print(f"removed: {node_removed.value if node_removed is not None else None}")
print(f"list: {" ".join(lst.get_list())}")