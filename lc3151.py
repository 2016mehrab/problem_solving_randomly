from typing import List


class Solution:
    def isArraySpecial(self, nums: List[int]) -> bool:
        for i in range(1,len(nums)):
            if not (nums[i-1]&1) ^ (nums[i]&1):
                return False
        return True
        
s = Solution()
print(s.isArraySpecial([1]))
print(s.isArraySpecial([2,1,4]))
print(s.isArraySpecial([4,3,1,6]))



