from typing import List
class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        N= len(nums)
        cnt=0
        l=0
        sum=0
        for r in range(N):
            sum+=nums[r]
            while l <= r and sum * (r-l+1) >= k:
                sum-= nums[l]
                l+=1
            if sum * (r-l+1) < k:
                cnt += (r-l+1)

        print(f"{nums}, {k} : {cnt}")
        return  cnt

s=  Solution()
s.countSubarrays(nums = [2,1,4,3,5], k = 10)
s.countSubarrays( nums = [1,1,1], k = 5)
