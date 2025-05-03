from typing import List


# total subarrays - product greater or equal
class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        N = len(nums)
        totalSubArrays = N * (N+1)//2
        cnt =0
        greaterCnt=0
        l=0
        product=1
        for r in range(N):
            product*=nums[r]
            while l<=r and product>=k:
                greaterCnt+=N-r
                product//=nums[l]
                l+=1
        cnt = totalSubArrays -greaterCnt

        print(f"nums: {nums}, output: {cnt}")
        return cnt

s = Solution()
s.numSubarrayProductLessThanK(nums = [10,5,2,6], k = 100)
s.numSubarrayProductLessThanK(nums = [1,2,3], k = 0)
        
