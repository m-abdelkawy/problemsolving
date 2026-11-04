# Problem: 1290. Convert Binary Number in a Linked List to Integer
# Level: Easy
# Tags: LinkedList
# Link: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer
# Date Solved: 2025.11.13

# Definition for singly linked list
import math


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

    def getDecimalValue2(self, head):
        head = self.reverse(head)
        ptr = head
        value = 0
        pos = 0
        while ptr:
            value += ptr.val * math.pow(2, pos)
            pos += 1
            ptr = ptr.next
        return int(value)
    
    def getDecimalValue(self, head):
        ptr = head
        value = 0
        pos = 0
        while ptr:
            value += ptr.val * math.pow(2, pos)
            pos += 1
            ptr = ptr.next
        return value
    
    def reverse(self, head):
        previous = None
        current = head
        while current:
            next = current.next
            current.next = previous
            previous = current
            current = next
        return previous
    
    def getDecimalValue3(self, head):
        str_val = ""
        ptr = head
        while ptr:
            str_val += str(ptr.val)
            ptr = ptr.next
        return int(str_val, 2)
    
    def getDecimalValue4(self, head):
        # Steps:
        # shift result (start with 0 - in binary) left by one bit (means doubling the number in decimals)
        # add the coming bit (OR, does adding in this case since we add 0 to the right when we shift left and drop the left most bit)
        ptr = head
        res = 0
        while ptr:
            res = (res << 1) | ptr.val
            ptr = ptr.next
        return res

if __name__ == "__main__":
    head = ListNode(1)
    head.next = ListNode(1)
    head.next.next = ListNode(0)
    head.next.next.next = ListNode(1)
    # head.next.next.next.next = ListNode(1)

    print("original list: ")
    print(head)

    sol = Solution()

    # head = sol.reverse(head)
    # print("after reversing ")
    # print(head)

    value = sol.getDecimalValue4(head)
    print(f"decimal value: {value}")

