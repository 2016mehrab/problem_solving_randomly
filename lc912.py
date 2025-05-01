from typing import List
import random


class Solution:
    def partition(self, nums, start , end):
        l= start
        pivot  = random.randint(start, end)
        nums[pivot] , nums[end] = nums[end] ,nums[pivot]
        for curr in range(l, end):
            if nums[curr] < nums[end]:
                nums[l], nums[curr] = nums[curr], nums[l]
                l+=1
        nums[end], nums[l] = nums[l], nums[end]
        return l

    def quickSort(self, nums , start, end):
        if start>= end:
            return

        n = list(nums)
        pivot = self.partition(nums,start,end)
        self.quickSort(nums ,start, pivot-1 )
        self.quickSort(nums ,pivot +1 , end)
        print(f"input: {n}, pivot:{nums[pivot]} ,output: {nums}")

    def merge(self, left, right):
        left_size=len(left)
        right_size=len(right)
        merged = []
        left_pointer = 0
        right_pointer = 0
        while left_pointer < left_size and right_pointer < right_size:
            if left[left_pointer] < right[right_pointer]:
                merged.append(left[left_pointer])
                left_pointer+=1
            else:
                merged.append(right[right_pointer])
                right_pointer+=1
        # append the rest of right array
        if left_pointer>= left_size:
            while right_pointer<right_size:
                merged.append(right[right_pointer])
                right_pointer+=1
        # append the rest of left array
        if right_pointer>= right_pointer:
            while left_pointer<left_size:
                merged.append(left[left_pointer])
                left_pointer+=1

        return merged


    def mergeSort(self, nums, start , end):
        if start== end:
            return [nums[start]]
        mid = (start+end)//2
        left = self.mergeSort(nums, start , mid)
        right = self.mergeSort(nums, mid+1 , end)
        return self.merge(left, right)

    def sortArray(self, nums: List[int]) -> List[int]:
        n = list(nums)
        sortedList =  self.mergeSort(nums,0, len(nums)-1)
        print(f"input: {nums},output: {sortedList}")
        return sortedList
        
s= Solution()
s.sortArray(nums = [5,2,3,1])
s.sortArray(nums = [5,1,1,2,0,0])
