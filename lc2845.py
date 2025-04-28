from typing import Counter
from collections import defaultdict


class Solution:
    def countInterestingSubarrays(
        self, nums: list[int], modulo: int, k: int
    ) -> int:
        N = len(nums)
        arr=[0] * N
        rem_to_cnt= defaultdict(int)
        rem_to_cnt[0]=1
        res = 0
        sum = 0
        for i in range(N):
            if nums[i] % modulo ==k :
                arr[i] = 1
        for i in arr:
            sum+= i
            find = (sum-k+modulo)%modulo
            res += rem_to_cnt[find]
            rem_to_cnt[sum%modulo] +=1

        
        print(f"input {nums}, {modulo}, {k}, output {res}")
        return res

s =Solution()
s.countInterestingSubarrays( nums = [3,2,4], modulo = 2, k = 1)
s.countInterestingSubarrays(nums = [3,1,9,6], modulo = 3, k = 0)
s.countInterestingSubarrays( nums = [3,4,3,3,3,4,3], modulo = 2, k = 1)
s.countInterestingSubarrays( nums = [3,3,3,3,3], modulo = 2, k = 1)
