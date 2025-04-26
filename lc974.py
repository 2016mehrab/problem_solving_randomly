from typing import List
from collections import defaultdict


class Solution:
    def subarraysDivByKBF(self, nums: List[int], k: int) -> int:
        N = len(nums)
        sum=0
        cnt=0
        for i in range(N):
            sum=0
            for j in range(i,N):
                sum+=nums[j]
                if sum%k==0:
                    cnt+=1

        print(cnt)
        return cnt

    def subarraysDivByKAnotherBF(self, nums: List[int], k: int) -> int:
        N = len(nums)
        prefix = [0] *N
        sum=0
        cnt=0
        for i in range(N):
            sum+=nums[i]
            prefix[i]=sum

        sum=0
        for i in range(N):
            for j in range(i, N):
                if i!=0:
                    sum = prefix[j]- prefix[i-1]
                else : 
                    sum=prefix[j]
                if sum%k==0:
                    cnt+=1
        print(cnt)
        return cnt

    def subarraysDivByK(self, nums: List[int], k: int) -> int:
        seen_remainder=  defaultdict(int)
        sum=0
        cnt=0
        # if we encounter the next divisible by k , then will add 1
        seen_remainder[0] = 1
        for i in nums:
            sum+=i
            rem = sum%k
            if rem<0:
                while(rem<0):
                    rem= rem + k
            if rem in seen_remainder:
                # count of subarrays
                cnt+=seen_remainder[rem]
            else:
                seen_remainder[rem]=0
            seen_remainder[rem]+=1

        print(cnt)
        return cnt
s= Solution()
s.subarraysDivByK( nums = [4,5,0,-2,-3,1], k = 5)
s.subarraysDivByK( nums = [5], k = 9)
        
