# Problem: 445. Add Two Numbers II
# Level: Medium
# Tags: LinkedList
# Link: https://leetcode.com/problems/add-two-numbers-ii/description
# Date Solved: 2025.11.08

# Definition for singly linked list
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
    
    def addTwoNumbers(self, l1, l2):
        #convert l1 to number a
        l1 = self.reverse(l1)
        multiplier = 1
        a = 0
        while l1:
            a += l1.val * multiplier
            multiplier *= 10
            l1 = l1.next
        
        #convert l2 to number b
        l2 = self.reverse(l2)
        multiplier = 1
        b = 0
        while l2:
            b += l2.val * multiplier
            multiplier *= 10
            l2 = l2.next

        #sum and convert sum to linked list
        sum = a + b
        if sum == 0:
            return ListNode(0)

        dummyHead = ListNode(0)
        current = dummyHead

        while sum > 0:
            current.next = ListNode(sum % 10)
            sum = sum // 10
            current = current.next
        return self.reverse(dummyHead.next)
    
    def reverse(self, head):
        prev = None
        current = head
        next = None

        while current is not None:
            next = current.next
            current.next = prev
            prev = current
            current = next
        return prev

    

if __name__ == "__main__":
    l1 = ListNode(2)
    l1.next = ListNode(4)
    l1.next.next = ListNode(3)
    
    
    l2 = ListNode(5)
    l2.next = ListNode(6)
    l2.next.next = ListNode(4)


    print("original lists: ")
    print(l1)
    print(l2)

    sol = Solution()

    sum = sol.addTwoNumbers(l1, l2)
    print("after addition: ")
    print(sum)
