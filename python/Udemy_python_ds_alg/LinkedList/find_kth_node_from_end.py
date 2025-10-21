class Node:
    def __init__(self, value):
        self.value = value
        self.next = None
    
class LinkedList:
    def __init__(self, value):
        new_node = Node(value)
        self.head = new_node
        self.tail = new_node

    def append(self, value):
        new_node = Node(value)
        if self.head == None:
            self.head = new_node
            self.tail = new_node
        else:
            self.tail.next = new_node
            self.tail = new_node
        return True
        
def find_kth_from_end(ll, k):
    sz = 0
    ptr = ll.head
    while ptr:
        sz += 1
        ptr = ptr.next
    print(ptr)
    print(sz)
    ptr = ll.head
    pos = sz - k + 1
    for _ in range(pos - 1):
        ptr = ptr.next
    return ptr

if __name__ == "__main__":
    my_linked_list = LinkedList(1)
    my_linked_list.append(2)
    my_linked_list.append(3)
    my_linked_list.append(4)
    my_linked_list.append(5)

    k = 2
    res = find_kth_from_end(my_linked_list, k)
    expected = 4
    assert res.value == expected, f"Expected {expected}, got {res.value}"
    print(f"Test passed, node {k} from the end is {res.value}")
