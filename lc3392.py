from typing import List


class Solution:
    def countSubarrays(self, nums: List[int]) -> int:
        l=0
        cnt= 0
        for r in range(2,len(nums)):
            if (nums[l] + nums[r]) * 2 == nums[r-1]:
                cnt+=1
            l+=1
        
        return cnt

s= Solution()

s.countSubarrays( nums = [1,2,1,4,1])
        
