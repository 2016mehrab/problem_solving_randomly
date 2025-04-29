from typing import List
# nums positive
# k positive
# max element of subarray cnt >= k
class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        cnt =0
        l = 0
        maxEl = max(nums)
        maxCnt=0
        N = len(nums)
        for r in range(N):
            if nums[r]== maxEl:
                maxCnt+=1
            
            while maxCnt == k:
                cnt+= N - r
                if nums[l]== maxEl:
                    maxCnt-=1
                l+=1

        print(f"{nums}, {k} : {cnt}")
        return cnt

s=  Solution()
s.countSubarrays( nums = [1,3,2,3,3], k = 2)
s.countSubarrays( nums = [1,4,2,1], k = 3)
        
