from typing import List
from collections import defaultdict


class Solution:
    def countCompleteSubarrays(self, nums: List[int]) -> int:

        # need to use hashmap instead
        distincts =defaultdict(int) 
        for n in nums:
            distincts[n]+=1

        distCnt = len(distincts)
        slidingMap=defaultdict(int)
        l=0
        res=0
        N =len(nums)
        for i in range (N):
            slidingMap[nums[i]]+=1
            while len(slidingMap)==distCnt:
                res+= N -i
                slidingMap[nums[l]]-=1
                if slidingMap[nums[l]]==0:
                    del slidingMap[nums[l]]
                l+=1

        print(res)
        return  res 

s= Solution()
s.countCompleteSubarrays([1,3,1,2,2]);
s.countCompleteSubarrays([5,5,5,5]);
        
