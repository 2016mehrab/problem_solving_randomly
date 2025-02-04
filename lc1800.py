from typing import List


class Solution:
    def maxAscendingSum(self, nums: List[int]) -> int:
        l=0
        s=nums[l]
        maxSum=0
        for r in range(1,len(nums)):
            if nums[r] > nums[l]:
                s+=nums[r]
                l+=1
            else:
                maxSum= max(maxSum,s)
                s=nums[r]
                l=r
        return max(s,maxSum)

        

s= Solution()
print(s.maxAscendingSum([10,20,30,5,10,50]))
print(s.maxAscendingSum([10,20,30,40,50]))
print(s.maxAscendingSum([12,17,15,13,10,11,12]))

