from typing import List


class Solution:
    def findMinIdx(self,nums):
        idx=0 
        m=nums[0]
        for i_, i in enumerate(nums):
            if i<m:
                m=i
                idx =i_
        return idx


    def check(self, nums: List[int]) -> bool:
        start = self.findMinIdx(nums)
        inversionCount =0
        size = len(nums)+start
        i=start

        while i < size:
            if not nums[i % len(nums)] <= nums[(i+1)% len(nums)]:
                inversionCount+=1

            i+=1

        return inversionCount<=1

s= Solution()
print(s.check([3,4,5,1,2]));
print(s.check([2,1,3,4]));
print(s.check([1,2,3]));
print(s.check([1,1,1]));
print(s.check([6,10,6]));

