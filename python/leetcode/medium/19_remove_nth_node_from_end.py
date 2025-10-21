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
        return " -> ".join(res)

class Solution(object):
    #2 pass solution O(n) time, O(1) space
    def removeNthFromEnd(self, head, n):
        sz = 0
        ptr = head
        while ptr:
            sz += 1
            ptr = ptr.next
        pos = sz - n + 1
        ptr = head
        prev = None
        for _ in range(pos - 1):
            prev = ptr
            ptr = ptr.next
        if pos == 1:
            head = head.next
        else:
            prev.next = ptr.next
        ptr.next = None
        return head
    
    # one pass, O(n) time, O(1) space
    def removeNthFromEnd2(self, head, n):
        dummy = ListNode(0, head)
        slow = fast = dummy

        for _ in range(n + 1):
            fast = fast.next

        while fast:
            slow = slow.next
            fast = fast.next
        
        slow.next = slow.next.next

        return dummy.next

if __name__ == "__main__":
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)

    print("original list: ")
    print(head)

    sol = Solution()
    n = 2
    sol.removeNthFromEnd(head, n)
    print(f"after removing node {n}")
    print(head)