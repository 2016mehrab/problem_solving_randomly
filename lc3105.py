from typing import List


class Solution:
    def longestMonotonicSubarray(self, nums: List[int]) -> int:
        incLen=1
        maxLen=1
        decLen=1
        for i in range(len(nums)-1):
            if nums[i] == nums[i+1]:
                incLen=1
                decLen=1
                continue
            if nums[i+1] > nums[i]:
                incLen+=1
                decLen=1
            else:
                incLen=1
                decLen+=1
            maxLen=max(maxLen, incLen, decLen)
        return maxLen


s= Solution()
print(s.longestMonotonicSubarray([1,4,3,3,2]))
print(s.longestMonotonicSubarray( [3,3,3,3]))
print(s.longestMonotonicSubarray([3,2,1]))

