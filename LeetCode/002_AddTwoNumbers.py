# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        result = ListNode(0)
        carry_on = 0
        last_node = result
        
        while l1 or l2 :
            if not l1:
                l1 = ListNode(0)
            if not l2:
                l2 = ListNode(0)
            last_node.next = ListNode((l1.val+l2.val+carry_on)%10)
            last_node = last_node.next
            carry_on = int((l1.val+l2.val+carry_on)/10)
            l1 = l1.next
            l2 = l2.next
            
        if carry_on == 1:
            last_node.next = ListNode(1)
            
        return result.next
