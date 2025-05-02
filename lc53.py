from typing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        currMax = 0
        res = nums[0]
        for i in range(len(nums)):
            currMax+= nums[i]
            res = max(currMax,res)
            currMax = max(currMax,0)

        return res
        
