from typing import Optional
import random


class ListNode:
     def __init__(self, val=0, next=None):
         self.val = val
         self.next = next

class Solution:
    def mergeSort(self,head):
        if not head or not head.next:
            return head

        slow = head
        fast = head
        prev= head
        while fast and fast.next:
            prev = slow
            slow= slow.next
            fast= fast.next.next

        prev.next = None
        left = self.mergeSort(head)
        right = self.mergeSort(slow)
        return self.merge(left, right)

    def  merge(self,left,right):
        l1 = left
        l2 = right
        dummy = ListNode()
        tail = dummy
        while l1 and l2:
            if l1.val<l2.val:
                tail.next = l1
                tail = tail.next
                l1 = l1.next
            else :
                tail.next = l2
                tail = tail.next
                l2 = l2.next
        tail.next = l1 or l2
        return dummy.next



    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        return self.mergeSort(head)

    def partition(self,nums,start, end):
        n=list(nums)
        pivot = random.randint(start, end)
        nums[end],nums[pivot]= nums[pivot] ,nums[end] 
        l=start
        for i in range( start, end):
            if nums[i]<nums[end]:
                nums[l], nums[i] = nums[i] , nums[l]
                l+=1
        nums[l], nums[end] = nums[end] , nums[l]
        print(f"{n}, pivot:{nums[l]} ->{nums}")
        return l

    def arrSortList(self,nums,start,size):
        if start>=size-1:
            return
        pivot = self.partition(nums, start, size-1)
        # left subarray
        self.arrSortList(nums,start, pivot)
        # right subarray
        self.arrSortList(nums,pivot+1, size)

        
        

    def createList(self, nums=[]):
        head = ListNode(nums[0])
        tail= head
        for i in range(1,len(nums)):
            tmp = ListNode(nums[i])
            tail.next= tmp
            tail = tmp
        h = head
        while h:
            print(f"node[ val={h.val} link->{h.next}]")
            h= h.next
        
        h = self.mergeSort(head)
        while h:
            print(f"node[ val={h.val} link->{h.next}]")
            h= h.next


s= Solution()
s.createList([4,2,1,3])
n=[7,9,2,5,1,4]
# s.arrSortList(n,0,6)
# print (n)
        
